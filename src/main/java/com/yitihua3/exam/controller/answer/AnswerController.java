package com.yitihua3.exam.controller.answer;

import com.yitihua3.exam.dto.answer.AnswerDTO;
import com.yitihua3.exam.service.answer.AnswerService;
import com.yitihua3.exam.service.answer.ChoiceAnswerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Api(value = "答案的controller")
@RestController
@RequestMapping("/Answer")
public class AnswerController {

    /**
     * 服务对象
     */
    @Resource
    private AnswerService AnswerService;

    /**
     * 通过主键查询单条数据
     *
     * @param examId 主键
     * @return 单条数据
     */
    @ApiOperation(value = "根据考试编号查询考试",  notes = "根据考试编号答案查询考试",httpMethod = "GET")
    @GetMapping("queryExamById")
    public void queryExamById(
            @ApiParam(name="examId",value="考试编号",required=true)
                    Integer examId) {
    }

    @ApiOperation(value = "显示所有考试",notes = "显示所有考试",httpMethod = "GET")
    @GetMapping("queryAllExam")
    public void queryAllExam(){
    }
}