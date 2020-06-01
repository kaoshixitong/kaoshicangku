package com.yitihua3.exam.service.exam;

import com.yitihua3.exam.entity.exam.Choice;
import java.util.List;

/**
 * (Choice)表服务接口
 *
 * @author makejava
 * @since 2020-05-25 14:45:55
 */
public interface ChoiceService {

    /**
     * 通过ID查询单条数据
     *
     * @param choiceId 主键
     * @return 实例对象
     */
    Choice queryById(Integer choiceId);

    /**
     * 显示所有数据
     *
     *
     */
    List<Choice> queryAll();

    /**
     * 显示考题数据
     *
     *
     */
    List<Choice> queryAllTest();

    /**
     * 显示某一正确答案
     *
     *
     */
    Choice queryRightById(Integer choiceId);

    /**
     * 显示正确答案
     *
     *
     */
    List<Choice> queryRight();


    /**
     * 显示某一得分
     *
     *
     */
    Choice queryScoreById(Integer choiceId);

    /**
     * 显示得分
     *
     *
     */
    List<Choice> queryScore();
    /**
     * 显示所属科目
     *
     *
     */
    Choice querySubjectId(Integer choiceId);

    /**
     * 显示章节
     *
     *
     */
    Choice queryChapterId(Integer choiceId);

    /**
     * 新增数据
     *
     * @param choice 实例对象
     * @return 实例对象
     */
    Choice insert(Choice choice);

    /**
     * 修改数据
     *
     * @param choice 实例对象
     * @return 实例对象
     */
    Choice update(Choice choice);

    /**
     * 通过主键删除数据
     *
     * @param choiceId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer choiceId);

}