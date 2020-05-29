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
    private EssayMapper EssayMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param EssayId 主键
     * @return 实例对象
     */
    @Override
    public Essay queryById(Integer EssayId) {
        Essay Essay = EssayMapper.queryById(EssayId);
        return Essay;
    }

    /**
     * 显示所有数据
     *
     *
     */
    public void queryAll(){
        EssayMapper.queryAll();
    }


    /**
     * 新增数据
     *
     * @param Essay 实例对象
     * @return 实例对象
     */
    @Override
    public Essay insert(Essay Essay) {
        int result = this.EssayMapper.insert(Essay);
        return Essay;
    }

    /**
     * 修改数据
     *
     * @param Essay 实例对象
     * @return 实例对象
     */
    @Override
    public Essay update(Essay Essay) {
        int result = EssayMapper.update(Essay);
        Essay Essay1 = queryById(Essay.getEssayId());
        return Essay1;
    }

    /**
     * 通过主键删除数据
     *
     * @param EssayId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer EssayId) {
        int result = EssayMapper.deleteById(EssayId);
        if(result>0)
            return true;
        else return false;
    }

    @Override
    public void queryAllTest() {
        List<Essay> list = EssayMapper.queryAllTest();
    }

    @Override
    public Essay queryReferenceById(Integer EssayId) {
        Essay Essay = EssayMapper.queryReferenceById(EssayId);
        return Essay;
    }

    @Override
    public Essay queryReference(){
        Essay Essay = EssayMapper.queryReference();
        return Essay;
    }


    @Override
    public Essay queryScoreById(Integer EssayId) {
        Essay Essay = EssayMapper.queryScoreById(EssayId);
        return Essay;
    }

    @Override
    public Essay queryScore() {
        Essay Essay = EssayMapper.queryScore();
        return Essay;
    }


    @Override
    public Essay querySubjectId(Integer EssayId) {
        Essay Essay = EssayMapper.querySubjectById(EssayId);
        return Essay;
    }

    @Override
    public Essay queryChapterId(Integer EssayId) {
        Essay Essay = EssayMapper.queryChapterById(EssayId);
        return Essay;
    }
}