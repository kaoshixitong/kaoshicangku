package com.yitihua3.exam.controller.user;

import com.yitihua3.exam.entity.user.Student;
import com.yitihua3.exam.entity.user.User;
import com.yitihua3.exam.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @ApiOperation(value = "修改个人信息",notes = "可用于修改个人信息",httpMethod = "PUT")
    @GetMapping("updateInfo")
    public User updateInfo(@ApiParam(name="username",value="用户名",required=true,type = "String")
                                       String username,
                           @ApiParam(name="password",value="密码",required=true,type = "String") String password,
                           @ApiParam(name="birthday",value="出生日期",required=true,defaultValue = "2000-1-1",type = "String") String birthday,
                           @ApiParam(name="email",value="邮箱",required=true,type = "String") String email,
                           @ApiParam(name="sex",value="性别",required=true,defaultValue = "0",type = "Integer") Integer sex,
                           @ApiParam(name="phone",value="手机号码",required=true,type = "String") String phone,
                           @ApiParam(name="classId",value="班级编号",required=true,type = "Integer") Integer classId){

        return null;
    }

    @ApiOperation(value = "删除个人信息",notes = "删除个人信息",httpMethod = "DELETE")
    @GetMapping("deleteInfo")
    public User deleteInfo(@ApiParam(name = "userId",value = "用户编号",required = true)Integer userId){
        return null;
    }

    @ApiOperation(value = "列举所有用户信息",notes = "列举所有用户信息",httpMethod = "GET")
    @GetMapping("queryAll")
    public List<User> queryAll(){
        return  null;
    }

}