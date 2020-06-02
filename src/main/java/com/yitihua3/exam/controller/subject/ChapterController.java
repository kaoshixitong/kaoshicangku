package com.yitihua3.exam.controller.subject;

import com.yitihua3.exam.entity.subject.Chapter;
import com.yitihua3.exam.response.Result;
import com.yitihua3.exam.response.ResultGenerator;
import com.yitihua3.exam.service.subject.ChapterService;
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
 * @Type ChapterController
 * @Desc
 * @date 2020年06月01日
 * @Version V1.0
 */
@Api(value = "章节的controller",tags={"章节操作接口"})
@RestController
@RequestMapping("/chapter")
public class ChapterController {

    @Autowired
    ChapterService chapterService;


    @ApiOperation(value = "查询某个科目的所有章节",  notes = "可用于教师查看科目的章节",httpMethod = "GET")
    @GetMapping("queryBySubject")
    public Result<List<Chapter>> queryBySubject(
            @NotNull(message = "subjectId") @ApiParam(name="subjectId",value="科目id",required=true)
                    Integer subjectId
    ) {
        List<Chapter> chapterList = chapterService.queryBySubject(subjectId);
        return ResultGenerator.genOkResult("查询所有科目成功",chapterList);
    }
}
