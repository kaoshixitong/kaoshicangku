package com.yitihua3.exam.controller.exam;


import com.yitihua3.exam.entity.exam.Choice;
import com.yitihua3.exam.entity.exam.Judge;
import com.yitihua3.exam.service.exam.JudgeService;
import com.yitihua3.exam.service.exam.JudgeService;
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
 * (Judge)表控制层
 *
 * @author makejava
 *
 */
@Api(value = "判断题的controller")
@RestController
@RequestMapping("/judge")
public class JudgeController {
    /**
     * 服务对象
     */
    @Autowired
    private JudgeService judgeService;

    /**
     * 通过主键查询单条数据
     *
     * @param judgeId 主键
     * @return 单条数据
     */
    @ApiOperation(value = "根据判断题编号查询判断题", notes = "根据判断题编号查询判断题", httpMethod = "GET")
    @GetMapping("/queryJudgeById")
    public String queryJudgeById(
            @ApiParam(name = "judgeId", value = "判断题编号", required = true)
                    Integer judgeId) {
        judgeService.queryById(judgeId);
        return null;
    }

    @RequestMapping("/toAddJudge")
    public String toAddJudge(){
        return "addJudge";
    }

    @ApiOperation(value = "添加判断题",  notes = "添加判断题",httpMethod = "POST")
    @GetMapping("/addJudge")
    public String  addJudge(
//            @ApiParam(name="judgeId",value="判断题编号",required=true)
//                                        Integer JudgeId,
//                            @ApiParam(name="title",value="添加题目内容",required=true)
//                                        String title,
//                            @ApiParam(name="typeA",value="添加选项A",required=true)
//                                        String typeA,
//                            @ApiParam(name="typeB",value="添加选项B",required=true)
//                                        String typeB,
//                            @ApiParam(name="right",value="添加判断题答案",required=true)
//                                        String right,
//                            @ApiParam(name="score",value="添加判断题得分",required=true)
//                                        Integer score,
//                            @ApiParam(name="subjectId",value="添加科目类型编号",required=true)
//                                        Integer subjectId,
//                            @ApiParam(name="chapterId",value="添加具体章节编号",required=true)
//                                        Integer chapterId,
//                            @ApiParam(name="subject",value="添加科目类型",required=true)
//                                        Integer subject,
//                            @ApiParam(name="chapter",value="添加具体章节",required=true)
//                                        Integer chapter
                            @RequestParam Judge judge)
    {
        judgeService.insert(judge);
        return "judgeList";
    }

    @ApiOperation(value = "根据判断题编号删除判断题",  notes = "根据判断题编号删除判断题",httpMethod = "DELETE")
    @GetMapping("/deleteJudgeById")
    public String deleteJudgeById(
            @ApiParam(name="judgeId",value="判断题编号",required=true)
                    Integer judgeId) {
        judgeService.deleteById(judgeId);
        return "judgeList";
    }

    @RequestMapping("/toUpdateJudgeById")
    public String toUpdateJudgeById(Integer judgeId,Model model){
        judgeService.queryById(judgeId);
        model.addAttribute("judgeId",judgeId);
        return "updateJudgeById";

    }

    @ApiOperation(value = "根据判断题编号更新判断题",  notes = "根据判断题编号更新判断题",httpMethod = "PUT")
    @GetMapping("/updateJudgeById")
    public String updateJudgeById(
//            @ApiParam(name="judgeId",value="判断题编号",required=true)
//                    Integer judgeId,
//            @ApiParam(name="title",value="更新题目内容",required=true)
//                    String title,
//            @ApiParam(name="typeA",value="更新选项A",required=true)
//                    String typeA,
//            @ApiParam(name="typeB",value="更新选项B",required=true)
//                    String typeB,
//            @ApiParam(name="Right",value="更新判断题答案",required=true)
//                    String right,
//            @ApiParam(name="score",value="更新判断题得分",required=true)
//                    Integer score,
//            @ApiParam(name="subjectId",value="更新科目类型编号",required=true)
//                    Integer subjectId,
//            @ApiParam(name="chapterId",value="更新具体章节编号",required=true)
//                    Integer chapterId,
//            @ApiParam(name="subject",value="更新科目类型",required=true)
//                    Integer subject,
//            @ApiParam(name="chapter",value="更新具体章节",required=true)
//                    Integer chapter) {
            Model model, Judge judge){
        judgeService.update(judge);
        judge = judgeService.queryById(judge.getJudgeId());
        model.addAttribute("judge",judge);
        return "judgeList";
    }

    @ApiOperation(value = "显示所有判断题",notes = "显示所有判断题",httpMethod = "GET")
    @GetMapping("/queryAll")
    public String queryAll(){
        judgeService.queryAll();
        return "judgeList";
    }

    @ApiOperation(value = "显示判断题试卷",notes = "显示判断题试卷",httpMethod = "GET")
    @GetMapping("/queryAllTest")
    public String queryAllTest(){
        judgeService.queryAllTest();
        return "judgeListTest";
    }

    @ApiOperation(value = "查询某一判断题得分",notes = "查询某一判断题得分",httpMethod = "GET")
    @GetMapping("/queryJudgeScoreById")
    public String queryJudgeScoreById(
            @ApiParam(name = "choiceId",value = "判断题编号",required = true)
            @RequestParam Integer judgeId
    ){
        judgeService.queryScoreById(judgeId);
        return "judgeScore";
    }

    @ApiOperation(value = "查询判断题得分",notes = "查询判断题得分",httpMethod = "GET")
    @GetMapping("/queryJudgeScore")
    public String queryJudgeScore(

    ){
        judgeService.queryScore();
        return "judgeScore";
    }

    @ApiOperation(value = "查询某一判断题答案",notes = "查询某一判断题答案",httpMethod = "GET")
    @GetMapping("/queryJudgeRightById")
    public String queryJudgeRightById(
            @ApiParam(name="judgeId",value="判断题编号",required=true)
            @RequestParam Integer judgeId){
        judgeService.queryRightById(judgeId);
        return "JudgeRight";

    }

    @ApiOperation(value = "查询判断题答案",notes = "查询判断题答案",httpMethod = "GET")
    @GetMapping("/queryJudgeRight")
    public String queryJudgeRight()
    {
        judgeService.queryRight();
        return "judgeRight";

    }

    @ApiOperation(value = "查询某一判断题所属科目",notes = "查询某一判断题所属科目",httpMethod = "GET")
    @GetMapping("/queryJudgeSubjectById")
    public String queryJudgeSubjectById(
            @ApiParam(name="judgeId",value="判断题编号",required=true)
            @RequestParam Integer judgeId ){
        judgeService.querySubjectId(judgeId);
        return "judgeSubjectId";

    }

    @ApiOperation(value = "查询某一判断题所属章节",notes = "查询某一判断题所属章节",httpMethod = "GET")
    @GetMapping("/queryJudgeChapterById")
    public String queryJudgeChapter(
            @ApiParam(name="judgeId",value="判断题编号",required=true)
            @RequestParam Integer judgeId ){
        judgeService.queryChapterId(judgeId);
        return "judgeChapterId";

    }
}