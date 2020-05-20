package com.yitihua3.exam.dto.answer;

import com.yitihua3.exam.dto.common.FieldMapper;
import com.yitihua3.exam.entity.answer.EssayAnswer;
import com.yitihua3.exam.dto.common.AbstractRelationMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author aiwoqe
 * @Type EssayAnswerDTO
 * @Desc
 * @date 2020年04月29日
 * @Version V1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EssayAnswerDTO extends AbstractRelationMapper<EssayAnswerDTO, EssayAnswer> {
    /**
     * 答题编号
     */
    @FieldMapper(value = "answerId")
    private Integer essayAnswerId;
    /**
     * 选择题编号
     */
    private Integer essayId;
    /**
     * 得分
     */
    @FieldMapper(value = "score")
    private Integer essayAnswerScore;
    /**
     * 选择的答案
     */
    @FieldMapper(value = "answer")
    private String essayAnswer;

    @Override
    protected EssayAnswerDTO setSource() {
        return this;
    }

    @Override
    protected boolean isFieldAnnotationPresent() {
        return true;
    }

}
