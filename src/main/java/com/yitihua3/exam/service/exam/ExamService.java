package com.yitihua3.exam.service.exam;
import com.yitihua3.exam.entity.exam.Exam;
import java.util.List;

/**
 * (Exam)表服务接口
 *
 * @author makejava
 * @since 2020-05-26 17:14:19
 */
public interface ExamService {

    /**
     * 通过Id查询单条数据
     *
     * @param examId 主键
     * @return 实例对象
     */
    Exam queryById(Integer examId);

   

    /**
     * 新增数据
     *
     * @param exam 实例对象
     * @return 实例对象
     */
    Exam insert(Exam exam);

    /**
     * 修改数据
     *
     * @param exam 实例对象
     * @return 实例对象
     */
    Exam update(Exam exam);

    /**
     * 通过主键删除数据
     *
     * @param examId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer examId);

    /**
     * 列举所有考试
     * @return
     */
    List<Exam> queryAll();

}