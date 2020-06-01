package com.yitihua3.exam.mapper.answer;

import com.yitihua3.exam.entity.answer.JudgeAnswer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (JudgeAnswer)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-01 19:14:32
 */
public interface JudgeAnswerMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param answerId 主键
     * @return 实例对象
     */
    JudgeAnswer queryById(Integer answerId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<JudgeAnswer> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param judgeAnswer 实例对象
     * @return 对象列表
     */
    List<JudgeAnswer> queryAll(JudgeAnswer judgeAnswer);

    /**
     * 新增数据
     *
     * @param judgeAnswer 实例对象
     * @return 影响行数
     */
    int insert(JudgeAnswer judgeAnswer);

    /**
     * 修改数据
     *
     * @param judgeAnswer 实例对象
     * @return 影响行数
     */
    int update(JudgeAnswer judgeAnswer);

    /**
     * 通过主键删除数据
     *
     * @param answerId 主键
     * @return 影响行数
     */
    int deleteById(Integer answerId);

}