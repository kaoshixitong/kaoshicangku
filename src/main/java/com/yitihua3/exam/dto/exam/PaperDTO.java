package com.yitihua3.exam.dto.exam;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author aiwoqe
 * @Type PaperDTO
 * @Desc
 * @date 2020年04月27日
 * @Version V1.0
 */
@Data
@AllArgsConstructor
public class PaperDTO{
    /**
     * 试卷编号
     */
    private Integer paperId;
    /**
     * 试卷名字
     */
    private String paperName;
    /**
     * 试卷总分
     */
    private Integer total;
    /**
     * 选择题
     * */
    private List<ChoiceDTO> choiceList;
    /**
     * 判断题
     * */
    private List<JudgeDTO>judgeList;
    /**
     * 主观题
     * */
    private List<EssayDTO>essayList;
    /**
     * 科目类型
     */
    private Integer paperSubject;
    /**
     * 具体章节
     */
    private Integer paperChapter;

}
