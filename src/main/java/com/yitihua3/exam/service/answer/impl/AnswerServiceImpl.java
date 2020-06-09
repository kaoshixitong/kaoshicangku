package com.yitihua3.exam.service.answer.impl;

import com.yitihua3.exam.dto.answer.*;
import com.yitihua3.exam.dto.common.AbstractRelationMapper;
import com.yitihua3.exam.entity.answer.ChoiceAnswer;
import com.yitihua3.exam.entity.answer.EssayAnswer;
import com.yitihua3.exam.entity.answer.JudgeAnswer;
import com.yitihua3.exam.entity.answer.Score;
import com.yitihua3.exam.entity.exam.Exam;
import com.yitihua3.exam.exception.ClientException;
import com.yitihua3.exam.exception.ServiceException;
import com.yitihua3.exam.mapper.answer.ChoiceAnswerMapper;
import com.yitihua3.exam.mapper.answer.EssayAnswerMapper;
import com.yitihua3.exam.mapper.answer.JudgeAnswerMapper;
import com.yitihua3.exam.mapper.answer.ScoreMapper;
import com.yitihua3.exam.mapper.exam.ExamMapper;
import com.yitihua3.exam.response.ResultCode;
import com.yitihua3.exam.service.answer.AnswerService;
import com.yitihua3.exam.utils.TypeConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

/**
 * @author aiwoqe
 */
@Service("answerService")
public class AnswerServiceImpl implements AnswerService {


    @Resource
    ChoiceAnswerMapper choiceAnswerMapper;

    @Resource
    JudgeAnswerMapper judgeAnswerMapper;

    @Resource
    EssayAnswerMapper essayAnswerMapper;

    @Resource
    ScoreMapper scoreMapper;

    @Override
    public void insertAnswer(AnswerDTO answerDTO) {
        Score score = answerDTO.convert();
        Integer examId = score.getExamId();
        Integer userId = score.getUserId();

        List<Score> scoreList = scoreMapper.queryAll(new Score(userId,examId));
        if(!CollectionUtils.isEmpty(scoreList))
            throw new ClientException(ResultCode.ANSWER_EXCEPTION,"你已完成作答,不能再次作答");

        Object o = hashtable.get(generatorKey(examId,userId ));
        if(o==null)
            throw new ClientException(ResultCode.ANSWER_EXCEPTION,"需使用/answer/queryRemaining接口");
        Long beginMillis = (Long)o;

        String begin = TypeConverter.dateToString(new Date(beginMillis));
        score.setBegin(begin);
        scoreMapper.insert(score);

        List<ChoiceAnswer> choiceAnswerList = AbstractRelationMapper.listConvertAndAdd(answerDTO.getChoiceAnswerList(), answerDTO);
        List<EssayAnswer> essayAnswerList = AbstractRelationMapper.listConvertAndAdd(answerDTO.getEssayAnswerList(), answerDTO);
        List<JudgeAnswer> judgeAnswerList = AbstractRelationMapper.listConvertAndAdd(answerDTO.getJudgeAnswerList(), answerDTO);

        choiceAnswerMapper.insertList(choiceAnswerList);
        judgeAnswerMapper.insertList(judgeAnswerList);
        essayAnswerMapper.insertList(essayAnswerList);
    }

    /**
     * Hashtable key生成策略
     * @param examId
     * @param userId
     * @return
     */
    private String generatorKey(int examId, int userId){
        return examId+"&"+userId;
    }

    /**
     * 分钟到毫秒的转换
     */
    private final static long rate=60*1000;
    /**
     * 存入答题开始时间
     */
    private Hashtable hashtable=new Hashtable();

    @Resource
    private ExamMapper examMapper;

    @Override
    public Long getRemaining(int examId,int userId) {
        List<Score> scoreList = scoreMapper.queryAll(new Score(userId,examId));
        if(!CollectionUtils.isEmpty(scoreList))
            throw new ClientException(ResultCode.ANSWER_EXCEPTION,"该考生已作答过,不用计算时间");


        //数据库获取考试时长
        Exam exam = examMapper.queryTest(examId);
        if(exam==null)
            throw new ServiceException(ResultCode.DATABASE_EXCEPTION,"相关考试为空");
        Integer during = exam.getDuring();
        if(during==null)
            throw new ServiceException(ResultCode.DATABASE_EXCEPTION,"存入考试的时间为空");

        String key = generatorKey(examId, userId);
        long deadline = rate*during;
        //如果用户开始的考试未存进hashtable，就存；否则计算剩余时间
        if (!hashtable.containsKey(key)) {
            Long beginMillis=System.currentTimeMillis();
            hashtable.put(key,beginMillis);
            return deadline;
        }
        long beginMillis = (long)hashtable.get(key);

        //超时检测
        if(beginMillis+deadline<=System.currentTimeMillis()){
            return 0L;
        }
        return deadline+beginMillis-System.currentTimeMillis();
    }

    @Override
    public ScoreResultDTO selectScoreResult(Integer examId, Integer userId) {
        List<ChoiceScoreDTO> choiceScoreList = choiceAnswerMapper.selectChoiceScore(examId, userId);
        List<JudgeScoreDTO> judgeScoreList = judgeAnswerMapper.selectJudgeScore(examId, userId);
        List<EssayScoreDTO> essayScoreList = essayAnswerMapper.selectEssayScore(examId, userId);
        ScoreResultDTO scoreResult = scoreMapper.selectScoreResult(examId, userId);
        scoreResult.setChoiceScoreList(choiceScoreList);
        scoreResult.setJudgeScoreList(judgeScoreList);
        scoreResult.setEssayScoreList(essayScoreList);
        return scoreResult;
    }

}
