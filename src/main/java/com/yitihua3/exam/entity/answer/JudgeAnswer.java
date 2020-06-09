package com.yitihua3.exam.entity.answer;

import com.yitihua3.exam.dto.answer.JudgeAnswerDTO;
import com.yitihua3.exam.dto.common.AbstractRelationMapper;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
/**
 * (JudgeAnswer)实体类
 *
 * @author makejava
 * @since 2020-04-18 12:02:14
 */
@Data
@NoArgsConstructor
public class JudgeAnswer extends AbstractRelationMapper<JudgeAnswer, JudgeAnswerDTO> implements Serializable {
    private static final long serialVersionUID = -27669137763772829L;
    /**
    * 答题编号
    */
    private Integer answerId;
    /**
    * 判断题编号
    */
    private Integer judgeId;
    /**
    * 用户编号
    */
    private Integer userId;
    /**
    * 考试编号
    */
    private Integer examId;
    /**
    * 得分
    */
    private Integer score;
    /**
    * 选择的答案
    */
    private String answer;


    public JudgeAnswer(int judgeId, int score, String answer) {
        this.judgeId=judgeId;
        this.score=score;
        this.answer=answer;
    }

    public JudgeAnswer(Integer judgeId, Integer userId, Integer examId, Integer score, String answer) {
        this.judgeId = judgeId;
        this.userId = userId;
        this.examId = examId;
        this.score = score;
        this.answer = answer;
    }

    @Override
    protected JudgeAnswer setSource() {
        return this;
    }

    @Override
    protected boolean isFieldAnnotationPresent() {
        return false;
    }

}