package com.yitihua3.exam.controller.user;

import com.yitihua3.exam.dto.user.LoginDTO;
import com.yitihua3.exam.dto.user.RegisterDTO;
import com.yitihua3.exam.entity.user.User;
import com.yitihua3.exam.response.Result;
import com.yitihua3.exam.response.ResultGenerator;
import com.yitihua3.exam.service.user.JWTService;
import com.yitihua3.exam.service.user.RegisterService;
import com.yitihua3.exam.service.user.UserService;
import com.yitihua3.exam.shiro.token.RoleToken;
import com.yitihua3.exam.utils.DTOConverterUtils;
import com.yitihua3.exam.utils.IDUtils;
import io.swagger.annotations.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author zhangjl
 * @Type LoginController
 * @Desc
 * @date 2020年04月23日
 * @Version V1.0
 */
@Api(value="登录controller",tags={"登录注册注销操作接口"})
@RestController
public class LoginController {

    @Autowired
    JWTService jwtService;

    @ApiResponses({
            @ApiResponse(code = 200, message = "HTTP状态码，返回值JSON code字段值，描述：成功"),
            @ApiResponse(code = 4002, message = "非HTTP状态码，返回值JSON code字段值，描述：认证异常")
    })

    @ApiOperation(value = "用户登录",  notes = "用于用户登录",httpMethod = "POST")
    @PostMapping("/login")
    public Result login(
            @ApiParam(name="loginDTO",value="登录对象",required=true)
            @RequestBody LoginDTO loginDTO,
            HttpServletResponse response)
    {
        //获取当前用户
        Subject subject= SecurityUtils.getSubject();
        RoleToken token=new RoleToken(loginDTO);
        //封装用户的登录数据
        subject.login(token);
        User user = jwtService.getSubjectUser();
        //生成jwt token
        String newToken = jwtService.generateJWTToken(user);
        response.setHeader("Authorization", newToken);
        return ResultGenerator.genOkResult();
    }

    @ApiOperation(value = "用户注销",  notes = "用于用户注销",httpMethod = "GET")
    @GetMapping("/logout")
    public Result logout()
    {
        //获取当前用户
        Subject subject= SecurityUtils.getSubject();

        if(subject.getPrincipals() != null) {
            User user = jwtService.getSubjectUser();
            //删除盐值
            jwtService.deleteLoginInfo(user.getUsername());
        }
        subject.logout();
        return ResultGenerator.genOkResult();
    }

    @Autowired
    UserService userService;

    @Autowired
    RegisterService registerService;

    @ApiResponses({
            @ApiResponse(code = 200, message = "HTTP状态码，返回值JSON code字段值，描述：成功"),
            @ApiResponse(code = 4007, message = "非HTTP状态码，返回值JSON code字段值，描述：注册异常")
    })

    @ApiOperation(value = "用户注册",  notes = "注册对象",httpMethod = "POST")
    @PostMapping("/register")
    public Result register(
            @ApiParam(name="registerDTO",value="注册对象",required=true) @RequestBody
            @Validated RegisterDTO registerDTO){
        User user = DTOConverterUtils.commonConverter(registerDTO, User.class);
        registerService.check(registerDTO);
        User encrypt = registerService.encrypt(user);
        user.setActiveStatus(0);
        String activeCode = IDUtils.getUUID();
        user.setActiveCode(activeCode);
        userService.insertUser(user);
        return ResultGenerator.genOkResult();
    }
}
