package com.yitihua3.exam.service.user.impl;

import com.yitihua3.exam.entity.user.Student;
import com.yitihua3.exam.mapper.user.StudentMapper;
import com.yitihua3.exam.service.user.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Student)表服务实现类
 *
 * @author makejava
 * @since 2020-04-19 17:17:46
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Resource
    StudentMapper studentMapper;

    @Override
    public Student selectStudentByUser(Integer userId) {
        return studentMapper.queryByUserId(userId);
    }

    @Override
    public Student selectStudentById(Long studentId) {
        return studentMapper.queryById(studentId);
    }

    @Override
    public Student updateById(Student student) {
        studentMapper.update(student);
        return student;
    }

    @Override
    public Student updateByUser(Student student) {
        studentMapper.updateByUser(student);
        return student;
    }


}