package com.yitihua3.exam.entity.answer;

import com.yitihua3.exam.dto.answer.ChoiceAnswerDTO;
import com.yitihua3.exam.dto.common.AbstractRelationMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
/**
 * (ChoiceAnswer)实体类
 *
 * @author makejava
 * @since 2020-04-18 12:01:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChoiceAnswer extends AbstractRelationMapper<ChoiceAnswer, ChoiceAnswerDTO> implements Serializable {
    private static final long serialVersionUID = -47835140791467993L;
    /**
    * 答题编号
    */
    private Integer answerId;
    /**
    * 选择题编号
    */
    private Integer choiceId;
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


    public ChoiceAnswer(Integer choiceId, Integer userId, Integer examId, Integer score, String answer) {
        this.choiceId = choiceId;
        this.userId = userId;
        this.examId = examId;
        this.score = score;
        this.answer = answer;
    }

    @Override
    protected ChoiceAnswer setSource() {
        return this;
    }

    @Override
    protected boolean isFieldAnnotationPresent() {
        return false;
    }

}