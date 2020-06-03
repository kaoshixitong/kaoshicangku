package com.yitihua3.exam.service.answer.impl;

import com.yitihua3.exam.entity.answer.Score;
import com.yitihua3.exam.mapper.answer.ScoreMapper;
import com.yitihua3.exam.service.answer.ScoreService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Score)表服务实现类
 *
 * @author makejava
 * @since 2020-06-03 15:55:51
 */
@Service("scoreService")
public class ScoreServiceImpl implements ScoreService {
    @Resource
    private ScoreMapper scoreMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param scoreId 主键
     * @return 实例对象
     */
    @Override
    public Score queryById(Integer scoreId) {
        return this.scoreMapper.queryById(scoreId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Score> queryAllByLimit(int offset, int limit) {
        return this.scoreMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param score 实例对象
     * @return 实例对象
     */
    @Override
    public Score insert(Score score) {
        this.scoreMapper.insert(score);
        return score;
    }

    /**
     * 修改数据
     *
     * @param score 实例对象
     * @return 实例对象
     */
    @Override
    public Score update(Score score) {
        this.scoreMapper.update(score);
        return this.queryById(score.getScoreId());
    }

    /**
     * 通过主键删除数据
     *
     * @param scoreId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer scoreId) {
        return this.scoreMapper.deleteById(scoreId) > 0;
    }
}