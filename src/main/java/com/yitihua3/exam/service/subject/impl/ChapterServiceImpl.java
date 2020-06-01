package com.yitihua3.exam.service.subject.impl;

import com.yitihua3.exam.mapper.subject.ChapterMapper;
import com.yitihua3.exam.entity.subject.Chapter;
import com.yitihua3.exam.service.subject.ChapterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Chapter)表服务实现类
 *
 * @author makejava
 * @since 2020-06-01 17:59:03
 */
@Service("chapterService")
public class ChapterServiceImpl implements ChapterService {
    @Resource
    private ChapterMapper chapterMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param chapterId 主键
     * @return 实例对象
     */
    @Override
    public Chapter queryById(Integer chapterId) {
        return this.chapterMapper.queryById(chapterId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Chapter> queryAllByLimit(int offset, int limit) {
        return this.chapterMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param chapter 实例对象
     * @return 实例对象
     */
    @Override
    public Chapter insert(Chapter chapter) {
        this.chapterMapper.insert(chapter);
        return chapter;
    }

    /**
     * 修改数据
     *
     * @param chapter 实例对象
     * @return 实例对象
     */
    @Override
    public Chapter update(Chapter chapter) {
        this.chapterMapper.update(chapter);
        return this.queryById(chapter.getChapterId());
    }

    /**
     * 通过主键删除数据
     *
     * @param chapterId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer chapterId) {
        return this.chapterMapper.deleteById(chapterId) > 0;
    }
}