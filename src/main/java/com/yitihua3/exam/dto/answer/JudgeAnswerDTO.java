package com.yitihua3.exam.dto.answer;

import com.yitihua3.exam.dto.common.FieldMapper;
import com.yitihua3.exam.entity.answer.JudgeAnswer;
import com.yitihua3.exam.dto.common.AbstractRelationMapper;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

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
     * 判断题编号
     */
    @ApiModelProperty(value = "判断题编号", name = "judgeId",required = true, example = "1")
    @NotNull(message = "判断题编号不能为空")
    private Integer judgeId;
    /**
     * 得分
     */
    @FieldMapper(value = "score")
    @ApiModelProperty(value = "得分,学生提交时不需要", name = "judgeAnswerScore", example = "")
    private Integer judgeAnswerScore;
    /**
     * 判断的答案
     */
    @FieldMapper(value = "answer")
    @ApiModelProperty(value = "判断的答案", name = "judgeAnswer", required = true,example = "B")
    @NotNull(message = "判断的答案不能为空")
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
