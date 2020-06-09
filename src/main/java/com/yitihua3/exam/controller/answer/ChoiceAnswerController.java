package com.yitihua3.exam.controller.answer;

import com.yitihua3.exam.entity.exam.Choice;
import com.yitihua3.exam.service.answer.ChoiceAnswerService;
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
@Api(value = "选择题答案的controller")
@RestController
@RequestMapping("/choiceAnswer")
public class ChoiceAnswerController {

        /**
         * 服务对象
         */
        @Resource
        private ChoiceAnswerService choiceAnswerService;

        /**
         * 通过主键查询单条数据
         *
         * @param answerId 主键
         * @return 单条数据
         */
        @ApiOperation(value = "根据选择题答案编号查询选择题答案",  notes = "根据选择题编号答案查询选择题答案",httpMethod = "GET")
        @GetMapping("queryChoiceById")
        public Choice queryChoiceById(
                @ApiParam(name="answerId",value="选择题编号",required=true)
                        Integer answerId) {
            return null;
        }

        @ApiOperation(value = "显示所有选择题答案",notes = "显示所有选择题答案",httpMethod = "GET")
        @GetMapping("queryAllAnswer")
        public List<Choice> queryAllAnswer(){
            return null;
        }
}
