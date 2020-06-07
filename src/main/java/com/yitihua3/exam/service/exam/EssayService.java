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
     * @param EssayId 主键
     * @return 实例对象
     */
    Essay queryById(Integer EssayId);

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
     * 显示某一正确答案
     *
     *
     */
    Essay queryReferenceById(Integer EssayId);

    /**
     * 显示正确答案
     *
     *
     */
    List<Essay> queryReference();


    /**
     * 显示某一得分
     *
     *
     */
    Essay queryScoreById(Integer EssayId);

    /**
     * 显示得分
     *
     *
     */
    List<Essay> queryScore();
    /**
     * 显示所属科目
     *
     *
     */
    Essay querySubjectId(Integer EssayId);

    /**
     * 显示章节
     *
     *
     */
    Essay queryChapterId(Integer EssayId);

    /**
     * 新增数据
     *
     * @param Essay 实例对象
     * @return 实例对象
     */
    Essay insert(Essay Essay);

    /**
     * 修改数据
     *
     * @param Essay 实例对象
     * @return 实例对象
     */
    Essay update(Essay Essay);

    /**
     * 通过主键删除数据
     *
     * @param EssayId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer EssayId);

}