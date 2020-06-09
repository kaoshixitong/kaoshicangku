package com.yitihua3.exam.dto.exam;

/**
 * @author aiwoqe
 * @Type ExamDTO
 * @Desc
 * @date 2020年04月27日
 * @Version V1.0
 */

import com.yitihua3.exam.dto.common.FieldMapper;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldMapper
public class ExamDTO {
    /**
     * 考试编号
     */
    @ApiModelProperty(value = "考试编号", name = "examId", required = true, example = "1")
    private Integer examId;
    /**
     * 考试名字
     */
    @ApiModelProperty(value = "考试名字", name = "examName", required = true, example = "一模")
    private String examName;
    /**
     * 考试开始时间
     */
    private String begin;
    /**
     * 考试结束时间
     */
    private String end;
    /**
     * 考试时长(分钟)
     */
    private Integer during;
    /**
     * 试卷编号
     */
    private PaperDTO paperDTO;
}
