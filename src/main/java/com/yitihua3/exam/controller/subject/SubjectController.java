package com.yitihua3.exam.controller.subject;

import com.yitihua3.exam.service.subject.SubjectService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author aiwoqe
 * @Type SubjectController
 * @Desc
 * @date 2020年06月01日
 * @Version V1.0
 */
@Api(value = "科目的controller",tags={"科目操作接口"})
@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    SubjectService subjectService;

}
