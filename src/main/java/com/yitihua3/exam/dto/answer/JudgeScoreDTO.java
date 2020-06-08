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
     * 题目内容
     */
    @ApiModelProperty(value = "题目内容", name = "title", example =
            "随着多年的研究和部署，目前能够开发出没有安全缺陷的，而且能阻止所有的非授权行为的安全设计和实现技术。")
    private String title;
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
    @ApiModelProperty(value = "选择题回答编号", name = "judgeAnswerId", required = true,example = "1")
    private Integer judgeAnswerId;
    /**
     * 选项A
     */
    @FieldMapper(value = "typeA")
    @ApiModelProperty(value = "选项A", name = "judgeTypeA", required = true,example = "√")
    private String judgeTypeA;
    /**
     * 选项B
     */
    @FieldMapper(value = "typeB")
    @ApiModelProperty(value = "选项B", name = "judgeTypeB", required = true,example = "x")
    private String judgeTypeB;

}
