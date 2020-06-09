
package com.yitihua3.exam.mapper.exam;
import com.yitihua3.exam.entity.exam.Choice;

import java.util.List;

/**
 * (Choice)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-25 11:10:21
 */
public interface ChoiceMapper {

    /**
     * 通过Id查询单条数据
     *
     * @param choiceId 主键
     * @return 实例对象
     */
    Choice queryById(Integer choiceId);


    /**
     * 通过实体作为筛选条件查询
     *
     * 
     */
    List<Choice> queryAll();

    /**
     * 列举考生试题
     *
     *
     */
    List<Choice> queryAllTest();

    /**
     * 查询某一得分
     *
     *
     */
    Choice queryScoreById(Integer choiceId);

    /**
     * 查询得分
     *
     *
     */
    List<Choice> queryScore();

    /**
     * 查询某一标准答案
     *
     *
     */
    Choice queryRightById(Integer choiceId);

    /**
     * 查询标准答案
     *
     *
     */
    List<Choice> queryRight();

    /**
     * 查询所属科目
     *
     *
     */
    Choice querySubjectId(Integer choiceId);

    /**
     * 查询所属章节
     *
     *
     */
    Choice queryChapterId(Integer choiceId);

    /**
     * 新增数据
     *
     * @param choice 实例对象
     * @return 影响行数
     */
    int insert(Choice choice);

    /**
     * 修改数据
     *
     * @param choice 实例对象
     * @return 影响行数
     */
    int update(Choice choice);

    /**
     * 通过主键删除数据
     *
     * @param choiceId 主键
     * @return 影响行数
     */
    int deleteById(Integer choiceId);
}