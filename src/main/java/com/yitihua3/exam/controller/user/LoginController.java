package com.yitihua3.exam.controller.user;

import com.yitihua3.exam.dto.user.LoginDTO;
import com.yitihua3.exam.response.Result;
import com.yitihua3.exam.response.ResultGenerator;
import com.yitihua3.exam.service.user.JWTService;
import com.yitihua3.exam.shiro.token.RoleToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author zhangjl
 * @Type LoginController
 * @Desc
 * @date 2020年04月23日
 * @Version V1.0
 */
@Api(value="登录controller")
@RestController
public class LoginController {

    @Autowired
    JWTService jwtService;

    @ApiOperation(value = "用户登录",  notes = "用于用户登录",httpMethod = "POST")
    @PostMapping("/shiroLogin")
    public Result shiroLogin(
            @ApiParam(name="loginDTO",value="用户名",required=true)
                    LoginDTO loginDTO,
            HttpServletResponse response)
    {
        //获取当前用户
        Subject subject= SecurityUtils.getSubject();
        RoleToken token=new RoleToken(loginDTO);
        //封装用户的登录数据
        subject.login(token);
        String newToken = jwtService.generateJWTToken(loginDTO.getUsername());
        response.setHeader("Authorization", newToken);
        return ResultGenerator.genOkResult();
    }
}
