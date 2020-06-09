package com.yitihua3.exam.controller.answer;

import com.yitihua3.exam.entity.exam.Essay;
import com.yitihua3.exam.service.answer.EssayAnswerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author aiwoqe
 */
@Api(value = "简答题答案的controller")
@RestController
@RequestMapping("/EssayAnswer")
public class EssayAnswerController {

    /**
     * 服务对象
     */
    @Resource
    private EssayAnswerService essayAnswerService;

    /**
     * 通过主键查询单条数据
     *
     * @param answerId 主键
     * @return 单条数据
     */
    @ApiOperation(value = "根据简答题答案编号查询简答题答案",  notes = "根据简答题编号答案查询简答题答案",httpMethod = "GET")
    @GetMapping("queryChoiceById")
    public Essay queryChoiceById(
            @ApiParam(name="answerId",value="简答题编号",required=true)
                    Integer answerId) {
        return null;
    }

    @ApiOperation(value = "显示所有简答题答案",notes = "显示所有简答题答案",httpMethod = "GET")
    @GetMapping("queryAllAnswer")
    public List<Essay> queryAllAnswer(){
        return null;
    }
}