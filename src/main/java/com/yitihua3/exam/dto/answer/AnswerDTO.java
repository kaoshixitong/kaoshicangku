package com.yitihua3.exam.dto.answer;

import com.yitihua3.exam.dto.common.AbstractRelationMapper;
import com.yitihua3.exam.dto.common.FieldMapper;
import com.yitihua3.exam.entity.answer.Score;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author aiwoqe
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldMapper(share = {"examId","userId"})
public class AnswerDTO extends AbstractRelationMapper<AnswerDTO, Score> {
    /**
     * 考试编号
     */
    @ApiModelProperty(value = "考试编号", name = "examId", required = true, example = "1")
    @NotNull(message = "考试编号不能为空")
    private Integer examId;
    /**
     * 用户编号
     */
    @ApiModelProperty(value = "用户编号", name = "userId", required = true, example = "1")
    @NotNull(message = "用户编号不能为空")
    private Integer userId;
    /**
     * 答题结束时间
     *
     */
    @ApiModelProperty(value = "答题结束时间，格式yyyy-MM-dd HH:mm:ss", name = "end", required = true, example = "2020-03-01 14:49:44")
    @NotNull(message = "答题结束时间不能为空")
    private String end;
    /**
     * 选择题
     */
    @ApiModelProperty(value = "选择题集合", name = "choiceAnswerList", example = "")
    private List<ChoiceAnswerDTO>choiceAnswerList;
    /**
     * 判断题
     */
    @ApiModelProperty(value = "判断题集合", name = "judgeAnswerList", example = "")
    private List<JudgeAnswerDTO>judgeAnswerList;
    /**
     * 主观题
     */
    @ApiModelProperty(value = "主观题集合", name = "essayAnswerList",  example = "")
    private List<EssayAnswerDTO>essayAnswerList;

    @Override
    protected AnswerDTO setSource() {
        return this;
    }

    @Override
    protected boolean isFieldAnnotationPresent() {
        return true;
    }
}
    /**
     * 考试限制时间
     */
//    @ApiModelProperty(value = "考试限制时间(分钟)", name = "during", required = true, example = "60")
//    @NotNull(message = "考试时长不能为空")
//    private Integer during;