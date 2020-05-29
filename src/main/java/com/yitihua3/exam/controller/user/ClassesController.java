package com.yitihua3.exam.controller.user;

import com.yitihua3.exam.entity.user.Classes;
import com.yitihua3.exam.response.Result;
import com.yitihua3.exam.response.ResultGenerator;
import com.yitihua3.exam.service.user.ClassesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author aiwoqe
 * @Type ClassesController
 * @Desc
 * @date 2020年05月26日
 * @Version V1.0
 */
@Api(value="班级controller")
@RestController
@RequestMapping("/user/classes")
public class ClassesController {
    @Autowired
    ClassesService classesService;

    @ApiOperation(value = "个人信息界面返回所有班级的名字和id",  notes = "用于个人信息修改",httpMethod = "GET")
    @GetMapping("/queryClasses")
    public Result<List> queryClasses()
    {
        List<Classes> classes = classesService.selectAll();
        return ResultGenerator.genOkResult("查询所有班级成功",classes);
    }

    @ApiOperation(value = "增加班级",  notes = "增加班级",httpMethod = "POST")
    @PostMapping("/addClasses")
    public Result addClasses(
            @ApiParam(name="classes",value="班级id和班级名字",required=true)
            Classes classes
    )
    {
        classesService.insertClasses(classes);
        return ResultGenerator.genOkResult("增加班级成功");
    }

    @ApiOperation(value = "修改班级",  notes = "修改班级",httpMethod = "PUT")
    @PutMapping("/updateClasses")
    public Result updateClasses(
            @ApiParam(name="classes",value="班级id和班级名字",required=true)
            Classes classes
    )
    {
        classesService.selectAll();
        return ResultGenerator.genOkResult("修改班级成功");
    }

    @ApiOperation(value = "删除班级",  notes = "删除班级",httpMethod = "DELETE")
    @DeleteMapping("/deleteClasses")
    public Result deleteClasses(
            @ApiParam(name="classId",value="班级id",required=true)
            Integer classId
    )
    {
        classesService.deleteClasses(classId);
        return ResultGenerator.genOkResult("删除班级成功");
    }

}
