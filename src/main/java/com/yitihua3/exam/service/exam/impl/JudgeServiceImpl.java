package com.yitihua3.exam.service.exam.impl;

import com.yitihua3.exam.entity.exam.Judge;
import com.yitihua3.exam.mapper.exam.JudgeMapper;
import com.yitihua3.exam.service.exam.JudgeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Judge)表服务实现类
 *
 * @author makejava
 * @since 2020-04-19 15:22:38
 */
@Service("JudgeService")
public class JudgeServiceImpl implements JudgeService {
    @Resource
    private JudgeMapper JudgeMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param JudgeId 主键
     * @return 实例对象
     */
    @Override
    public Judge queryById(Integer JudgeId) {
        Judge Judge = JudgeMapper.queryById(JudgeId);
        return Judge;
    }

    /**
     * 显示所有数据
     *
     *
     */
    public List<Judge> queryAll()
    {
        List<Judge> judges = JudgeMapper.queryAll();
        return judges;
    }


    /**
     * 新增数据
     *
     * @param Judge 实例对象
     * @return 实例对象
     */
    @Override
    public Judge insert(Judge Judge) {
        int result = this.JudgeMapper.insert(Judge);
        return Judge;
    }

    /**
     * 修改数据
     *
     * @param Judge 实例对象
     * @return 实例对象
     */
    @Override
    public Judge update(Judge Judge) {
        int result = JudgeMapper.update(Judge);
        Judge Judge1 = queryById(Judge.getJudgeId());
        return Judge1;
    }

    /**
     * 通过主键删除数据
     *
     * @param JudgeId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer JudgeId) {
        int result = JudgeMapper.deleteById(JudgeId);
        if(result>0)
            return true;
        else return false;
    }

    @Override
    public List<Judge> queryAllTest() {
        List<Judge> list = JudgeMapper.queryAllTest();
        return list;
    }

    @Override
    public Judge queryRightById(Integer JudgeId) {
        Judge judge = JudgeMapper.queryRightById(JudgeId);
        return judge;
    }

    @Override
    public List<Judge> queryRight(){
        List<Judge> judges = JudgeMapper.queryRight();
        return judges;
    }


    @Override
    public Judge queryScoreById(Integer JudgeId) {
        Judge judge = JudgeMapper.queryScoreById(JudgeId);
        return judge;
    }

    @Override
    public List<Judge> queryScore() {
        List<Judge> judges = JudgeMapper.queryScore();
        return judges;
    }


    @Override
    public Judge querySubjectId(Integer JudgeId) {
        Judge judge = JudgeMapper.querySubjectById(JudgeId);
        return judge;
    }

    @Override
    public Judge queryChapterId(Integer JudgeId) {
        Judge judge = JudgeMapper.queryChapterById(JudgeId);
        return judge;
    }
}