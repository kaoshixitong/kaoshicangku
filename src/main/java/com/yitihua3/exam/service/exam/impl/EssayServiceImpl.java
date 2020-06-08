package com.yitihua3.exam.service.exam.impl;

import com.yitihua3.exam.entity.exam.Essay;
import com.yitihua3.exam.mapper.exam.EssayMapper;
import com.yitihua3.exam.service.exam.EssayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Essay)表服务实现类
 *
 * @author makejava
 * @since 2020-04-19 15:22:47
 */
@Service("EssayService")
public class EssayServiceImpl implements EssayService {
    @Resource
    private EssayMapper essayMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param essayId 主键
     * @return 实例对象
     */
    @Override
    public Essay queryById(Integer essayId) {
        Essay essay = essayMapper.queryById(essayId);
        return essay;
    }

    /**
     * 显示所有数据
     *
     *
     */
    public List<Essay> queryAll(){
        List<Essay> essays = essayMapper.queryAll();
        return essays;
    }
    @Override
    public List<Essay> queryAllTestById(Integer paperId) {
        List<Essay> essay = essayMapper.queryAllTestById(paperId);
        return essay;
    }

    /**
     * 新增数据
     *
     * @param essay 实例对象
     * @return 实例对象
     */
    @Override
    public Essay insert(Essay essay) {
        int result = essayMapper.insert(essay);
        return essay;
    }

    /**
     * 修改数据
     *
     * @param essay 实例对象
     * @return 实例对象
     */
    @Override
    public Essay update(Essay essay) {
        int result = essayMapper.update(essay);
        Essay essay1 = queryById(essay.getEssayId());
        return essay1;
    }

    /**
     * 通过主键删除数据
     *
     * @param essayId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer essayId) {
        int result = essayMapper.deleteById(essayId);
        if(result>0)
            return true;
        else return false;
    }

    @Override
    public List<Essay> queryAllTest() {
        List<Essay> list = essayMapper.queryAllTest();
        return list;
    }

    @Override
    public Essay queryReferenceById(Integer essayId) {
        Essay essay = essayMapper.queryReferenceById(essayId);
        return essay;
    }

    @Override
    public List<Essay> queryReference(Integer paperId){
        List<Essay> essays = essayMapper.queryReference(paperId);
        return essays;
    }


    @Override
    public Essay queryScoreById(Integer essayId) {
        Essay essay = essayMapper.queryScoreById(essayId);
        return essay;
    }

    @Override
    public List<Essay> queryScore(Integer paperId) {
        List<Essay> essays = essayMapper.queryScore(paperId);
        return essays;
    }


    @Override
    public Essay querySubjectId(Integer essayId) {
        Essay essay = essayMapper.querySubjectById(essayId);
        return essay;
    }

    @Override
    public Essay queryChapterId(Integer essayId) {
        Essay essay = essayMapper.queryChapterById(essayId);
        return essay;
    }
}