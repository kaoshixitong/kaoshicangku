package com.yitihua3.exam.dto.answer;

import com.yitihua3.exam.dto.common.FieldMapper;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author aiwoqe
 * @Type JudgeScoreDTO
 * @Desc
 * @date 2020年06月05日
 * @Version V1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldMapper
public class JudgeScoreDTO {
    /**
     * 判断题编号
     */
    @ApiModelProperty(value = "判断题编号", name = "judgeId",required = true, example = "1")
    private Integer judgeId;
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
    @ApiModelProperty(value = "得分", name = "judgeAnswerScore", example = "1")
    private Integer judgeAnswerScore;
    /**
     * 判断的答案
     */
    @FieldMapper(value = "answer")
    @ApiModelProperty(value = "判断的答案", name = "judgeAnswer", required = true,example = "B")
    private String judgeAnswer;
    /**
     * 判断题回答编号
     */
    @FieldMapper(value = "answerId")
    @ApiModelProperty(value = "选择题回答编号", name = "判断题回答编号", required = true,example = "1")
    private Integer judgeAnswerId;
}
