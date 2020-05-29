package com.yitihua3.exam.service.user;

import com.yitihua3.exam.entity.user.Teacher;

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
}