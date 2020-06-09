package com.yitihua3.exam.entity.answer;

import com.yitihua3.exam.dto.common.FieldMapper;
import com.yitihua3.exam.dto.answer.EssayAnswerDTO;
import com.yitihua3.exam.dto.common.AbstractRelationMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
/**
 * (EssayAnswer)实体类
 *
 * @author makejava
 * @since 2020-04-18 12:01:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldMapper
public class EssayAnswer extends AbstractRelationMapper<EssayAnswer, EssayAnswerDTO> implements Serializable {
    private static final long serialVersionUID = 169308431130238163L;
    /**
    * 答题编号
    */
    private Integer answerId;
    /**
    * 主观题编号
    */
    private Integer essayId;
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
    * 回答
    */
    private String answer;


    public EssayAnswer(int essayId, int score, String answer) {
        this.essayId=essayId;
        this.score=score;
        this.answer=answer;
    }

    public EssayAnswer(Integer essayId, Integer userId, Integer examId, Integer score, String answer) {
        this.essayId = essayId;
        this.userId = userId;
        this.examId = examId;
        this.score = score;
        this.answer = answer;
    }

    @Override
    protected EssayAnswer setSource() {
        return this;
    }

    @Override
    protected boolean isFieldAnnotationPresent() {
        return false;
    }

}