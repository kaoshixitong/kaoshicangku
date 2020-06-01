package com.yitihua3.exam.service.answer.impl;

import com.yitihua3.exam.entity.answer.EssayAnswer;
import com.yitihua3.exam.mapper.answer.EssayAnswerMapper;
import com.yitihua3.exam.service.answer.EssayAnswerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (EssayAnswer)表服务实现类
 *
 * @author makejava
 * @since 2020-06-01 19:24:18
 */
@Service("essayAnswerService")
public class EssayAnswerServiceImpl implements EssayAnswerService {
    @Resource
    private EssayAnswerMapper essayAnswerMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param answerId 主键
     * @return 实例对象
     */
    @Override
    public EssayAnswer queryById(Integer answerId) {
        return this.essayAnswerMapper.queryById(answerId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<EssayAnswer> queryAllByLimit(int offset, int limit) {
        return this.essayAnswerMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param essayAnswer 实例对象
     * @return 实例对象
     */
    @Override
    public EssayAnswer insert(EssayAnswer essayAnswer) {
        this.essayAnswerMapper.insert(essayAnswer);
        return essayAnswer;
    }

    /**
     * 修改数据
     *
     * @param essayAnswer 实例对象
     * @return 实例对象
     */
    @Override
    public EssayAnswer update(EssayAnswer essayAnswer) {
        this.essayAnswerMapper.update(essayAnswer);
        return this.queryById(essayAnswer.getAnswerId());
    }

    /**
     * 通过主键删除数据
     *
     * @param answerId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer answerId) {
        return this.essayAnswerMapper.deleteById(answerId) > 0;
    }
}