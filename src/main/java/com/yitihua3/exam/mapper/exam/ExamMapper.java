package com.yitihua3.exam.mapper.exam;
import com.yitihua3.exam.entity.exam.Exam;

import java.util.List;

/**
 * (Exam)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-26 17:06:46
 */
public interface ExamMapper {

    /**
     * 通过Id查询单条数据
     *
     * @param examId 主键
     * @return 实例对象
     */
    Exam queryById(Integer examId);

    /**
     * 通过id查询exam
     * @param examId
     * @return
     * @author aiwoqe
     */
    Exam queryTest(Integer examId);

    /**
     * 通过实体作为筛选条件查询
     *
     */
    List<Exam> queryAll();

    /**
     * 新增数据
     *
     * @param exam 实例对象
     * @return 影响行数
     */
    int insert(Exam exam);

    /**
     * 修改数据
     *
     * @param exam 实例对象
     * @return 影响行数
     */
    int update(Exam exam);

    /**
     * 通过主键删除数据
     *
     * @param examId 主键
     * @return 影响行数
     */
    int deleteById(Integer examId);

}