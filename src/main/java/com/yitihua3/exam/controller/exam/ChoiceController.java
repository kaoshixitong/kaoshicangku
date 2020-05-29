package com.yitihua3.exam.controller.exam;

import com.yitihua3.exam.entity.exam.Choice;
import com.yitihua3.exam.service.exam.ChoiceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Choice)表控制层
 *
 * @author makejava
 * @since 2020-04-17 21:04:17
 */
@Api(value = "选择题的controller")
@RestController
@RequestMapping("/choice")
@ResponseBody
public class ChoiceController {
    /**
     * 服务对象
     */
    @Resource
    private ChoiceService choiceService;

    /**
     * 通过主键查询单条数据
     *
     * @param choiceId 主键
     * @return 单条数据
     */
    @ApiOperation(value = "根据选择题编号查询选择题",  notes = "根据选择题编号查询选择题",httpMethod = "GET")
    @GetMapping("/queryChoiceById")
    public String queryChoiceById(
            @ApiParam(name="choiceId",value="选择题编号",required=true)
                    @RequestParam Integer choiceId) {
        choiceService.queryById(choiceId);
        return "queryResult";
    }
    @RequestMapping("/toAddChoice")
    public String toAddChoice(){
        return "addChoice";
    }

    @ApiOperation(value = "添加选择题",  notes = "添加选择题",httpMethod = "POST")
    @GetMapping("/addChoice")
    public String addChoice(
//            @ApiParam(name="title",value="添加题目",required=true)
//                    @RequestParam String title,
//            @ApiParam(name="typeA",value="添加选项A",required=true)
//                   @RequestParam String typeA,
//            @ApiParam(name="typeB",value="添加选项B",required=true)
//                    @RequestParam String typeB,
//            @ApiParam(name="typeC",value="添加选项C",required=true)
//                   @RequestParam String typeC,
//            @ApiParam(name="typeD",value="添加选项D",required=true)
//                   @RequestParam String typeD,
//            @ApiParam(name="right",value="添加选择题答案",required=true)
//                   @RequestParam String right,
//            @ApiParam(name="score",value="添加选择题得分",required=true)
//                    @RequestParam Integer score,
//            @ApiParam(name="subjectId",value="添加科目类型编号",required=true)
//                   @RequestParam Integer subjectId,
//            @ApiParam(name="chapterId",value="添加具体章节编号",required=true)
//                   @RequestParam Integer chapterId,
//            @ApiParam(name="single",value="添加是否单选",required=true,defaultValue = "1")
//                   @RequestParam Integer single,
            @ApiParam(name="choice",value="选择题集合",required=true)
            @RequestParam Choice choice)
//            @ApiParam(name="subject",value="添加科目类型",required=true)
//                    Integer subject,
//            @ApiParam(name="chapter",value="添加具体章节",required=true)
//                    Integer chapter)
           {
               choiceService.insert(choice);
//               Choice choice = new Choice(title,typeA,typeB,typeC,typeD,right,score,subjectId,chapterId,single);
//               choiceService.update(choice);

        return "choiceList";
    }


    @ApiOperation(value = "根据选择题编号删除选择题",  notes = "根据选择题编号删除选择题",httpMethod = "DELETE")
    @GetMapping("/deleteChoiceById")
    public String deleteChoiceById(
            @ApiParam(name="choiceId",value="选择题编号",required=true)
                   @RequestParam Integer choiceId) {
                choiceService.deleteById(choiceId);
        return "choiceList";
    }

    @RequestMapping("/toUpdateChoiceById")
            public String toUpdateChoiceById(Integer choiceId,Model model){
        model.addAttribute("choiceId",choiceService.queryById(choiceId));
                return "updateChoiceById";
            }

    @ApiOperation(value = "根据选择题编号更新选择题",  notes = "根据选择题编号更新选择题",httpMethod = "PUT")
    @GetMapping("/updateChoiceById")
    public String updateChoiceById(
//            @ApiParam(name="choiceId",value="选择题编号",required=true)
//                    @RequestParam Integer choiceId,
//            @ApiParam(name="title",value="更新题目",required=true)
//                   @RequestParam String title,
//            @ApiParam(name="typeA",value="更新选项A",required=true)
//                   @RequestParam String typeA,
//            @ApiParam(name="typeB",value="更新选项B",required=true)
//                   @RequestParam String typeB,
//            @ApiParam(name="typeC",value="更新选项C",required=true)
//                   @RequestParam String typeC,
//            @ApiParam(name="typeD",value="更新选项D",required=true)
//                   @RequestParam String typeD,
//            @ApiParam(name="right",value="更新选择题答案",required=true)
//                    @RequestParam String right,
//            @ApiParam(name="score",value="更新选择题得分",required=true)
//                   @RequestParam Integer score,
//            @ApiParam(name="subjectId",value="更新科目类型编号",required=true)
//                   @RequestParam Integer subjectId,
//            @ApiParam(name="chapterId",value="更新具体章节编号",required=true)
//                   @RequestParam Integer chapterId,
//            @ApiParam(name="single",value="更新是否单选",required=true,defaultValue = "1")
//                   @RequestParam Integer single,
            Model model,@ApiParam(name = "choice",value = "选择题集合",required = true) @RequestParam Choice choice
//            @ApiParam(name="subject",value="更新科目类型",required=true)
//                  @RequestParam  Integer subject,
//            @ApiParam(name="chapter",value="更新具体章节",required=true)
//                  @RequestParam  Integer chapter
                  ){
        choiceService.update(choice);
        choice = choiceService.queryById(choice.getChoiceId());
        model.addAttribute("choice",choice);
//        Choice choice = new Choice(choiceId,title,typeA,typeB,typeC,typeD,right,score,subjectId,chapterId,single);
//        choiceService.update(choice);
        return "choiceList";
    }

    @ApiOperation(value = "显示所有选择题",notes = "显示所有选择题",httpMethod = "GET")
    @GetMapping("/queryAll")
    public String queryAll(){
        choiceService.queryAll();
        return "choiceList";
    }

    @ApiOperation(value = "显示选择题试卷",notes = "显示选择题试卷",httpMethod = "GET")
    @GetMapping("/queryAllTest")
    public String queryAllTest(){
        choiceService.queryAllTest();
        return "choiceListTest";
    }

    @ApiOperation(value = "查询某一选择题得分",notes = "查询某一选择题得分",httpMethod = "GET")
    @GetMapping("/queryChoiceScoreById")
    public String queryChoiceScoreById(
            @ApiParam(name = "choiceId",value = "选择题编号",required = true)
            @RequestParam Integer choiceId
    ){
        choiceService.queryScoreById(choiceId);
        return "choiceScore";
    }

    @ApiOperation(value = "查询选择题得分",notes = "查询选择题得分",httpMethod = "GET")
    @GetMapping("/queryChoiceScore")
    public String queryChoiceScore(

    ){
        choiceService.queryScore();
        return "choiceScore";
    }

    @ApiOperation(value = "查询某一选择题答案",notes = "查询某一选择题答案",httpMethod = "GET")
    @GetMapping("/queryChoiceRightById")
    public String queryChoiceRightById(
            @ApiParam(name="choiceId",value="选择题编号",required=true)
            @RequestParam Integer choiceId){
        choiceService.queryRightById(choiceId);
        return "choiceRight";

    }

    @ApiOperation(value = "查询选择题答案",notes = "查询选择题答案",httpMethod = "GET")
    @GetMapping("/queryChoiceRight")
    public String queryChoiceRight()
    {
        choiceService.queryRight();
        return "choiceRight";

    }

    @ApiOperation(value = "查询某一选择题所属科目",notes = "查询某一选择题所属科目",httpMethod = "GET")
    @GetMapping("/queryChoiceSubjectById")
    public String queryChoiceSubjectById(
            @ApiParam(name="choiceId",value="选择题编号",required=true)
            @RequestParam Integer choiceId ){
        choiceService.querySubjectId(choiceId);
        return "choiceSubjectId";

    }

    @ApiOperation(value = "查询某一选择题所属章节",notes = "查询某一选择题所属章节",httpMethod = "GET")
    @GetMapping("/queryChoiceChapterById")
    public String queryChoiceChapter(
            @ApiParam(name="choiceId",value="选择题编号",required=true)
            @RequestParam Integer choiceId ){
        choiceService.queryChapterId(choiceId);
        return "choiceChapterId";

    }

}