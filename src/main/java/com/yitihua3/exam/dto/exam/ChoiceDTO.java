package com.yitihua3.exam.dto.exam;

import com.yitihua3.exam.dto.common.FieldMapper;
import com.yitihua3.exam.entity.exam.Choice;
import com.yitihua3.exam.dto.common.AbstractRelationMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author aiwoqe
 * @Type ChoiceDTO
 * @Desc
 * @date 2020年04月29日
 * @Version V1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldMapper
public class ChoiceDTO extends AbstractRelationMapper<ChoiceDTO, Choice> {
    /**
     * 选择题编号
     */
    private Integer choiceId;
    /**
     * 题目
     */
    @FieldMapper(value = "title")
    private String choiceTitle;
    /**
     * A选项
     */
    @FieldMapper(value = "typeA")
    private String choiceTypeA;
    /**
     * B选项
     */
    @FieldMapper(value = "typeB")
    private String choiceTypeB;
    /**
     * C选项
     */
    @FieldMapper(value = "typeC")
    private String choiceTypeC;
    /**
     * D选项
     */
    @FieldMapper(value = "typeD")
    private String choiceTypeD;
    /**
     * 正确答案
     */
    @FieldMapper(value = "right")
    private String choiceRight;
    /**
     * 分数
     */
    @FieldMapper(value = "score")
    private Integer choiceScore;
    /**
     * 科目类型
     */
    @FieldMapper(value = "subjectId")
    private Integer choiceSubjectId;
    /**
     * 具体章节
     */
    @FieldMapper(value = "chapterId")
    private Integer choiceChapterId;
    /**
     * 是否单选(1单选0多选)
     */
    private Integer single;
    /**
     * 科目类型
     */
    @FieldMapper(value = "subject")
    private Integer choiceSubject;
    /**
     * 具体章节
     */
    @FieldMapper(value = "chapter")
    private Integer choiceChapter;



    @Override
    protected ChoiceDTO setSource() {
        return this;
    }

    @Override
    protected boolean isFieldAnnotationPresent() {
        return true;
    }

}
