package com.yitihua3.exam.mapper.subject;

import com.yitihua3.exam.entity.subject.Chapter;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Chapter)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-01 17:59:03
 */
public interface ChapterMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param chapterId 主键
     * @return 实例对象
     */
    Chapter queryById(Integer chapterId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Chapter> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param chapter 实例对象
     * @return 对象列表
     */
    List<Chapter> queryAll(Chapter chapter);

    /**
     * 新增数据
     *
     * @param chapter 实例对象
     * @return 影响行数
     */
    int insert(Chapter chapter);

    /**
     * 修改数据
     *
     * @param chapter 实例对象
     * @return 影响行数
     */
    int update(Chapter chapter);

    /**
     * 通过主键删除数据
     *
     * @param chapterId 主键
     * @return 影响行数
     */
    int deleteById(Integer chapterId);

}