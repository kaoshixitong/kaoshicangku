package com.yitihua3.exam.service.answer;

import com.yitihua3.exam.dto.answer.AnswerDTO;
import com.yitihua3.exam.dto.answer.ScoreResultDTO;

/**
 * @author aiwoqe
 */
public interface AnswerService {
    /**
     * 用于考试作答的提交
     * @param answerDTO
     */
    void insertAnswer(AnswerDTO answerDTO);

    /**
     * 根据用户id和考试id查询考试剩余时间
     * @param examId
     * @param userId
     * @return
     */
    Long getRemaining(int examId,int userId);

    /**
     * 查询考试的结果信息，包括作答情况
     * @param examId
     * @param userId
     * @return
     */
    ScoreResultDTO selectScoreResult(Integer examId, Integer userId);
}
