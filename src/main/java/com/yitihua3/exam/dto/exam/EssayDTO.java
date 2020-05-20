package com.yitihua3.exam.dto.exam;

import com.yitihua3.exam.dto.common.FieldMapper;
import com.yitihua3.exam.entity.exam.Essay;
import com.yitihua3.exam.dto.common.AbstractRelationMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author aiwoqe
 * @Type EssayDTO
 * @Desc
 * @date 2020年04月29日
 * @Version V1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldMapper
public class EssayDTO extends AbstractRelationMapper<EssayDTO, Essay> {
    /**
     * 主观题编号
     */
    private Integer essayId;
    /**
     * 题目内容
     */
    @FieldMapper(value = "title")
    private String essayTitle;
    /**
     * 分数
     */
    @FieldMapper(value = "score")
    private Integer essayScore;
    /**
     * 参考答案
     */
    private String reference;
    /**
     * 科目类型
     */
    @FieldMapper(value = "subjectId")
    private Integer essaySubjectId;
    /**
     * 具体章节
     */
    @FieldMapper(value = "chapterId")
    private Integer essayChapterId;
    /**
     * 科目类型
     */
    @FieldMapper(value = "subject")
    private Integer essaySubject;
    /**
     * 具体章节
     */
    @FieldMapper(value = "chapter")
    private Integer essayChapter;

    @Override
    protected EssayDTO setSource() {
        return this;
    }

    @Override
    protected boolean isFieldAnnotationPresent() {
        return true;
    }

}
