package com.yitihua3.exam.dto.answer;

import com.yitihua3.exam.dto.common.FieldMapper;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author aiwoqe
 * @Type ScoreSubmitDTO
 * @Desc
 * @date 2020年06月05日
 * @Version V1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldMapper
public class ScoreSubmitDTO {
    /**
     * 应用题作答及原题对象
     */
    @ApiModelProperty(value = "应用题作答及原题对象", name = "essayScoreList", required = true)
    @NotNull(message = "应用题作答及原题对象不能为空")
    List<EssayScoreDTO> essayScoreList;
    /**
     * 考试编号
     */
    @ApiModelProperty(value = "考试编号", name = "examId", required = true, example = "1")
    @NotNull(message = "考试编号不能为空")
    private Integer examId;
    /**
     * 用户编号
     */
    @ApiModelProperty(value = "用户编号", name = "userId", required = true,example = "1")
    @NotNull(message = "用户编号不能为空")
    private Integer userId;
}
