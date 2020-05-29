package com.yitihua3.exam.service.exam.impl;

import com.yitihua3.exam.entity.exam.Exam;
import com.yitihua3.exam.mapper.exam.ExamMapper;
import com.yitihua3.exam.service.exam.ExamService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Exam)表服务实现类
 *
 * @author makejava
 * @since 2020-05-26 17:24:11
 */
@Service("examService")
public class ExamServiceImpl implements ExamService {
    @Resource
    private ExamMapper examMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param examId 主键
     * @return 实例对象
     */
    @Override
    public Exam queryById(Integer examId) {
        return examMapper.queryById(examId);
    }

  

    /**
     * 新增数据
     *
     * @param exam 实例对象
     * @return 实例对象
     */
    @Override
    public Exam insert(Exam exam) {
        this.examMapper.insert(exam);
        return exam;
    }

    /**
     * 修改数据
     *
     * @param exam 实例对象
     * @return 实例对象
     */
    @Override
    public Exam update(Exam exam) {
        this.examMapper.update(exam);
        return queryById(exam.getExamId());
    }

    /**
     * 通过主键删除数据
     *
     * @param examId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer examId) {
        return examMapper.deleteById(examId) > 0;
    }

    @Override
    public List<Exam> queryAll() {
        return examMapper.queryAll();
    }
}