package com.yitihua3.exam.service.user;

import com.yitihua3.exam.entity.user.Student;

import java.util.List;

/**
 * (Student)表服务接口
 *
 * @author makejava
 * @since 2020-04-19 17:17:46
 */
public interface StudentService {
    /**
     * 通过用户id来查询学生(需要绑定)
     * @param userId
     * @return
     */
    Student selectStudentByUser(Integer userId);

    /**
     * 通过学生id来查询学生(用于绑定)
     * @param studentId
     * @return
     */
    Student selectStudentById(Long studentId);

    /**
     * 通过学生id
     * @param student
     * @return
     */
    Student updateById(Student student);

    /**
     * 通过用户id
     * @param student
     * @return
     */
    Student updateByUser(Student student);

    /**
     * 查询所有学生
     * @return
     */
    List<Student> selectAll();

    /**
     * 查询所有学生分页
     * @param page
     * @param size
     * @return
     */
    List<Student> selectAllPage(int page, int size);

    /**
     * 按照班级查询所有学生
     * @param classId
     * @return
     */
    List<Student> selectByClass(Integer classId);

    /**
     * 按照班级查询所有学生分页
     * @param classId
     * @return
     */
    List<Student> selectByClassPage(Integer classId,int page, int size);

    /**
     * 增加学生
     * @param student
     */
    void insert(Student student);
}