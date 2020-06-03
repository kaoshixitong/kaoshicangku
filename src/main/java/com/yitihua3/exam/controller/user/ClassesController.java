package com.yitihua3.exam.controller.user;

import com.alibaba.fastjson.JSONObject;
import com.yitihua3.exam.entity.user.Classes;
import com.yitihua3.exam.entity.user.Student;
import com.yitihua3.exam.response.Result;
import com.yitihua3.exam.response.ResultGenerator;
import com.yitihua3.exam.service.user.ClassesService;
import com.yitihua3.exam.service.user.StudentService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author aiwoqe
 * @Type ClassesController
 * @Desc
 * @date 2020年05月26日
 * @Version V1.0
 */
@Api(value="班级controller",tags={"班级操作接口"})
@RestController
@RequestMapping("/user/classes")
@Validated
public class ClassesController {
    @Autowired
    ClassesService classesService;

    @ApiOperation(value = "个人信息界面返回所有班级的名字和id",  notes = "用于个人信息修改",httpMethod = "GET")
    @GetMapping("/queryClasses")
    public Result<List<Classes>> queryClasses()
    {
        List<Classes> classes = classesService.selectAll();
        return ResultGenerator.genOkResult("查询所有班级成功",classes);
    }

    @ApiOperation(value = "增加班级",  notes = "增加班级",httpMethod = "POST")
    @PostMapping("/addClasses")
    public Result addClasses(
            @ApiParam(name="classes",value="班级id和班级名字",required=true)
            @RequestBody(required = false)       Classes classes
    )
    {
        classesService.insertClasses(classes);
        return ResultGenerator.genOkResult("增加班级成功");
    }

    @ApiOperation(value = "修改班级",  notes = "修改班级",httpMethod = "PUT")
    @PutMapping("/updateClasses")
    public Result updateClasses(
            @ApiParam(name="classes",value="班级id和班级名字",required=true)
            @RequestBody(required = false)        Classes classes
    )
    {
        classesService.updateClasses(classes);
        return ResultGenerator.genOkResult("修改班级成功");
    }

    @ApiOperation(value = "删除班级",  notes = "删除班级",httpMethod = "DELETE")
    @DeleteMapping("/deleteClasses")
    @ApiImplicitParam(name = "classId", value = "班级id", required = true, example = "1")
    public Result deleteClasses(@RequestBody(required = false)

                                            @ApiIgnore JSONObject jsonObject
    )
    {
        classesService.deleteClasses(jsonObject.getInteger("classId"));
        return ResultGenerator.genOkResult("删除班级成功");
    }

    @Resource
    private StudentService studentService;

    @ApiOperation(value = "查询班级的所有学生",  notes = "根据班级id查出所有的学生",httpMethod = "GET")
    @GetMapping("/queryStudents")

    @ApiImplicitParams({
            @ApiImplicitParam(name="classId",value="班级id",required=true,example = "1"),
            @ApiImplicitParam(name="page",value="分页页码",required=true,example = "1"),
            @ApiImplicitParam(name="size",value="分页数量",required=true,example = "5")
    })

    public Result<List<Student>> queryStudents(@RequestBody(required = false)
             @ApiIgnore JSONObject jsonObject
    )
    {
        List<Student> studentList = studentService.selectByClassPage(jsonObject.getInteger("classId"), jsonObject.getInteger("page"), jsonObject.getInteger("size"));
        return ResultGenerator.genOkResult("按照班级查询学生成功",studentList);
    }

}
