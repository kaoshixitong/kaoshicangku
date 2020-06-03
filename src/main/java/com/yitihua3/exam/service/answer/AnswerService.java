package com.yitihua3.exam.service.answer;

import com.yitihua3.exam.dto.answer.AnswerDTO;

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
}
