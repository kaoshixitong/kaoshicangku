package com.yitihua3.exam.controller.exam;

import com.yitihua3.exam.entity.exam.Essay;
import com.yitihua3.exam.entity.exam.Essay;
import com.yitihua3.exam.response.Result;
import com.yitihua3.exam.response.ResultGenerator;
import com.yitihua3.exam.service.exam.EssayService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (Essay)表控制层
 *
 * @author makejava
 * @since 2020-04-17 21:04:17
 */
@Api(value = "简答题的controller")
@RestController
@RequestMapping("/essay")
public class EssayController {
    /**
     * 服务对象
     */
    @Resource
    private EssayService essayService;

    /**
     * 通过主键查询单条数据
     *
     * @param essayId 主键
     * @return 单条数据
     */
    @ApiOperation(value = "根据简答题编号查询简答题", notes = "根据简答题编号查询简答题", httpMethod = "GET")
    @GetMapping("queryEssayById")
    public Result queryEssayById(
            @ApiParam(name = "essayId", value = "简答题编号", required = true)
                    Integer essayId) {
        essayService.queryById(essayId);
        return ResultGenerator.genOkResult("按编号查询简答题成功");
    }

    @RequestMapping("toAddEssay")
    public String toAddEssay(){
        return "addEssay";
    }
    
    @ApiOperation(value = "添加简答题",  notes = "添加简答题",httpMethod = "POST")
    @GetMapping("addEssay")
    public Result addEssay(
//            @ApiParam(name="essayId",value="简答题编号",required=true)
//                                       Integer essayId,
//                           @ApiParam(name="title",value="添加题目内容",required=true)
//                                       String title,
//                           @ApiParam(name="reference",value="添加参考答案",required=true)
//                                       String reference,
//                           @ApiParam(name="score",value="添加简答题得分",required=true)
//                                       Integer score,
//                           @ApiParam(name="subjectId",value="添加科目类型编号",required=true)
//                                       Integer subjectId,
//                           @ApiParam(name="chapterId",value="添加具体章节编号",required=true)
//                                       Integer chapterId,
//                           @ApiParam(name="single",value="添加是否单选",required=true,defaultValue = "1")
//                                       Integer single,
//                           @ApiParam(name="subject",value="添加科目类型",required=true)
//                                       Integer subject,
//                           @ApiParam(name="chapter",value="添加具体章节",required=true)
//                                       Integer chapter)
            @ApiParam(name="essay",value="简答题集合",required=true)
            @RequestBody Essay essay)
    {
        Essay insert = essayService.insert(essay);
        if(insert==null){
            return ResultGenerator.genFailedResult("添加简答题失败");
        }
        else
        return ResultGenerator.genOkResult("添加简答题成功");
    }

    @ApiOperation(value = "上传excel表格添加简答题",notes = "上传excel表格添加简答题",httpMethod = "GET")
    @GetMapping("addEssayByExcel")
    public Result addEssayByExcel(@RequestBody Map<String,Object> obj){
        Essay essayList =(Essay) obj.get("essayList");
        Essay insert = essayService.insert(essayList);
        if (insert==null){
            return ResultGenerator.genFailedResult("文件上传失败");

        }
        else return ResultGenerator.genOkResult("文件上传成功");

    }
    
    @ApiOperation(value = "根据简答题编号删除简答题",  notes = "根据简答题编号删除简答题",httpMethod = "DELETE")
    @GetMapping("deleteEssayById")
    public Result deleteEssayById(
            @ApiParam(name="essayId",value="简答题编号",required=true)
                    Integer essayId) {
        boolean b = essayService.deleteById(essayId);
        if(!b){
            return ResultGenerator.genFailedResult("删除简单题失败");
        }
        else
        return ResultGenerator.genOkResult("按编号删除简答题成功");
    }

    @RequestMapping("toUpdateEssayById")
    public String toUpdateEssayById(Integer essayId,Model model){
        model.addAttribute("essayId",essayService.queryById(essayId));
        return "updateEssayById";
    }
    
    @ApiOperation(value = "根据简答题编号更新简答题",  notes = "根据简答题编号更新简答题",httpMethod = "PUT")
    @GetMapping("updateEssayById")
    public Result updateEssayById(@RequestBody Essay essay, Model model)
    
//            @ApiParam(name="essayId",value="简答题编号",required=true)
//                    Integer essayId,
//            @ApiParam(name="title",value="更新题目内容",required=true)
//                    String title,
//            @ApiParam(name="reference",value="更新参考答案",required=true)
//                    String reference,
//            @ApiParam(name="score",value="更新简答题得分",required=true)
//                    Integer score,
//            @ApiParam(name="subjectId",value="更新科目类型编号",required=true)
//                    Integer subjectId,
//            @ApiParam(name="chapterId",value="更新具体章节编号",required=true)
//                    Integer chapterId,
//            @ApiParam(name="single",value="更新是否单选",required=true,defaultValue = "1")
//                    Integer single,
//            @ApiParam(name="subject",value="更新科目类型",required=true)
//                    Integer subject,
//            @ApiParam(name="chapter",value="更新具体章节",required=true)
//                    Integer chapter) 
    {
        Essay update = essayService.update(essay);
        essayService.queryById(essay.getEssayId());
        model.addAttribute("essay",essay);
        if(update==null){
            return ResultGenerator.genFailedResult("按编号更新简答题失败");
        }
        else
        return ResultGenerator.genOkResult("按编号更新简答题成功");
    }

    @ApiOperation(value = "显示所有简答题",notes = "显示所有简答题",httpMethod = "GET")
    @GetMapping("queryAll")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value="分页页码",required=true,example = "1"),
            @ApiImplicitParam(name="size",value="分页数量",required=true,example = "5")
    })
    public Result queryAll(){
        List<Essay> essays = essayService.queryAll();
        if (essays!=null && essays.size()>0){
        return ResultGenerator.genOkResult("查询所有简答题成功");}
        else
            return ResultGenerator.genFailedResult("查询所有简答题失败");
    }

    @ApiOperation(value = "显示简答题试卷",notes = "显示简答题试卷",httpMethod = "GET")
    @GetMapping("queryAllTest")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value="分页页码",required=true,example = "1"),
            @ApiImplicitParam(name="size",value="分页数量",required=true,example = "5")
    })
    public Result queryAllTest(){
        List<Essay> essays = essayService.queryAllTest();
        if (essays!=null && essays.size()>0){
            return ResultGenerator.genOkResult("查询所有简答题试卷成功");}
        else
            return ResultGenerator.genFailedResult("查询所有简答题试卷失败");
    }

    @ApiOperation(value = "查询某一简答题得分",notes = "查询某一简答题得分",httpMethod = "GET")
    @GetMapping("queryEssayScoreById")
    public Result queryEssayScoreById(
            @ApiParam(name = "essayId",value = "简答题编号",required = true)
            @RequestBody Integer essayId
    ){
        Essay essay = essayService.queryScoreById(essayId);
        if (essay==null){
            return ResultGenerator.genFailedResult("查询第"+essayId+"道简答题成绩失败");
        }
        else
        return ResultGenerator.genOkResult("查询简第"+essayId+"道答题成绩成功");
    }

    @ApiOperation(value = "查询简答题得分",notes = "查询简答题得分",httpMethod = "GET")
    @GetMapping("queryEssayScore")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value="分页页码",required=true,example = "1"),
            @ApiImplicitParam(name="size",value="分页数量",required=true,example = "5")
    })
    public Result queryEssayScore(@ApiParam(name = "paperId",value = "试卷编号",required = true)@RequestBody Integer paperId

    ){
        List<Essay> essays = essayService.queryScore(paperId);
        if (essays!=null && essays.size()>0){
            return ResultGenerator.genOkResult("查询所有简答题得分成功");}
        else
            return ResultGenerator.genFailedResult("查询所有简答题得分失败");
    }

    @ApiOperation(value = "查询某一简答题答案",notes = "查询某一简答题答案",httpMethod = "GET")
    @GetMapping("queryEssayReferenceById")
    public Result queryEssayReferenceById(
            @ApiParam(name="essayId",value="简答题编号",required=true)
            @RequestBody Integer essayId){
        Essay essay = essayService.queryReferenceById(essayId);
        if (essay==null){
            return ResultGenerator.genFailedResult("按编号查询第"+essayId+"道简答题答案失败");
        }
        else
        return ResultGenerator.genOkResult("按编号查询某一简答题答案成功");

    }

    @ApiOperation(value = "查询简答题答案",notes = "查询简答题答案",httpMethod = "GET")
    @GetMapping("queryEssayReference")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value="分页页码",required=true,example = "1"),
            @ApiImplicitParam(name="size",value="分页数量",required=true,example = "5")
    })
    public Result queryEssayReference(@ApiParam(name = "paperId",value = "试卷编号",required = true)@RequestBody Integer paperId)
    {
        List<Essay> essays = essayService.queryReference(paperId);
        if (essays!=null && essays.size()>0){
            return ResultGenerator.genOkResult("查询所有简答题答案成功");}
        else
            return ResultGenerator.genFailedResult("查询所有简答题答案失败");

    }

    @ApiOperation(value = "查询某一简答题所属科目",notes = "查询某一简答题所属科目",httpMethod = "GET")
    @GetMapping("queryEssaySubjectById")
    public Result queryEssaySubjectById(
            @ApiParam(name="essayId",value="简答题编号",required=true)
            @RequestBody Integer essayId ){
        Essay essay = essayService.querySubjectId(essayId);
        if(essay==null)
            return ResultGenerator.genFailedResult("查询第"+essayId+"道简答题所属科目失败");
        else
        return ResultGenerator.genOkResult("查询第"+essayId+"道简答题所属科目成功");

    }

    @ApiOperation(value = "查询某一简答题所属章节",notes = "查询某一简答题所属章节",httpMethod = "GET")
    @GetMapping("queryEssayChapterById")
    public Result queryEssayChapter(
            @ApiParam(name="essayId",value="简答题编号",required=true)
            @RequestBody Integer essayId ){
        Essay essay = essayService.queryChapterId(essayId);
        if(essay==null){
            return ResultGenerator.genFailedResult("查询第"+essayId+"道简答题所属章节失败");
        }
        else
        return ResultGenerator.genOkResult("查询第"+essayId+"道简答题所属章节成功");

    }

    @ApiOperation(value = "按试卷编号查询简答题",notes = "用于区分简答题所属试卷",httpMethod = "GET")
    @GetMapping("queryAllTestById")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value="分页页码",required=true,example = "1"),
            @ApiImplicitParam(name="size",value="分页数量",required=true,example = "5")
    })
    public Result queryAllTestById(@ApiParam(name = "paperId",value = "试卷编号",required = true)
                                   @RequestBody Integer paperId){
        List<Essay> essay = essayService.queryAllTestById(paperId);
        if (essay==null){
            return ResultGenerator.genFailedResult("根据试卷编号获取简答题失败");
        }
        else return ResultGenerator.genOkResult("根据试卷编号若区简答题成功");
    }
}