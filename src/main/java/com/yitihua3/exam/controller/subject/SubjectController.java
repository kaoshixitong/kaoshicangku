package com.yitihua3.exam.controller.subject;

import com.yitihua3.exam.entity.subject.Subject;
import com.yitihua3.exam.response.Result;
import com.yitihua3.exam.response.ResultGenerator;
import com.yitihua3.exam.service.subject.SubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Result<List<Subject>> queryAllSubject(
            @NotNull(message = "page不能为空") @ApiParam(name="page",value="分页页码",required=true)
                    Integer page,
            @NotNull(message = "size不能为空")  @ApiParam(name="size",value="分页数量",required=true)
                    Integer size
    ) {
        List<Subject> subjectList = subjectService.queryAllByLimit(page, size);
        return ResultGenerator.genOkResult("查询所有科目成功",subjectList);
    }
}
