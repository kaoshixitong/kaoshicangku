package com.yitihua3.exam.controller.answer;

import com.alibaba.fastjson.JSONObject;
import com.yitihua3.exam.dto.answer.*;
import com.yitihua3.exam.entity.answer.Score;
import com.yitihua3.exam.response.Result;
import com.yitihua3.exam.response.ResultGenerator;
import com.yitihua3.exam.service.answer.ChoiceAnswerService;
import com.yitihua3.exam.service.answer.EssayAnswerService;
import com.yitihua3.exam.service.answer.JudgeAnswerService;
import com.yitihua3.exam.service.answer.ScoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * @author aiwoqe
 * @Type ScoreController
 * @Desc
 * @date 2020年06月04日
 * @Version V1.0
 */
@Api(value = "评分的controller",tags = {"作答评分接口"})
@RestController
@RequestMapping("/teacher/score")
public class ScoreController {
    @Autowired
    ScoreService scoreService;

    @ApiOperation(value = "查询参与考试所有用户",  notes = "可用于教师进行评分时选择用户",httpMethod = "GET")
    @GetMapping("queryExamUser")

    @ApiImplicitParams({
            @ApiImplicitParam(name="examId",value="考试id",required=true,example = "1"),
            @ApiImplicitParam(name="page",value="分页页码",required=true,example = "1"),
            @ApiImplicitParam(name="size",value="分页数量",required=true,example = "5")
    })

    public Result<List<ExamUserDTO>> queryExamUser(@RequestBody
                                                   @ApiIgnore JSONObject jsonObject
    ) {
        Integer examId=jsonObject.getInteger("examId");
        Integer page = jsonObject.getInteger("page");
        Integer size = jsonObject.getInteger("size");

        List<ExamUserDTO> examUserList = scoreService.selectExamUserPage(examId,page,size);

        return ResultGenerator.genOkResult("查询参与考试所有用户成功",examUserList);
    }

    @Autowired
    EssayAnswerService essayAnswerService;

    @ApiOperation(value = "教师评分前获取试题结果", notes = "可用于教师对考试结果判分前查询试题", httpMethod = "GET")
    @GetMapping("queryEssayList")

    @ApiImplicitParams({
            @ApiImplicitParam(name="examId",value="考试id",required=true,example = "1"),
            @ApiImplicitParam(name="userId",value="用户id",required=true,example = "1")
    })

    public Result<List<EssayScoreDTO>> queryEssayList(@RequestBody
                                     @ApiIgnore JSONObject jsonObject

    ) {
        Integer examId = jsonObject.getInteger("examId");
        Integer userId = jsonObject.getInteger("userId");
        List<EssayScoreDTO> essayScoreList = essayAnswerService.selectEssayScore(examId, userId);
        return ResultGenerator.genOkResult("查询学生应用题试题结果成功",essayScoreList);
    }

    @Autowired
    ChoiceAnswerService choiceAnswerService;

    @Autowired
    JudgeAnswerService judgeAnswerService;






    @ApiOperation(value = "教师对应用题评分", notes = "可用于教师对应用题结果判分", httpMethod = "PUT")
    @PutMapping("submitScore")

    public Result submitScore(@RequestBody
                              @Validated ScoreSubmitDTO scoreSubmitDTO
    ) {
        Integer examId = scoreSubmitDTO.getExamId();
        Integer userId = scoreSubmitDTO.getUserId();
        //查询原题比对后更新成绩
        List<ChoiceScoreDTO> choiceScoreList = choiceAnswerService.selectChoiceScore(examId, userId);
        int choiceMark = choiceAnswerService.updateAnswerScore(choiceScoreList);
        //查询原题比对后更新成绩
        List<JudgeScoreDTO> judgeScoreList = judgeAnswerService.selectJudgeScore(examId, userId);
        int judgeMark = judgeAnswerService.updateAnswerScore(judgeScoreList);

        int autoMark=choiceMark+judgeMark;

        int manualMark=0;
        List<EssayScoreDTO> essayScoreList =  scoreSubmitDTO.getEssayScoreList();
        essayAnswerService.updateEssayScore(essayScoreList);
        for (EssayScoreDTO essayScoreDTO:essayScoreList) {
            manualMark+=essayScoreDTO.getEssayAnswerScore();
        }
        //算出总分后更新总分
        int mark=autoMark+manualMark;
        scoreService.updateMark(new Score(examId,userId,mark));
        return ResultGenerator.genOkResult("教师对应用题评分成功");
    }

}
