package com.yitihua3.exam.controller.user;

import com.yitihua3.exam.entity.user.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("注册Controller")
@RestController
public class RegisterController {
    @ApiOperation(value = "添加密码",  notes = "可用于添加密码",httpMethod = "POST")
    @PostMapping("addPassword")
    public User addPassword(@ApiParam(name="password",value="密码",required=true) String password) {
        return null;
    }

    @ApiOperation(value = "添加性别",  notes = "可用于添加性别",httpMethod = "POST")
    @PostMapping("addSex")
    public User addSex(@ApiParam(name="sex",value="性别",required=false,defaultValue = "0")Integer sex) {
        return null;
    }

    @ApiOperation(value = "添加邮箱",  notes = "可用于添加邮箱",httpMethod = "POST")
    @PostMapping("addEmail")
    public User addEmail(@ApiParam(name="email",value="邮箱",required=true) String  email) {
        return null;
    }

    @ApiOperation(value = "添加生日",  notes = "可用于添加生日",httpMethod = "POST")
    @PostMapping("addBirthday")
    public User addBirthday(@ApiParam(name="birthday",value="生日",required=false,defaultValue = "2000-1-1") String  birthday) {
        return null;
    }


    @ApiOperation(value = "添加手机号码",  notes = "可用于添加手机号码",httpMethod = "POST")
    @PostMapping("addPhone")
    public User addPhone(@ApiParam(name="phone",value="手机号码",required=true) String pohone) {
        return null;
    }

    @ApiOperation(value = "添加班级编号",  notes = "可用于添加班级编号",httpMethod = "POST")
    @PostMapping("addClassId")
    public User addClassId(@ApiParam(name="classId",value="班级编号",required=true) String classId) {
        return null;
    }
}
