package com.yitihua3.exam.service.answer.impl;

import com.yitihua3.exam.entity.exam.Essay;
import com.yitihua3.exam.service.answer.EssayAnswerService;
import com.yitihua3.exam.service.common.AbstractService;
import org.springframework.stereotype.Service;

/**
 * (EssayAnswer)表服务实现类
 *
 * @author makejava
 * @since 2020-04-18 12:01:59
 */
@Service("essayAnswerService")
public class EssayAnswerServiceImpl extends AbstractService<Essay> implements EssayAnswerService {}