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
     * 题目内容
     */
    @ApiModelProperty(value = "题目内容", name = "title", example =
            "  __________是最常用的方法，用来隐藏小数据块，比如加密密钥和数字签名中所用的散列函数值。")
    private String title;
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
    /**
     * A选项
     */
    @FieldMapper(value = "typeA")
    @ApiModelProperty(value = "A选项", name = "choiceTypeA", required = true,example = "数据完整性")
    private String choiceTypeA;
    /**
     * B选项
     */
    @FieldMapper(value = "typeB")
    @ApiModelProperty(value = "B选项", name = "choiceTypeB", required = true,example = "认证协议")
    private String choiceTypeB;
    /**
     * C选项
     */
    @FieldMapper(value = "typeC")
    @ApiModelProperty(value = "C选项", name = "choiceTypeC", required = true,example = "对称密码")
    private String choiceTypeC;
    /**
     * D选项
     */
    @FieldMapper(value = "typeD")
    @ApiModelProperty(value = "D选项", name = "choiceTypeD", required = true,example = "非对称密码(公钥密码)")
    private String choiceTypeD;
}
