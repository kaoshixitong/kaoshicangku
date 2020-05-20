package com.yitihua3.exam.dto.exam;

import com.yitihua3.exam.dto.common.FieldMapper;
import com.yitihua3.exam.entity.exam.Judge;
import com.yitihua3.exam.dto.common.AbstractRelationMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author aiwoqe
 * @Type JudgeDTO
 * @Desc
 * @date 2020年04月29日
 * @Version V1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldMapper
public class JudgeDTO extends AbstractRelationMapper<JudgeDTO, Judge> {
    /**
     * 判断题编号
     */
    private Integer judgeId;
    /**
     * 题目内容
     */
    @FieldMapper(value = "title")
    private String judgeTitle;
    /**
     * 选项A
     */
    @FieldMapper(value = "typeA")
    private String judgeTypeA;
    /**
     * 选项B
     */
    @FieldMapper(value = "typeB")
    private String judgeTypeB;
    /**
     * 正确答案
     */
    @FieldMapper(value = "right")
    private String judgeRight;
    /**
     * 分数
     */
    @FieldMapper(value = "score")
    private String judgeScore;
    /**
     * 科目类型
     */
    @FieldMapper(value = "subjectId")
    private Integer judgeSubjectId;
    /**
     * 具体章节
     */
    @FieldMapper(value = "chapterId")
    private Integer judgeChapterId;
    /**
     * 科目类型
     */
    @FieldMapper(value = "subject")
    private Integer judgeSubject;
    /**
     * 具体章节
     */
    @FieldMapper(value = "chapter")
    private Integer judgeChapter;

    @Override
    protected JudgeDTO setSource() {
        return this;
    }

    @Override
    protected boolean isFieldAnnotationPresent() {
        return true;
    }

}
