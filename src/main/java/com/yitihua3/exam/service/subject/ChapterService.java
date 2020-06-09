package com.yitihua3.exam.service.subject;

import com.yitihua3.exam.entity.subject.Chapter;

import java.util.List;

/**
 * (Chapter)表服务接口
 *
 * @author makejava
 * @since 2020-06-01 17:59:03
 */
public interface ChapterService {

    /**
     * 通过ID查询单条数据
     *
     * @param chapterId 主键
     * @return 实例对象
     */
    Chapter queryById(Integer chapterId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Chapter> queryAllByLimit(int offset, int limit);

    /**
     * 按照科目来查询章节
     * @param subjectId
     * @return
     */
    List<Chapter> queryBySubject(Integer subjectId);

    /**
     * 新增数据
     *
     * @param chapter 实例对象
     * @return 实例对象
     */
    Chapter insert(Chapter chapter);

    /**
     * 修改数据
     *
     * @param chapter 实例对象
     * @return 实例对象
     */
    Chapter update(Chapter chapter);

    /**
     * 通过主键删除数据
     *
     * @param chapterId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer chapterId);

}