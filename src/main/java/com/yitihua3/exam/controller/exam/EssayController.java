package com.yitihua3.exam.controller.exam;

import com.yitihua3.exam.entity.exam.Choice;
import com.yitihua3.exam.entity.exam.Essay;
import com.yitihua3.exam.service.exam.EssayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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
    @GetMapping("/queryEssayById")
    public String queryEssayById(
            @ApiParam(name = "essayId", value = "简答题编号", required = true)
                    Integer essayId) {
        essayService.queryById(essayId);
        return "essayList";
    }

    @RequestMapping("/toAddEssay")
    public String toAddEssay(){
        return "addEssay";
    }
    
    @ApiOperation(value = "添加简答题",  notes = "添加简答题",httpMethod = "POST")
    @GetMapping("/addEssay")
    public String addEssay( 
//            @ApiParam(name="essayId",value="简答题编号",required=true)
//                                       Integer essayId,
//                           @ApiParam(name="title",value="添加题目内容",required=true)
//                                       String title,
//                           @ApiParam(name="reference",value="添加参考答案",required=true)
//                                       String reference,
//                           @ApiParam(name="score",value="添加选择题得分",required=true)
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
            @ApiParam(name="essay",value="选择题集合",required=true)
            @RequestParam Essay essay)
    {
        essayService.insert(essay);
        return "essayList";
    }

    @ApiOperation(value = "根据简答题编号删除简答题",  notes = "根据简答题编号删除简答题",httpMethod = "DELETE")
    @GetMapping("/deleteEssayById")
    public String deleteEssayById(
            @ApiParam(name="essayId",value="简答题编号",required=true)
                    Integer essayId) {
        essayService.deleteById(essayId);
        return "essayList";
    }

    @RequestMapping("/toUpdateEssayById")
    public String toUpdateEssayById(Integer essayId,Model model){
        model.addAttribute("essayId",essayService.queryById(essayId));
        return "updateEssayById";
    }
    
    @ApiOperation(value = "根据简答题编号更新简答题",  notes = "根据简答题编号更新简答题",httpMethod = "PUT")
    @GetMapping("/updateEssayById")
    public String updateEssayById(@RequestParam Essay essay, Model model)
    
//            @ApiParam(name="essayId",value="简答题编号",required=true)
//                    Integer essayId,
//            @ApiParam(name="title",value="更新题目内容",required=true)
//                    String title,
//            @ApiParam(name="reference",value="更新参考答案",required=true)
//                    String reference,
//            @ApiParam(name="score",value="更新选择题得分",required=true)
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
        essayService.update(essay);
        essayService.queryById(essay.getEssayId());
        model.addAttribute("essay",essay);
        return "essayList";
    }

    @ApiOperation(value = "显示所有简答题",notes = "显示所有简答题",httpMethod = "GET")
    @GetMapping("/queryAll")
    public String queryAll(){
        essayService.queryAll();
        return "essayList";
    }

    @ApiOperation(value = "显示简答题试卷",notes = "显示简答题试卷",httpMethod = "GET")
    @GetMapping("/queryAllTest")
    public String queryAllTest(){
        essayService.queryAllTest();
        return "essayListTest";
    }

    @ApiOperation(value = "查询某一简答题得分",notes = "查询某一简答题得分",httpMethod = "GET")
    @GetMapping("/queryEssayScoreById")
    public String queryEssayScoreById(
            @ApiParam(name = "choiceId",value = "简答题编号",required = true)
            @RequestParam Integer essayId
    ){
        essayService.queryScoreById(essayId);
        return "essayScore";
    }

    @ApiOperation(value = "查询简答题得分",notes = "查询简答题得分",httpMethod = "GET")
    @GetMapping("/queryEssayScore")
    public String queryEssayScore(

    ){
        essayService.queryScore();
        return "essayScore";
    }

    @ApiOperation(value = "查询某一简答题答案",notes = "查询某一简答题答案",httpMethod = "GET")
    @GetMapping("/queryEssayReferenceById")
    public String queryEssayReferenceById(
            @ApiParam(name="essayId",value="简答题编号",required=true)
            @RequestParam Integer essayId){
        essayService.queryReferenceById(essayId);
        return "essayReference";

    }

    @ApiOperation(value = "查询简答题答案",notes = "查询简答题答案",httpMethod = "GET")
    @GetMapping("/queryEssayReference")
    public String queryEssayReference()
    {
        essayService.queryReference();
        return "essayReference";

    }

    @ApiOperation(value = "查询某一简答题所属科目",notes = "查询某一简答题所属科目",httpMethod = "GET")
    @GetMapping("/queryEssaySubjectById")
    public String queryEssaySubjectById(
            @ApiParam(name="essayId",value="简答题编号",required=true)
            @RequestParam Integer essayId ){
        essayService.querySubjectId(essayId);
        return "essaySubjectId";

    }

    @ApiOperation(value = "查询某一简答题所属章节",notes = "查询某一简答题所属章节",httpMethod = "GET")
    @GetMapping("/queryEssayChapterById")
    public String queryEssayChapter(
            @ApiParam(name="essayId",value="简答题编号",required=true)
            @RequestParam Integer essayId ){
        essayService.queryChapterId(essayId);
        return "essayChapterId";

    }
}