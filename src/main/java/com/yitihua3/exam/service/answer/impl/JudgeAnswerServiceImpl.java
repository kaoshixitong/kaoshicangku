package com.yitihua3.exam.service.answer.impl;

import com.yitihua3.exam.entity.exam.Judge;
import com.yitihua3.exam.service.answer.JudgeAnswerService;
import com.yitihua3.exam.service.common.AbstractService;
import org.springframework.stereotype.Service;

/**
 * (JudgeAnswer)表服务实现类
 *
 * @author makejava
 * @since 2020-04-18 12:02:14
 */
@Service("judgeAnswerService")
public class JudgeAnswerServiceImpl extends AbstractService<Judge> implements JudgeAnswerService {}