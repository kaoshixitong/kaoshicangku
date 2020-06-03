package com.yitihua3.exam.controller.answer;

import com.alibaba.fastjson.JSONObject;
import com.yitihua3.exam.dto.answer.AnswerDTO;
import com.yitihua3.exam.entity.user.User;
import com.yitihua3.exam.response.Result;
import com.yitihua3.exam.response.ResultGenerator;
import com.yitihua3.exam.service.answer.AnswerService;
import com.yitihua3.exam.service.user.JWTService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;

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
        answerService.insertAnswer(answerDTO);
        return ResultGenerator.genOkResult("考试作答提交成功");
    }

    @Autowired
    JWTService jwtService;

    @ApiOperation(value = "查询答题剩余时间",  notes = "可用于超时作答的提交",httpMethod = "GET")
    @GetMapping("queryRemaining")
    @ApiImplicitParam(name="examId",value="考试编号",required=true,example = "1")
    public Result<Long> queryRemaining(@RequestBody(required = false)
                                           @ApiIgnore JSONObject jsonObject
    ) {
        //获取当前用户
        Integer examIdInteger=jsonObject.getInteger("examId");
        User user = jwtService.getSubjectUser();
        Long remaining = answerService.getRemaining(examIdInteger, user.getUserId());
        return ResultGenerator.genOkResult("查询答题剩余时长成功",remaining);
    }

}