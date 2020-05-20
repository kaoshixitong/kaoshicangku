package com.yitihua3.exam.controller.exam;

import com.yitihua3.exam.entity.exam.Choice;
import com.yitihua3.exam.service.exam.ChoiceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
    @GetMapping("queryChoiceById")
    public Choice queryChoiceById(
            @ApiParam(name="choiceId",value="选择题编号",required=true)
                    Integer choiceId) {
        return null;
    }

}