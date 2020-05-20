package com.yitihua3.exam.shiro.restful;

import com.yitihua3.exam.response.ResultGenerator;
import com.yitihua3.exam.service.user.JWTService;
import com.yitihua3.exam.shiro.token.JWTToken;
import com.yitihua3.exam.utils.JWTUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class JWTFilter extends AuthenticatingFilter {

    private static final int tokenRefreshInterval = 300;

    private Logger log = LoggerFactory.getLogger(this.getClass());

    private JWTService jwtService;

    public JWTFilter(JWTService jwtService){
        this.jwtService = jwtService;
        this.setLoginUrl("/shiroLogin");
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        if(this.isLoginRequest(request, response))
            return true;
        boolean allowed = false;
        try {
            allowed = executeLogin(request, response);
        } catch(IllegalStateException e){ //not found any token
            log.error("Not found any token");
        }catch (Exception e) {
            log.error("Error occurs when login", e);
        }
        return allowed || super.isPermissive(mappedValue);
    }

    @Override
    protected AuthenticationToken createToken(ServletRequest servletRequest, ServletResponse servletResponse) {
        String jwtToken = StringUtils.removeStart(getAuthorizationHeader(servletRequest), "Bearer ");
        if(StringUtils.isNotBlank(jwtToken)&&!JWTUtils.isTokenExpired(jwtToken))
            return new JWTToken(jwtToken);
        return null;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) {
        response401(servletResponse,"请先登录");
        return false;
    }

    /**
     * 无需转发，直接返回Response信息
     */
    private void response401(ServletResponse response, String msg) {
        HttpServletResponse httpServletResponse = WebUtils.toHttp(response);
        httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json; charset=utf-8");
        try (PrintWriter out = httpServletResponse.getWriter()) {
            String data = ResultGenerator.genFailedResult(HttpStatus.UNAUTHORIZED.value(), "无权访问(Unauthorized):" + msg).toString();
            out.append(data);
        } catch (IOException e) {
            log.error("直接返回Response信息出现IOException异常:{}", e.getMessage());
            throw new RuntimeException("直接返回Response信息出现IOException异常:" + e.getMessage());
        }
    }

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        String newToken = null;
        if(token instanceof JWTToken){
            JWTToken jwtToken = (JWTToken)token;
            String username =  subject.getPrincipal().toString();
            boolean shouldRefresh = shouldTokenRefresh(JWTUtils.getIssuedAt(jwtToken.getToken()));
            if(shouldRefresh) {
                newToken = jwtService.generateJWTToken(username);
            }
        }
        if(StringUtils.isNotBlank(newToken))
            setAuthorizationHeader(response,newToken);
        return true;
    }

    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        log.error("Validate token fail, token:{}, error:{}", token.toString(), e.getMessage());
        return false;
    }

    protected void setAuthorizationHeader(ServletResponse response,String newToken) {
        HttpServletResponse httpResponse = WebUtils.toHttp(response);
        httpResponse.setHeader("Authorization", newToken);
    }

    protected String getAuthorizationHeader(ServletRequest request) {
        HttpServletRequest httpRequest = WebUtils.toHttp(request);
        String header = httpRequest.getHeader("Authorization");
        return header;
    }

    protected boolean shouldTokenRefresh(Date issueAt){
        LocalDateTime issueTime = LocalDateTime.ofInstant(issueAt.toInstant(), ZoneId.systemDefault());
        return LocalDateTime.now().minusSeconds(tokenRefreshInterval).isAfter(issueTime);
    }
}
