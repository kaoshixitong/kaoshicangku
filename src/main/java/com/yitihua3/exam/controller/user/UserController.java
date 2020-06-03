package com.yitihua3.exam.controller.user;

import com.alibaba.fastjson.JSONObject;
import com.yitihua3.exam.entity.user.User;
import com.yitihua3.exam.exception.ClientException;
import com.yitihua3.exam.response.Result;
import com.yitihua3.exam.response.ResultCode;
import com.yitihua3.exam.response.ResultGenerator;
import com.yitihua3.exam.service.user.UserService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2020-04-17 22:01:20
 */
@Api(value = "用户的controller",tags={"用户操作接口"})
@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    @ApiResponses({
            @ApiResponse(code = 200, message = "HTTP状态码，返回值JSON code字段值，描述：成功"),
            @ApiResponse(code = 4008, message = "非HTTP状态码，返回值JSON code字段值，描述：注册异常")
    })

    @ApiOperation(value = "根据用户名查询用户",  notes = "可用于注册时登录查重",httpMethod = "GET")
    @GetMapping("queryUsername")

    @ApiImplicitParam(name="username",value="用户名",required=true,example = "小明")

    public Result queryUser(
            @RequestBody(required = false) @ApiIgnore JSONObject jsonObject) {
        String username = jsonObject.getString("username");
        User user = userService.selectByUsername(username);
        if(user!=null)
            throw new ClientException(ResultCode.REGISTER_EXCEPTION,"用户名已存在");
        return ResultGenerator.genOkResult("用户名可用");
    }
}