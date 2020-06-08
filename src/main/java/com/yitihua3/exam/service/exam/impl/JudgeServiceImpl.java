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
    private JudgeMapper judgeMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param judgeId 主键
     * @return 实例对象
     */
    @Override
    public Judge queryById(Integer judgeId) {
        Judge judge = judgeMapper.queryById(judgeId);
        return judge;
    }

    /**
     * 显示所有数据
     *
     *
     */
    public List<Judge> queryAll()
    {
        List<Judge> judges = judgeMapper.queryAll();
        return judges;
    }

    @Override
    public List<Judge> queryAllTestById(Integer paperId) {
        List<Judge> judge = judgeMapper.queryAllTestById(paperId);
        return judge;
    }

    /**
     * 新增数据
     *
     * @param judge 实例对象
     * @return 实例对象
     */
    @Override
    public Judge insert(Judge judge) {
        int result = this.judgeMapper.insert(judge);
        return judge;
    }

    /**
     * 修改数据
     *
     * @param judge 实例对象
     * @return 实例对象
     */
    @Override
    public Judge update(Judge judge) {
        int result = judgeMapper.update(judge);
        Judge judge1 = queryById(judge.getJudgeId());
        return judge1;
    }

    /**
     * 通过主键删除数据
     *
     * @param judgeId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer judgeId) {
        int result = judgeMapper.deleteById(judgeId);
        if(result>0)
            return true;
        else return false;
    }

    @Override
    public List<Judge> queryAllTest() {
        List<Judge> list = judgeMapper.queryAllTest();
        return list;
    }

    @Override
    public Judge queryRightById(Integer judgeId) {
        Judge judge = judgeMapper.queryRightById(judgeId);
        return judge;
    }

    @Override
    public List<Judge> queryRight(Integer paperId){
        List<Judge> judges = judgeMapper.queryRight(paperId);
        return judges;
    }


    @Override
    public Judge queryScoreById(Integer judgeId) {
        Judge judge = judgeMapper.queryScoreById(judgeId);
        return judge;
    }

    @Override
    public List<Judge> queryScore(Integer paperId) {
        List<Judge> judges = judgeMapper.queryScore(paperId);
        return judges;
    }


    @Override
    public Judge querySubjectId(Integer judgeId) {
        Judge judge = judgeMapper.querySubjectById(judgeId);
        return judge;
    }

    @Override
    public Judge queryChapterId(Integer judgeId) {
        Judge judge = judgeMapper.queryChapterById(judgeId);
        return judge;
    }
}