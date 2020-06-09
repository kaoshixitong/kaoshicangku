package com.yitihua3.exam.service.exam;

import com.yitihua3.exam.entity.exam.Essay;
import java.util.List;

/**
 * (Essay)表服务接口
 *
 * @author makejava
 * @since 2020-05-25 14:45:55
 */
public interface EssayService {

    /**
     * 通过ID查询单条数据
     *
     * @param essayId 主键
     * @return 实例对象
     */
    Essay queryById(Integer essayId);

    /**
     * 显示所有数据
     *
     *
     */
    List<Essay> queryAll();

    /**
     * 显示考题数据
     *
     *
     */
    List<Essay> queryAllTest();

    /**
     * 按试卷编号显示考题
     */
    List<Essay> queryAllTestById(Integer paperId);
    /**
     * 显示某一正确答案
     *
     *
     */
    Essay queryReferenceById(Integer essayId);

    /**
     * 显示正确答案
     *
     *
     */
    List<Essay> queryReference(Integer paperId);


    /**
     * 显示某一得分
     *
     *
     */
    Essay queryScoreById(Integer essayId);

    /**
     * 显示得分
     *
     *
     */
    List<Essay> queryScore(Integer paperId);
    /**
     * 显示所属科目
     *
     *
     */
    Essay querySubjectId(Integer essayId);

    /**
     * 显示章节
     *
     *
     */
    Essay queryChapterId(Integer essayId);

    /**
     * 新增数据
     *
     * @param essay 实例对象
     * @return 实例对象
     */
    Essay insert(Essay essay);

    /**
     * 修改数据
     *
     * @param essay 实例对象
     * @return 实例对象
     */
    Essay update(Essay essay);

    /**
     * 通过主键删除数据
     *
     * @param essayId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer essayId);

}