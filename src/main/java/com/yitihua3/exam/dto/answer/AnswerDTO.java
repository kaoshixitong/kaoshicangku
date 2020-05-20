package com.yitihua3.exam.dto.answer;

import com.yitihua3.exam.dto.common.FieldMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author aiwoqe
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldMapper(share = {"examId","userId"})
public class AnswerDTO {
    /**
     * 考试编号
     */
    private Integer examId;
    /**
     * 用户编号
     */
    private Integer userId;
    /**
     * 选择题
     */
    private List<ChoiceAnswerDTO>choiceAnswerList;
    /**
     * 判断题
     */
    private List<JudgeAnswerDTO>judgeAnswerList;
    /**
     * 主观题
     */
    private List<EssayAnswerDTO>essayAnswerList;


}
