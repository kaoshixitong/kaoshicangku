package com.yitihua3.exam.service.answer.impl;

import com.yitihua3.exam.dto.answer.JudgeScoreDTO;
import com.yitihua3.exam.entity.answer.JudgeAnswer;
import com.yitihua3.exam.mapper.answer.JudgeAnswerMapper;
import com.yitihua3.exam.mapper.exam.JudgeMapper;
import com.yitihua3.exam.service.answer.JudgeAnswerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (JudgeAnswer)表服务实现类
 *
 * @author makejava
 * @since 2020-06-01 19:14:32
 */
@Service("judgeAnswerService")
public class JudgeAnswerServiceImpl implements JudgeAnswerService {
    @Resource
    private JudgeAnswerMapper judgeAnswerMapper;

    @Resource
    private JudgeMapper judgeMapper;

    @Override
    public List<JudgeScoreDTO> selectJudgeScore(Integer examId, Integer userId) {
        return judgeAnswerMapper.selectJudgeScore(examId, userId);
    }

    @Override
    public int updateAnswerScore(List<JudgeScoreDTO> answerScoreList){
        int judgeMark = compareAndScore(answerScoreList);
        judgeAnswerMapper.updateScoreList(answerScoreList);
        return judgeMark;
    }

    private int compareAndScore(List<JudgeScoreDTO> answerScoreList){
        int judgeMark=0;
        for (JudgeScoreDTO judgeScoreDTO:answerScoreList){
            String right = judgeScoreDTO.getRight();
            String answer = judgeScoreDTO.getJudgeAnswer();
            Integer score = judgeScoreDTO.getScore();
            if (right.equals(answer)){
                judgeScoreDTO.setJudgeAnswerScore(score);
                judgeMark+=score;
            }else {
                judgeScoreDTO.setJudgeAnswerScore(0);
            }
        }
        return judgeMark;
    }

    /**
     * 通过ID查询单条数据
     *
     * @param answerId 主键
     * @return 实例对象
     */
    @Override
    public JudgeAnswer queryById(Integer answerId) {
        return this.judgeAnswerMapper.queryById(answerId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<JudgeAnswer> queryAllByLimit(int offset, int limit) {
        return this.judgeAnswerMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param judgeAnswer 实例对象
     * @return 实例对象
     */
    @Override
    public JudgeAnswer insert(JudgeAnswer judgeAnswer) {
        this.judgeAnswerMapper.insert(judgeAnswer);
        return judgeAnswer;
    }

    /**
     * 修改数据
     *
     * @param judgeAnswer 实例对象
     * @return 实例对象
     */
    @Override
    public JudgeAnswer update(JudgeAnswer judgeAnswer) {
        this.judgeAnswerMapper.update(judgeAnswer);
        return this.queryById(judgeAnswer.getAnswerId());
    }

    /**
     * 通过主键删除数据
     *
     * @param answerId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer answerId) {
        return this.judgeAnswerMapper.deleteById(answerId) > 0;
    }
}