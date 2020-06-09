package com.yitihua3.exam.dto.answer;

import com.yitihua3.exam.dto.common.AbstractRelationMapper;
import com.yitihua3.exam.dto.common.FieldMapper;
import com.yitihua3.exam.entity.answer.ChoiceAnswer;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;




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
@FieldMapper
public class ChoiceAnswerDTO extends AbstractRelationMapper<ChoiceAnswerDTO, ChoiceAnswer> {
    /**
     * 选择题编号
     */
    @ApiModelProperty(value = "选择题编号", name = "choiceId", required = true,example = "1")
    @NotNull(message = "选择题编号不能为空")
    private Integer choiceId;
    /**
     * 得分
     */
    @FieldMapper(value = "score")
    @ApiModelProperty(value = "得分,学生提交时不需要", name = "choiceAnswerScore", example = "")
    private Integer choiceAnswerScore;
    /**
     * 选择的答案
     */
    @FieldMapper(value = "answer")
    @NotNull(message = "选择的答案不能为空")
    @ApiModelProperty(value = "选择的答案", name = "choiceAnswer", required = true,example = "A")
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
