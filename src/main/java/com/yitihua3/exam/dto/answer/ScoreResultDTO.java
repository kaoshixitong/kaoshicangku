package com.yitihua3.exam.dto.answer;

import com.yitihua3.exam.dto.common.FieldMapper;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author aiwoqe
 * @Type ScoreResultDTO
 * @Desc
 * @date 2020年06月08日
 * @Version V1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldMapper
public class ScoreResultDTO {
    /**
     * 考试名字
     */
    @ApiModelProperty(value = "考试名字", name = "mark" ,example = "三模")
    private String examName;
    /**
     * 科目名字
     */
    @ApiModelProperty(value = "科目名字", name = "subjectName" ,example = "信息安全技术")
    private String subjectName;
    /**
     * 章节名字
     */
    @ApiModelProperty(value = "章节名字", name = "chapterName" ,example = "信息安全概述")
    private String chapterName;
    /**
     * 答题开始时间
     */
    @ApiModelProperty(value = "答题开始时间", name = "begin" ,example = "2020-06-03 23:17:04")
    private String begin;
    /**
     * 答题结束时间
     */
    @ApiModelProperty(value = "答题结束时间", name = "end" ,example = "2020-03-01 14:49:44")
    private String end;
    /**
     * 考试时长(分钟)
     */
    @ApiModelProperty(value = "考试时长(分钟)", name = "during" ,example = "80")
    private Integer during;
    /**
     * 选择题作答及原题对象
     */
    @ApiModelProperty(value = "选择题作答及原题对象", name = "choiceScoreList")
    List<ChoiceScoreDTO> choiceScoreList;
    /**
     * 判断题题作答及原题对象
     */
    @ApiModelProperty(value = "判断题题作答及原题对象", name = "judgeScoreList")
    List<JudgeScoreDTO> judgeScoreList;
    /**
     * 应用题作答及原题对象
     */
    @ApiModelProperty(value = "应用题作答及原题对象", name = "essayScoreList" )
    List<EssayScoreDTO> essayScoreList;
    /**
     * 总分
     */
    @ApiModelProperty(value = "总分", name = "mark" ,example = "100")
    private Integer mark;
}
