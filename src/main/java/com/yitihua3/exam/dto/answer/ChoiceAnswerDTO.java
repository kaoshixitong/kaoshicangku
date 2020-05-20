package com.yitihua3.exam.dto.answer;

import com.yitihua3.exam.dto.common.FieldMapper;
import com.yitihua3.exam.entity.answer.ChoiceAnswer;
import com.yitihua3.exam.dto.common.AbstractRelationMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author aiwoqe
 * @Type ChoiceAnswer
 * @Desc
 * @date 2020年04月29日
 * @Version V1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldMapper(exclude = {"score","choiceId"})//属性是目标的属性
public class ChoiceAnswerDTO extends AbstractRelationMapper<ChoiceAnswerDTO, ChoiceAnswer> {
    /**
     * 答题编号
     */
    @FieldMapper(value = "answerId")
    private Integer choiceAnswerId;
    /**
     * 选择题编号
     */
    private Integer choiceId;
    /**
     * 得分
     */
    @FieldMapper(value = "score")
    private Integer choiceAnswerScore;
    /**
     * 选择的答案
     */
    @FieldMapper(value = "answer")
    private String choiceAnswer;

    @Override
    protected ChoiceAnswerDTO setSource() {
        return this;
    }

    @Override
    protected boolean isFieldAnnotationPresent() {
        return true;
    }

}
