package com.yitihua3.exam.service.user;

import com.yitihua3.exam.entity.user.Teacher;

import java.util.List;

/**
 * (Teacher)表服务接口
 *
 * @author makejava
 * @since 2020-04-19 17:17:58
 */
public interface TeacherService {
    /**
     * 通过用户id来查询教师(需要绑定)
     * @param userId
     * @return
     */
    Teacher selectTeacherByUser(Integer userId);

    /**
     * 通过教师id来查询教师(用于绑定)
     * @param teacherId
     * @return
     */
    Teacher selectTeacherById(Long teacherId);

    /**
     * 通过教师id
     * @param teacher
     * @return
     */
    Teacher updateById(Teacher teacher);

    /**
     * 通过用户id
     * @param teacher
     * @return
     */
    Teacher updateByUser(Teacher teacher);

    /**
     * 查询所有教师
     * @return
     */
    List<Teacher> selectAll();

    /**
     * 查询所有教师分页
     * @param page
     * @param size
     * @return
     */
    List<Teacher> selectAllPage(int page, int size);

    /**
     * 增加教师
     * @param teacher
     */
    void insert(Teacher teacher);
}