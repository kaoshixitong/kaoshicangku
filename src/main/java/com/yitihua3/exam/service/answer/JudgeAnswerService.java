package com.yitihua3.exam.service.answer;

import com.yitihua3.exam.entity.answer.JudgeAnswer;

import java.util.List;

/**
 * (JudgeAnswer)表服务接口
 *
 * @author makejava
 * @since 2020-06-01 19:14:32
 */
public interface JudgeAnswerService {

    /**
     * 通过ID查询单条数据
     *
     * @param answerId 主键
     * @return 实例对象
     */
    JudgeAnswer queryById(Integer answerId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<JudgeAnswer> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param judgeAnswer 实例对象
     * @return 实例对象
     */
    JudgeAnswer insert(JudgeAnswer judgeAnswer);

    /**
     * 修改数据
     *
     * @param judgeAnswer 实例对象
     * @return 实例对象
     */
    JudgeAnswer update(JudgeAnswer judgeAnswer);

    /**
     * 通过主键删除数据
     *
     * @param answerId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer answerId);

}