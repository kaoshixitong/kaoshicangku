package com.yitihua3.exam.mapper.user;

import com.yitihua3.exam.entity.user.Classes;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Classes)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-26 22:10:11
 */
public interface ClassesMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param classId 主键
     * @return 实例对象
     */
    Classes queryById(Integer classId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Classes> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param classes 实例对象
     * @return 对象列表
     */
    List<Classes> queryAll(Classes classes);

    /**
     * 新增数据
     *
     * @param classes 实例对象
     * @return 影响行数
     */
    int insert(Classes classes);

    /**
     * 修改数据
     *
     * @param classes 实例对象
     * @return 影响行数
     */
    int update(Classes classes);

    /**
     * 通过主键删除数据
     *
     * @param classId 主键
     * @return 影响行数
     */
    int deleteById(Integer classId);

}