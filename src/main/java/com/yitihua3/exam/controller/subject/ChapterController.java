package com.yitihua3.exam.controller.subject;

import com.alibaba.fastjson.JSONObject;
import com.yitihua3.exam.entity.subject.Chapter;
import com.yitihua3.exam.response.Result;
import com.yitihua3.exam.response.ResultGenerator;
import com.yitihua3.exam.service.subject.ChapterService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

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
            @Validated @NotNull(message = "subjectId") @ApiParam(name="subjectId",value="科目id",required=true)
                    Integer subjectId
    ) {
        List<Chapter> chapterList = chapterService.queryBySubject(subjectId);
        return ResultGenerator.genOkResult("查询所有章节成功",chapterList);
    }

    @ApiOperation(value = "增加章节",  notes = "增加章节",httpMethod = "POST")
    @PostMapping("/addChapter")
    @ApiImplicitParams({
            @ApiImplicitParam(name="subjectId",value="科目id",required=true),
            @ApiImplicitParam(name="name",value="章节名字",required=true)
    })

    public Result addChapter(@RequestBody
                             @ApiIgnore JSONObject jsonObject
    )
    {
        Chapter chapter = new Chapter(jsonObject.getInteger("subjectId"),jsonObject.getString("name"));
        chapterService.insert(chapter);
        return ResultGenerator.genOkResult("增加章节成功");
    }

    @ApiOperation(value = "修改章节",  notes = "修改章节",httpMethod = "PUT")
    @PutMapping("/updateChapter")
    public Result updateChapter(
            @ApiParam(name="chapter",value="章节",required=true)
            @RequestBody Chapter chapter
    )
    {
        chapterService.update(chapter);
        return ResultGenerator.genOkResult("修改章节成功");
    }

    @ApiOperation(value = "删除章节",  notes = "删除章节",httpMethod = "DELETE")
    @DeleteMapping("/deleteChapter")
    @ApiImplicitParam(name = "chapterId", value = "章节id", required = true, example = "1")
    public Result deleteChapter(@RequestBody
                                @ApiIgnore JSONObject jsonObject
    )
    {
        chapterService.deleteById(jsonObject.getInteger("chapterId"));
        return ResultGenerator.genOkResult("删除章节成功");
    }
}
