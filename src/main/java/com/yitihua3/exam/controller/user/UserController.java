package com.yitihua3.exam.controller.user;

import com.yitihua3.exam.entity.user.User;
import com.yitihua3.exam.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2020-04-17 22:01:20
 */
@Api(value = "用户的controller")
@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    @ApiOperation(value = "根据用户名查询用户",  notes = "可用于注册时登录查重",httpMethod = "GET")
    @GetMapping("queryUsername")
    public User queryUser(
            @ApiParam(name="username",value="用户名",required=true)
                    String username) {
        return null;
    }

    @ApiOperation(value = "添加用户",  notes = "可用于管理员添加学生或教师",httpMethod = "POST")
    @PostMapping("addUser")
    public User addUser(@ApiParam(name="username",value="用户名",required=true)User user) {
        return null;
    }
}