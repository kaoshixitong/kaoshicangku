package com.yitihua3.exam.controller.answer;

import com.yitihua3.exam.service.answer.AnswerService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(value = "答案的controller")
@RestController
@RequestMapping("/Answer")
public class AnswerController {

    /**
     * 服务对象
     */
    @Resource
    private AnswerService AnswerService;


}