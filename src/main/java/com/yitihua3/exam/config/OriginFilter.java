package com.yitihua3.exam.config;

import com.yitihua3.exam.shiro.restful.JWTFilter;
import org.apache.shiro.web.filter.authc.AnonymousFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 全局跨域放开
 *
 * @author wliduo[i@dolyw.com]
 * @date 2019/11/26 14:29
 */
//@Component
public class OriginFilter extends AnonymousFilter {

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) {
        HttpServletRequest httpServletRequest = WebUtils.toHttp(request);
        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name()))
            return false;
        return super.onPreHandle(request, response, mappedValue);
    }

    @Override
    protected void postHandle(ServletRequest request, ServletResponse response){
        JWTFilter.fillCorsHeader(WebUtils.toHttp(request), WebUtils.toHttp(response));
    }
}
