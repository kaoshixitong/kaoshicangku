package com.yitihua3.exam.service.user.impl;

import com.github.pagehelper.PageHelper;
import com.yitihua3.exam.entity.user.Student;
import com.yitihua3.exam.mapper.user.StudentMapper;
import com.yitihua3.exam.service.user.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public List<Student> selectAll() {
        return studentMapper.queryAll(null);
    }

    @Override
    public List<Student> selectAllPage(int page, int size) {
        PageHelper.startPage(page, size);
        return selectAll();
    }

    @Override
    public List<Student> selectByClass(Integer classId) {
        Student student = new Student();
        student.setClassId(classId);
        return studentMapper.queryAll(student);
    }

    @Override
    public List<Student> selectByClassPage(Integer classId,int page, int size) {
        PageHelper.startPage(page, size);

        return selectByClass(classId);
    }

    @Override
    public void insert(Student student) {
        studentMapper.insert(student);
    }


}