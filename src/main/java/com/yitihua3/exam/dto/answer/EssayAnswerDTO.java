package com.yitihua3.exam.dto.answer;

import com.yitihua3.exam.dto.common.FieldMapper;
import com.yitihua3.exam.entity.answer.EssayAnswer;
import com.yitihua3.exam.dto.common.AbstractRelationMapper;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

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
@FieldMapper
public class EssayAnswerDTO extends AbstractRelationMapper<EssayAnswerDTO, EssayAnswer> {
    /**
     * 应用题编号
     */
    @ApiModelProperty(value = "应用题编号", name = "essayId", required = true,example = "1")
    @NotNull(message = "应用题编号不能为空")
    private Integer essayId;
    /**
     * 得分
     */
    @FieldMapper(value = "score")
    @ApiModelProperty(value = "得分,学生提交时不需要", name = "essayAnswerScore", example = "")
    private Integer essayAnswerScore;
    /**
     * 填写的答案
     */
    @FieldMapper(value = "answer")
    @ApiModelProperty(value = "填写的答案", name = "essayAnswer", required = true,example = "保密性，可认证性。。")
    @NotNull(message = "填写的答案不能为空")
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
