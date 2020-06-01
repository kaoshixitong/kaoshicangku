package com.yitihua3.exam.mapper.subject;

import com.yitihua3.exam.entity.subject.Subject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Subject)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-01 18:01:39
 */
public interface SubjectMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param subjectId 主键
     * @return 实例对象
     */
    Subject queryById(Integer subjectId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Subject> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param subject 实例对象
     * @return 对象列表
     */
    List<Subject> queryAll(Subject subject);

    /**
     * 新增数据
     *
     * @param subject 实例对象
     * @return 影响行数
     */
    int insert(Subject subject);

    /**
     * 修改数据
     *
     * @param subject 实例对象
     * @return 影响行数
     */
    int update(Subject subject);

    /**
     * 通过主键删除数据
     *
     * @param subjectId 主键
     * @return 影响行数
     */
    int deleteById(Integer subjectId);

}