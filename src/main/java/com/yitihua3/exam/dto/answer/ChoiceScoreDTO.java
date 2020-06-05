package com.yitihua3.exam.dto.answer;

import com.yitihua3.exam.dto.common.FieldMapper;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author aiwoqe
 * @Type ChoiceScoreDTO
 * @Desc
 * @date 2020年06月05日
 * @Version V1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldMapper
public class ChoiceScoreDTO {
    /**
     * 选择题编号
     */
    @ApiModelProperty(value = "选择题编号", name = "choiceId", required = true,example = "1")
    private Integer choiceId;
    /**
     * 正确答案
     */
    @ApiModelProperty(value = "正确答案", name = "right", required = true,example = "A")
    private String right;
    /**
     * 原题分数
     */
    @ApiModelProperty(value = "原题分数", name = "score", required = true,example = "2")
    private Integer score;
    /**
     * 得分
     */
    @FieldMapper(value = "score")
    @ApiModelProperty(value = "得分", name = "choiceAnswerScore", example = "1")
    private Integer choiceAnswerScore;
    /**
     * 选择的答案
     */
    @FieldMapper(value = "answer")
    @ApiModelProperty(value = "选择的答案", name = "choiceAnswer", required = true,example = "A")
    private String choiceAnswer;
    /**
     * 选择题回答编号
     */
    @FieldMapper(value = "answerId")
    @ApiModelProperty(value = "选择题回答编号", name = "choiceAnswerId", required = true,example = "1")
    private Integer choiceAnswerId;
}
