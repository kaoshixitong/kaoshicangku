package com.yitihua3.exam.controller.exam;

import com.yitihua3.exam.entity.exam.Choice;
import com.yitihua3.exam.response.Result;
import com.yitihua3.exam.response.ResultGenerator;
import com.yitihua3.exam.service.exam.ChoiceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.coyote.RequestGroupInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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
    public Result queryChoiceById(
            @ApiParam(name="choiceId",value="选择题编号",required=true)
                    @RequestParam Integer choiceId) {
        choiceService.queryById(choiceId);
        return ResultGenerator.genOkResult("按编号查询选择题成功");
    }
    @RequestMapping("/toAddChoice")
    public String toAddChoice(){
        return "addChoice";
    }

    @ApiOperation(value = "添加选择题",  notes = "添加选择题",httpMethod = "POST")
    @GetMapping("/addChoice")
    public Result addChoice(
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
               Choice insert = choiceService.insert(choice);
//               Choice choice = new Choice(title,typeA,typeB,typeC,typeD,right,score,subjectId,chapterId,single);
//               choiceService.update(choice);
               if (insert==null){
                   return ResultGenerator.genFailedResult("添加选择题失败");
               }
               else
        return ResultGenerator.genOkResult("添加选择题成功");
    }

    @ApiOperation(value = "上传excel表格添加选择题",notes = "上传excel表格添加选择题",httpMethod = "GET")
    @GetMapping("/addChoiceByExcel")
    public Result addChoiceByExcel(@RequestBody Map<String,Object> obj){
        Choice choiceList =(Choice) obj.get("choiceList");
        Choice insert = choiceService.insert(choiceList);
        if (insert==null){
            return ResultGenerator.genFailedResult("文件上传失败");

        }
        else return ResultGenerator.genOkResult("文件上传成功");

    }


    @ApiOperation(value = "根据选择题编号删除选择题",  notes = "根据选择题编号删除选择题",httpMethod = "DELETE")
    @GetMapping("/deleteChoiceById")
    public Result deleteChoiceById(
            @ApiParam(name="choiceId",value="选择题编号",required=true)
                   @RequestParam Integer choiceId) {
        boolean b = choiceService.deleteById(choiceId);
        if (!b){
            return ResultGenerator.genFailedResult("删除选择题失败");
        }
        return ResultGenerator.genOkResult("删除选择题成功");
    }

    @RequestMapping("/toUpdateChoiceById")
            public String toUpdateChoiceById(Integer choiceId,Model model){
        model.addAttribute("choiceId",choiceService.queryById(choiceId));
                return "updateChoiceById";
            }

    @ApiOperation(value = "根据选择题编号更新选择题",  notes = "根据选择题编号更新选择题",httpMethod = "PUT")
    @GetMapping("/updateChoiceById")
    public Result updateChoiceById(
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
        Choice update = choiceService.update(choice);
        choice = choiceService.queryById(choice.getChoiceId());
        model.addAttribute("choice",choice);
        if (update==null){
            return ResultGenerator.genFailedResult("更新选择题失败");
        }
//        Choice choice = new Choice(choiceId,title,typeA,typeB,typeC,typeD,right,score,subjectId,chapterId,single);
//        choiceService.update(choice);
        return ResultGenerator.genOkResult("更新选择题成功");
    }

    @ApiOperation(value = "显示所有选择题",notes = "显示所有选择题",httpMethod = "GET")
    @GetMapping("/queryAll")
    public Result queryAll(){
        List<Choice> choices = choiceService.queryAll();
        if (choices!=null && choices.size()>0){
            return ResultGenerator.genOkResult("查询所有选择题成功");

        }
        else
            return ResultGenerator.genFailedResult("查询所有选择题失败");
    }

    @ApiOperation(value = "显示选择题试卷",notes = "显示选择题试卷",httpMethod = "GET")
    @GetMapping("/queryAllTest")
    public Result queryAllTest(){
        List<Choice> choices = choiceService.queryAllTest();
        if (choices!=null && choices.size()>0){
            return ResultGenerator.genOkResult("显示选择题试卷成功");

        }
        else
            return ResultGenerator.genFailedResult("显示选择题试卷失败");
    }

    @ApiOperation(value = "查询某一选择题得分",notes = "查询某一选择题得分",httpMethod = "GET")
    @GetMapping("/queryChoiceScoreById")
    public Result queryChoiceScoreById(
            @ApiParam(name = "choiceId",value = "选择题编号",required = true)
            @RequestParam Integer choiceId
    ){

        Choice choice = choiceService.queryScoreById(choiceId);
        if (choice==null){
            return ResultGenerator.genFailedResult("获取第"+choiceId+"的得分失败");
        }
        else
        return ResultGenerator.genOkResult("查询某一选择题得分成功");
    }

    @ApiOperation(value = "查询选择题得分",notes = "查询选择题得分",httpMethod = "GET")
    @GetMapping("/queryChoiceScore")
    public Result queryChoiceScore(

    ) {
        List<Choice> choices = choiceService.queryScore();
        if (choices != null && choices.size() > 0) {
            return ResultGenerator.genOkResult("查询选择题得分成功");

        } else
            return ResultGenerator.genFailedResult("获取选择题得分失败");
    }

    @ApiOperation(value = "查询某一选择题答案",notes = "查询某一选择题答案",httpMethod = "GET")
    @GetMapping("/queryChoiceRightById")
    public Result queryChoiceRightById(
            @ApiParam(name="choiceId",value="选择题编号",required=true)
            @RequestParam Integer choiceId){
        Choice choice = choiceService.queryRightById(choiceId);
        if (choice==null){
            return ResultGenerator.genFailedResult("获取第"+choiceId+"的章节失败");
        }
        else
        return ResultGenerator.genOkResult("查询某一选择题答案成功");

    }

    @ApiOperation(value = "查询选择题答案",notes = "查询选择题答案",httpMethod = "GET")
    @GetMapping("/queryChoiceRight")
    public Result queryChoiceRight()
    {
        List<Choice> choices = choiceService.queryRight();
        if (choices!=null && choices.size()>0){
            return ResultGenerator.genOkResult("查询选择题答案成功");

        }
        else
        return ResultGenerator.genFailedResult("获取选择题答案失败");

    }

    @ApiOperation(value = "查询某一选择题所属科目",notes = "查询某一选择题所属科目",httpMethod = "GET")
    @GetMapping("/queryChoiceSubjectById")
    public Result queryChoiceSubjectById(
            @ApiParam(name="choiceId",value="选择题编号",required=true)
            @RequestParam Integer choiceId ){
        Choice choice = choiceService.querySubjectId(choiceId);
        if (choice==null){
            return ResultGenerator.genFailedResult("获取科目失败");
        }
        else

        return ResultGenerator.genOkResult("查询某一选择题所属科目成功");

    }

    @ApiOperation(value = "查询某一选择题所属章节",notes = "查询某一选择题所属章节",httpMethod = "GET")
    @GetMapping("/queryChoiceChapterById")
    public Result queryChoiceChapter(
            @ApiParam(name="choiceId",value="选择题编号",required=true)
            @RequestParam Integer choiceId ){
        Choice choice = choiceService.queryChapterId(choiceId);
        if (choice==null){
            return ResultGenerator.genFailedResult("获取章节失败");
        }
        else
        return ResultGenerator.genOkResult("查询某一选择题所属章节成功");

    }

}