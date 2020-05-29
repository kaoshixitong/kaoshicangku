package com.yitihua3.exam.service.user;

import com.yitihua3.exam.entity.user.Classes;

import java.util.List;

/**
 * (Classes)表服务接口
 *
 * @author makejava
 * @since 2020-04-19 17:16:57
 */
public interface ClassesService {
    /**
     * 返回所有的班级
     * @return
     */
    List<Classes> selectAll();

    /**
     * 修改班级
     * @param classes
     * @return
     */
    Classes updateClasses(Classes classes);

    /**
     * 增加班级
     * @param classes
     */
    void insertClasses(Classes classes);

    /**
     * 删除班级
     * @param classId
     * @return
     */
    Integer deleteClasses(Integer classId);
}