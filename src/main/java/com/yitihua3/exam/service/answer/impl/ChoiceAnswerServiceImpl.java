package com.yitihua3.exam.service.answer.impl;

import com.yitihua3.exam.entity.answer.ChoiceAnswer;
import com.yitihua3.exam.mapper.answer.ChoiceAnswerMapper;
import com.yitihua3.exam.service.answer.ChoiceAnswerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ChoiceAnswer)表服务实现类
 *
 * @author makejava
 * @since 2020-06-01 19:14:23
 */
@Service("choiceAnswerService")
public class ChoiceAnswerServiceImpl implements ChoiceAnswerService {
    @Resource
    private ChoiceAnswerMapper choiceAnswerMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param answerId 主键
     * @return 实例对象
     */
    @Override
    public ChoiceAnswer queryById(Integer answerId) {
        return this.choiceAnswerMapper.queryById(answerId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ChoiceAnswer> queryAllByLimit(int offset, int limit) {
        return this.choiceAnswerMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param choiceAnswer 实例对象
     * @return 实例对象
     */
    @Override
    public ChoiceAnswer insert(ChoiceAnswer choiceAnswer) {
        this.choiceAnswerMapper.insert(choiceAnswer);
        return choiceAnswer;
    }

    /**
     * 修改数据
     *
     * @param choiceAnswer 实例对象
     * @return 实例对象
     */
    @Override
    public ChoiceAnswer update(ChoiceAnswer choiceAnswer) {
        this.choiceAnswerMapper.update(choiceAnswer);
        return this.queryById(choiceAnswer.getAnswerId());
    }

    /**
     * 通过主键删除数据
     *
     * @param answerId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer answerId) {
        return this.choiceAnswerMapper.deleteById(answerId) > 0;
    }
}