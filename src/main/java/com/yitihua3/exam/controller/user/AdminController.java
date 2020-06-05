package com.yitihua3.exam.controller.user;

import com.alibaba.fastjson.JSONObject;
import com.yitihua3.exam.entity.user.Student;
import com.yitihua3.exam.entity.user.Teacher;
import com.yitihua3.exam.response.Result;
import com.yitihua3.exam.response.ResultGenerator;
import com.yitihua3.exam.service.user.StudentService;
import com.yitihua3.exam.service.user.TeacherService;
import io.swagger.annotations.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author aiwoqe
 * @Type AdminController
 * @Desc
 * @date 2020年05月31日
 * @Version V1.0
 */
@Api(value = "管理员的controller",tags={"管理员操作接口"})
@RestController
@RequestMapping("/user/admin")
@Validated
public class AdminController {
    @Resource
    private StudentService studentService;

    @ApiOperation(value = "管理员查询所有学生",  notes = "可用于管理员查询所有学生",httpMethod = "GET")
    @GetMapping("queryAllStudent")

    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value="分页页码",required=true,example = "1"),
            @ApiImplicitParam(name="size",value="分页数量",required=true,example = "5")
    })

    public Result<List<Student>> queryAllStudent(@RequestBody
             @ApiIgnore JSONObject jsonObject
    ) {

        List<Student> studentList = studentService.selectAllPage(jsonObject.getInteger("page"), jsonObject.getInteger("size"));
        return ResultGenerator.genOkResult("查询所有学生成功",studentList);
    }

    @ApiOperation(value = "管理员添加学生",  notes = "可用于管理员添加学生",httpMethod = "POST")
    @PostMapping("addStudent")
    public Result addStudent(@RequestBody
            @ApiParam(name="student",value="学生对象",required=true)
            Student student
    ) {
        studentService.insert(student);
        return ResultGenerator.genOkResult("添加学生成功");
    }

    @Resource
    private TeacherService teacherService;


    @ApiOperation(value = "管理员查询所有教师",  notes = "可用于管理员查询所有教师",httpMethod = "GET")
    @GetMapping("queryAllTeacher")

    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value="分页页码",required=true,example = "1"),
            @ApiImplicitParam(name="size",value="分页数量",required=true,example = "5")
    })

    public Result<List<Teacher>> queryAllTeacher(@RequestBody
                                                         @ApiIgnore JSONObject jsonObject
    ) {
        List<Teacher> teacherList = teacherService.selectAllPage(jsonObject.getInteger("page"), jsonObject.getInteger("size"));
        return ResultGenerator.genOkResult("查询所有教师成功",teacherList);
    }

    @ApiOperation(value = "管理员添加教师",  notes = "可用于管理员添加教师",httpMethod = "POST")
    @PostMapping("addTeacher")
    public Result addTeacher(@RequestBody
            @ApiParam(name="teacher",value="教师对象",required=true)
            Teacher teacher
    ) {
        teacherService.insert(teacher);
        return ResultGenerator.genOkResult("教师成功");
    }

}
