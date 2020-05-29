package com.yitihua3.exam.service.user.impl;

import com.yitihua3.exam.entity.user.Teacher;
import com.yitihua3.exam.mapper.user.TeacherMapper;
import com.yitihua3.exam.service.user.TeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Teacher)表服务实现类
 *
 * @author makejava
 * @since 2020-04-19 17:17:58
 */
@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {

    @Resource
    TeacherMapper teacherMapper;

    @Override
    public Teacher selectTeacherByUser(Integer userId) {
        return teacherMapper.queryByUserId(userId);
    }

    @Override
    public Teacher selectTeacherById(Long teacherId) {
        return teacherMapper.queryById(teacherId);
    }

    @Override
    public Teacher updateById(Teacher teacher) {
        teacherMapper.update(teacher);
        return teacher;
    }

    @Override
    public Teacher updateByUser(Teacher teacher) {
        teacherMapper.updateByUser(teacher);
        return teacher;
    }
}