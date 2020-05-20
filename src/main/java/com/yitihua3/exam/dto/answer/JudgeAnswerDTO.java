package com.yitihua3.exam.dto.answer;

import com.yitihua3.exam.dto.common.FieldMapper;
import com.yitihua3.exam.entity.answer.JudgeAnswer;
import com.yitihua3.exam.dto.common.AbstractRelationMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author aiwoqe
 * @Type JudgeAnswerDTO
 * @Desc
 * @date 2020年04月29日
 * @Version V1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldMapper
public class JudgeAnswerDTO extends AbstractRelationMapper<JudgeAnswerDTO, JudgeAnswer> {
    /**
     * 答题编号
     */
    @FieldMapper(value = "answerId")
    private Integer judgeAnswerId;
    /**
     * 判断题编号
     */
    private Integer judgeId;
    /**
     * 得分
     */
    @FieldMapper(value = "score")
    private Integer judgeAnswerScore;
    /**
     * 判断的答案
     */
    @FieldMapper(value = "answer")
    private String judgeAnswer;

    @Override
    protected JudgeAnswerDTO setSource() {
        return this;
    }

    @Override
    protected boolean isFieldAnnotationPresent() {
        return true;
    }

}
