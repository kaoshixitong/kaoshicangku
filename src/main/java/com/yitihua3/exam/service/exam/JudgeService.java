package com.yitihua3.exam.service.exam;

import com.yitihua3.exam.entity.exam.Essay;
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
     * @param judgeId 主键
     * @return 实例对象
     */
    Judge queryById(Integer judgeId);

    /**
     * 显示所有数据
     *
     *
     */
    List<Judge> queryAll();

    /**
     * 显示考题数据
     *
     *
     */
    List<Judge> queryAllTest();

    /**
     * 按试卷编号显示考题
     */
    List<Judge> queryAllTestById(Integer paperId);
    /**
    /**
     * 显示某一正确答案
     *
     *
     */
    Judge queryRightById(Integer judgeId);

    /**
     * 显示正确答案
     *
     *
     */
    List<Judge> queryRight(Integer paperId);


    /**
     * 显示某一得分
     *
     *
     */
    Judge queryScoreById(Integer judgeId);

    /**
     * 显示得分
     *
     *
     */
    List<Judge> queryScore(Integer paperId);
    /**
     * 显示所属科目
     *
     *
     */
    Judge querySubjectId(Integer judgeId);

    /**
     * 显示章节
     *
     *
     */
    Judge queryChapterId(Integer judgeId);

    /**
     * 新增数据
     *
     * @param judge 实例对象
     * @return 实例对象
     */
    Judge insert(Judge judge);

    /**
     * 修改数据
     *
     * @param judge 实例对象
     * @return 实例对象
     */
    Judge update(Judge judge);

    /**
     * 通过主键删除数据
     *
     * @param judgeId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer judgeId);

}