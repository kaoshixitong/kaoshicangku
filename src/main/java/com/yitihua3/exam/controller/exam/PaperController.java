package com.yitihua3.exam.controller.exam;

import com.yitihua3.exam.entity.exam.Paper;
import com.yitihua3.exam.service.exam.PaperService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author aiwoqe
 * @Type PaperController
 * @Desc
 * @date 2020年04月24日
 * @Version V1.0
 */
@Api(value = "试卷的controller")
@RestController
@RequestMapping("/paper")
public class PaperController {
    /**
     * 服务对象
     */
    @Resource
    private PaperService paperService;

    /**
     * 通过主键查询单条数据
     *
     * @param paperId 主键
     * @return 单条数据
     */
    @ApiOperation(value = "根据选择题编号查询选择题",  notes = "根据选择题编号查询选择题",httpMethod = "GET")
    @GetMapping("queryPaperById")
    public Paper queryPaperById(
            @ApiParam(name="paperId",value="用户名",required=true)
                    Integer paperId) {
        return null;
    }
}
