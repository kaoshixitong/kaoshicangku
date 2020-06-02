package com.yitihua3.exam.controller.user;

import com.yitihua3.exam.dto.user.TeacherInformationDTO;
import com.yitihua3.exam.entity.user.Teacher;
import com.yitihua3.exam.entity.user.User;
import com.yitihua3.exam.response.Result;
import com.yitihua3.exam.response.ResultGenerator;
import com.yitihua3.exam.service.user.JWTService;
import com.yitihua3.exam.service.user.TeacherService;
import com.yitihua3.exam.service.user.UserService;
import com.yitihua3.exam.utils.DTOConverterUtils;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author aiwoqe
 * @Type TeacherController
 * @Desc
 * @date 2020年05月24日
 * @Version V1.0
 */
@Api(value = "用户的教师的controller",tags={"教师操作接口"})
@RestController
@RequestMapping("/user/teacher")
public class TeacherController {

    @Resource
    UserService userService;

    @Resource
    JWTService jwtService;

    @Resource
    private TeacherService teacherService;



    @ApiOperation(value = "查询教师用户的个人信息",  notes = "可用于教师个人信息的查询",httpMethod = "GET")
    @GetMapping("queryInformation")
    public Result<TeacherInformationDTO> queryInformation() {
        User user = jwtService.getSubjectUser();
        Teacher teacher = teacherService.selectTeacherByUser(user.getUserId());
        TeacherInformationDTO teacherInformation = DTOConverterUtils.commonConverter(user, TeacherInformationDTO.class);
        teacherInformation.setTeacher(teacher);
        return ResultGenerator.genOkResult("查询个人信息成功",teacherInformation);
    }

    @ApiOperation(value = "修改教师用户的个人信息",  notes = "可用于教师个人信息的修改",httpMethod = "PUT")
    @PutMapping("updateInformation")
    public Result updateInformation(@RequestBody(required = false)
            @ApiParam(name="teacherInformationDTO",value="修改教师个人信息对象",required=true)
                    TeacherInformationDTO teacherInformationDTO
    ) {
        User user = jwtService.getSubjectUser();
        user.setUsername(teacherInformationDTO.getUsername());
        userService.updateUser(user);
        Teacher teacher = teacherInformationDTO.getTeacher();
        teacher.setUserId(user.getUserId());
        teacherService.updateByUser(teacher);
        return ResultGenerator.genOkResult("修改个人信息成功");
    }

    @ApiOperation(value = "可用于教师个人信息与账号的绑定",  notes = "修改教师的用户id",httpMethod = "PUT")
    @PutMapping("bindInformation")
    public Result bindInformation(@RequestBody(required = false)
            @ApiParam(name="teacherId",value="教师id",required=true)
                    Long teacherId,
            @ApiParam(name="name",value="教师姓名",required=true)
                    String name) {
        Teacher teacher = teacherService.selectTeacherById(teacherId);
        if(!teacher.getName().equals(name)){
            return ResultGenerator.genFailedResult("教师绑定失败");
        }
        Integer userId = jwtService.getSubjectUser().getUserId();
        teacher.setUserId(userId);
        teacherService.updateById(teacher);
        return ResultGenerator.genOkResult("用户绑定教师成功");
    }
}
