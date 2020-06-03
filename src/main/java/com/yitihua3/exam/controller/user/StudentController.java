package com.yitihua3.exam.controller.user;

import com.alibaba.fastjson.JSONObject;
import com.yitihua3.exam.dto.user.StudentInformationDTO;
import com.yitihua3.exam.entity.user.Student;
import com.yitihua3.exam.entity.user.User;
import com.yitihua3.exam.response.Result;
import com.yitihua3.exam.response.ResultGenerator;
import com.yitihua3.exam.service.user.JWTService;
import com.yitihua3.exam.service.user.StudentService;
import com.yitihua3.exam.service.user.UserService;
import com.yitihua3.exam.utils.DTOConverterUtils;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;

/**
 * @author aiwoqe
 * @Type StudentController
 * @Desc
 * @date 2020年05月24日
 * @Version V1.0
 */
@Api(value = "用户的学生的controller",tags={"学生操作接口"})
@RestController
@RequestMapping("/user/student")
public class StudentController {
    @Resource
    UserService userService;

    @Resource
    JWTService jwtService;

    @Resource
    private StudentService studentService;

    @ApiOperation(value = "查询学生用户的个人信息",  notes = "可用于学生个人信息的查询",httpMethod = "GET")
    @GetMapping("queryInformation")
    public Result<StudentInformationDTO> queryInformation() {
        User user = jwtService.getSubjectUser();
        Student student = studentService.selectStudentByUser(user.getUserId());
        StudentInformationDTO studentInformationDTO = DTOConverterUtils.commonConverter(user, StudentInformationDTO.class);
        studentInformationDTO.setStudent(student);
        return ResultGenerator.genOkResult("查询个人信息成功",studentInformationDTO);
    }

    @ApiOperation(value = "修改学生用户的个人信息",  notes = "可用于学生个人信息的修改",httpMethod = "PUT")
    @PutMapping("updateInformation")
    public Result updateInformation(
            @ApiParam(name="studentInformationDTO",value="修改学生个人信息对象",required=true)
            @RequestBody(required = false) StudentInformationDTO studentInformationDTO
    ) {
        User user = jwtService.getSubjectUser();
        user.setUsername(studentInformationDTO.getUsername());
        userService.updateUser(user);
        Student student = studentInformationDTO.getStudent();
        student.setUserId(user.getUserId());
        studentService.updateByUser(student);
        return ResultGenerator.genOkResult("修改个人信息成功");
    }

    @ApiOperation(value = "可用于学生个人信息与账号的绑定",  notes = "修改学生的用户id",httpMethod = "PUT")
    @PutMapping("bindInformation")

    @ApiImplicitParams({
            @ApiImplicitParam(name="studentId",value="学生id",required=true),
            @ApiImplicitParam(name="name",value="学生姓名",required=true)
    })

    public Result bindInformation(@RequestBody(required = false)
                                  @ApiIgnore JSONObject jsonObject) {
        Student student = studentService.selectStudentById(jsonObject.getLong("studentId"));
        if(!student.getName().equals(jsonObject.getString("name"))){
            return ResultGenerator.genFailedResult("学生绑定失败");
        }
        Integer userId = jwtService.getSubjectUser().getUserId();
        student.setUserId(userId);
        studentService.updateById(student);
        return ResultGenerator.genOkResult("用户绑定学生成功");
    }


}
