package com.yitihua3.exam.controller.subject;

import com.alibaba.fastjson.JSONObject;
import com.yitihua3.exam.entity.subject.Subject;
import com.yitihua3.exam.response.Result;
import com.yitihua3.exam.response.ResultGenerator;
import com.yitihua3.exam.service.subject.SubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author aiwoqe
 * @Type SubjectController
 * @Desc
 * @date 2020年06月01日
 * @Version V1.0
 */
@Api(value = "科目的controller",tags={"科目操作接口"})
@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @ApiOperation(value = "查询所有的科目",  notes = "可用于教师查询所有的科目",httpMethod = "GET")
    @GetMapping("queryAllSubject")
    public Result<List<Subject>> queryAllSubject(@Validated
            @NotNull(message = "page不能为空") @ApiParam(name="page",value="分页页码",required=true)
                    Integer page,
            @NotNull(message = "size不能为空")  @ApiParam(name="size",value="分页数量",required=true)
                    Integer size
    ) {
        List<Subject> subjectList = subjectService.queryAllByLimit(page, size);
        return ResultGenerator.genOkResult("查询所有科目成功",subjectList);
    }

    @ApiOperation(value = "增加科目",  notes = "增加科目",httpMethod = "POST")
    @PostMapping("/addSubject")

    @ApiImplicitParam(name="name",value="科目名字",required=true)

    public Result addSubject(@RequestBody
                             @ApiIgnore JSONObject jsonObject
    )
    {
        Subject subject = new Subject(jsonObject.getString("name"));
        subjectService.insert(subject);
        return ResultGenerator.genOkResult("增加科目成功");
    }

    @ApiOperation(value = "修改科目",  notes = "修改科目",httpMethod = "PUT")
    @PutMapping("/updateSubject")
    public Result updateSubject(
            @ApiParam(name="subject",value="科目id和科目名字",required=true)
            @RequestBody        Subject subject
    )
    {
        subjectService.update(subject);
        return ResultGenerator.genOkResult("修改科目成功");
    }

    @ApiOperation(value = "删除科目",  notes = "删除科目",httpMethod = "DELETE")
    @DeleteMapping("/deleteSubject")
    @ApiImplicitParam(name = "subjectId", value = "科目id", required = true, example = "1")
    public Result deleteSubject(@RequestBody
                                @ApiIgnore JSONObject jsonObject
    )
    {
        subjectService.deleteById(jsonObject.getInteger("subjectId"));
        return ResultGenerator.genOkResult("删除科目成功");
    }
}
