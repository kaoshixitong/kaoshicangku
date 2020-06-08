package com.yitihua3.exam.controller.answer;

import com.yitihua3.exam.dto.answer.AnswerDTO;
import com.yitihua3.exam.dto.answer.ScoreResultDTO;
import com.yitihua3.exam.dto.exam.ExamDTO;
import com.yitihua3.exam.entity.user.User;
import com.yitihua3.exam.response.Result;
import com.yitihua3.exam.response.ResultGenerator;
import com.yitihua3.exam.service.answer.AnswerService;
import com.yitihua3.exam.service.answer.ScoreService;
import com.yitihua3.exam.service.user.JWTService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author aiwoqe
 */
@Api(value = "答案的controller",tags = {"试卷作答操作接口"})
@RestController
@RequestMapping("/answer")
public class AnswerController {

    /**
     * 服务对象
     */
    @Resource
    private AnswerService answerService;

    @ApiOperation(value = "进行考试作答的提交",  notes = "可用于学生答题的提交",httpMethod = "POST")
    @PostMapping("submitAnswer")
    public Result submitAnswer(@RequestBody
            @ApiParam(name="answerDTO",value="答题接收对象",required=true)
            @Validated AnswerDTO answerDTO
    ) {

        User user = jwtService.getSubjectUser();
        answerDTO.setUserId(user.getUserId());
        answerService.insertAnswer(answerDTO);
        return ResultGenerator.genOkResult("考试作答提交成功");
    }

    @Autowired
    JWTService jwtService;
    @Autowired
    ScoreService scoreService;

    @ApiOperation(value = "查询学生所有考试",  notes = "可用于学生查询考试前选择考试",httpMethod = "GET")
    @GetMapping("queryStudentExams")
    public Result<List<ExamDTO>> queryStudentExams() {
        //获取当前用户
        User user = jwtService.getSubjectUser();
        List<ExamDTO> studentExamList = scoreService.selectStudentExams( user.getUserId());
        return ResultGenerator.genOkResult("查询答学生所有考试成功",studentExamList);
    }

    @ApiOperation(value = "查询答题剩余时间",  notes = "可用于超时作答的提交",httpMethod = "GET")
    @GetMapping("queryRemaining")
    @ApiImplicitParam(name="examId",value="考试编号",required=true,example = "1")
    public Result<Long> queryRemaining(
                                           Integer examId
    ) {
        //获取当前用户
        User user = jwtService.getSubjectUser();
        Long remaining = answerService.getRemaining(examId, user.getUserId());
        return ResultGenerator.genOkResult("查询答题剩余时长成功",remaining);
    }


    @ApiOperation(value = "学生查询考试结果",  notes = "可用于学生查询自己的考试结果",httpMethod = "GET")
    @GetMapping("queryScoreResult")
    @ApiImplicitParam(name="examId",value="考试编号",required=true,example = "1")
    public Result<ScoreResultDTO> queryScoreResult(
            Integer examId
    ) {
        //获取当前用户
        User user = jwtService.getSubjectUser();
        ScoreResultDTO scoreResult = answerService.selectScoreResult(examId, user.getUserId());
        return ResultGenerator.genOkResult("查询考试结果成功",scoreResult);
    }

}