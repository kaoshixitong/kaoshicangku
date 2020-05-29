package com.yitihua3.exam.service.exam.impl;

import com.yitihua3.exam.entity.exam.Paper;
import com.yitihua3.exam.mapper.exam.PaperMapper;
import com.yitihua3.exam.service.exam.PaperService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Paper)表服务实现类
 *
 * @author makejava
 * @since 2020-05-26 17:25:41
 */
@Service("paperService")
public class PaperServiceImpl implements PaperService {
    @Resource
    private PaperMapper paperMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param paperId 主键
     * @return 实例对象
     */
    @Override
    public Paper queryById(Integer paperId) {
        return this.paperMapper.queryById(paperId);
    }

  

    /**
     * 新增数据
     *
     * @param paper 实例对象
     * @return 实例对象
     */
    @Override
    public Paper insert(Paper paper) {
        this.paperMapper.insert(paper);
        return paper;
    }

    /**
     * 修改数据
     *
     * @param paper 实例对象
     * @return 实例对象
     */
    @Override
    public Paper update(Paper paper) {
        this.paperMapper.update(paper);
        return this.queryById(paper.getPaperId());
    }

    /**
     * 通过主键删除数据
     *
     * @param paperId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer paperId) {
        return this.paperMapper.deleteById(paperId) > 0;
    }

    @Override
    public List<Paper> queryAll() {
        return this.paperMapper.queryAll();
    }
}