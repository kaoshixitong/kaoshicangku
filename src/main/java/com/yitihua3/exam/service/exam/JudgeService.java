package com.yitihua3.exam.service.exam;

import com.yitihua3.exam.entity.exam.Judge;
import java.util.List;

/**
 * (Judge)表服务接口
 *
 * @author makejava
 * @since 2020-05-25 14:45:55
 */
public interface JudgeService {

    /**
     * 通过ID查询单条数据
     *
     * @param JudgeId 主键
     * @return 实例对象
     */
    Judge queryById(Integer JudgeId);

    /**
     * 显示所有数据
     *
     *
     */
    void queryAll();

    /**
     * 显示考题数据
     *
     *
     */
    void queryAllTest();

    /**
     * 显示某一正确答案
     *
     *
     */
    Judge queryRightById(Integer JudgeId);

    /**
     * 显示正确答案
     *
     *
     */
    Judge queryRight();


    /**
     * 显示某一得分
     *
     *
     */
    Judge queryScoreById(Integer JudgeId);

    /**
     * 显示得分
     *
     *
     */
    Judge queryScore();
    /**
     * 显示所属科目
     *
     *
     */
    Judge querySubjectId(Integer JudgeId);

    /**
     * 显示章节
     *
     *
     */
    Judge queryChapterId(Integer JudgeId);

    /**
     * 新增数据
     *
     * @param Judge 实例对象
     * @return 实例对象
     */
    Judge insert(Judge Judge);

    /**
     * 修改数据
     *
     * @param Judge 实例对象
     * @return 实例对象
     */
    Judge update(Judge Judge);

    /**
     * 通过主键删除数据
     *
     * @param JudgeId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer JudgeId);

}