package com.yitihua3.exam.service.subject.impl;

import com.yitihua3.exam.mapper.subject.SubjectMapper;
import com.yitihua3.exam.entity.subject.Subject;
import com.yitihua3.exam.service.subject.SubjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Subject)表服务实现类
 *
 * @author makejava
 * @since 2020-06-01 18:01:39
 */
@Service("subjectService")
public class SubjectServiceImpl implements SubjectService {
    @Resource
    private SubjectMapper subjectMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param subjectId 主键
     * @return 实例对象
     */
    @Override
    public Subject queryById(Integer subjectId) {
        return this.subjectMapper.queryById(subjectId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Subject> queryAllByLimit(int offset, int limit) {
        return this.subjectMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param subject 实例对象
     * @return 实例对象
     */
    @Override
    public Subject insert(Subject subject) {
        this.subjectMapper.insert(subject);
        return subject;
    }

    /**
     * 修改数据
     *
     * @param subject 实例对象
     * @return 实例对象
     */
    @Override
    public Subject update(Subject subject) {
        this.subjectMapper.update(subject);
        return this.queryById(subject.getSubjectId());
    }

    /**
     * 通过主键删除数据
     *
     * @param subjectId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer subjectId) {
        return this.subjectMapper.deleteById(subjectId) > 0;
    }
}