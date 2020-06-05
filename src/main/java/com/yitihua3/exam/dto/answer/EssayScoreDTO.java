package com.yitihua3.exam.dto.answer;

import com.yitihua3.exam.dto.common.FieldMapper;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author aiwoqe
 * @Type EssayScoreDTO
 * @Desc
 * @date 2020年06月04日
 * @Version V1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EssayScoreDTO {
    /**
     * 答题编号
     */
    @FieldMapper(value = "answerId")
    @ApiModelProperty(value = "答题编号", name = "essayAnswerId", required = true,example = "1")
    private Integer essayAnswerId;
    /**
     * 得分
     */
    @FieldMapper(value = "score")
    @ApiModelProperty(value = "得分", name = "essayAnswerScore", required = true,example = "")
    private Integer essayAnswerScore;
    /**
     * 填写的答案
     */
    @FieldMapper(value = "answer")
    @ApiModelProperty(value = "填写的答案", name = "essayAnswer", example = "1")
    private String essayAnswer;
    /**
     * 主观题编号
     */
    @ApiModelProperty(value = "主观题编号", name = "essayId", example = "1")
    private Integer essayId;
    /**
     * 题目内容
     */
    @ApiModelProperty(value = "题目内容", name = "title", example =
            "（2）假设P1本来就有一位发生了错误，则这个错误会扩散到多少密文分组？对接收者解密后的结果又什么影响？")
    private String title;
    /**
     * 分数
     */
    @ApiModelProperty(value = "分数", name = "score", example = "10")
    private Integer score;
    /**
     * 参考答案
     */
    @ApiModelProperty(value = "参考答案", name = "reference", example = "略")
    private String reference;
}
