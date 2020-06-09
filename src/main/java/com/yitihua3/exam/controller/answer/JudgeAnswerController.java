package com.yitihua3.exam.controller.answer;

import com.yitihua3.exam.entity.exam.Judge;
import com.yitihua3.exam.service.answer.JudgeAnswerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Api(value = "判断题答案的controller")
@RestController
@RequestMapping("/judgeAnswer")
public class JudgeAnswerController {

    /**
     * 服务对象
     */
    @Resource
    private JudgeAnswerService judgeAnswerService;

    /**
     * 通过主键查询单条数据
     *
     * @param answerId 主键
     * @return 单条数据
     */
    @ApiOperation(value = "根据判断题答案编号查询判断题答案",  notes = "根据判断题编号答案查询判断题答案",httpMethod = "GET")
    @GetMapping("queryJudgeById")
    public Judge queryJudgeById(
            @ApiParam(name="answerId",value="判断题编号",required=true)
                    Integer answerId) {
        return null;
    }

    @ApiOperation(value = "显示所有判断题答案",notes = "显示所有判断题答案",httpMethod = "GET")
    @GetMapping("queryAllAnswer")
    public List<Judge> queryAllAnswer(){
        return null;
    }
}