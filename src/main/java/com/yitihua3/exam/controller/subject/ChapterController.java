package com.yitihua3.exam.controller.subject;

import com.yitihua3.exam.service.subject.ChapterService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author aiwoqe
 * @Type ChapterController
 * @Desc
 * @date 2020年06月01日
 * @Version V1.0
 */
@Api(value = "章节的controller",tags={"章节操作接口"})
@RestController
@RequestMapping("/chapter")
public class ChapterController {

    @Autowired
    ChapterService chapterService;


}
