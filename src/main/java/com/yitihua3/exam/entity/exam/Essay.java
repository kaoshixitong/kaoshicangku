package com.yitihua3.exam.entity.exam;

import com.yitihua3.exam.dto.exam.EssayDTO;
import com.yitihua3.exam.dto.common.AbstractRelationMapper;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
/**
 * (Essay)实体类
 *
 * @author makejava
 * @since 2020-04-19 15:22:47
 */
@Data
@NoArgsConstructor
@Getter
@Setter
public class Essay extends AbstractRelationMapper<Essay, EssayDTO> implements Serializable {
    private static final long serialVersionUID = -28314802908035852L;
    /**
    * 主观题编号
    */
    private Integer essayId;
    /**
    * 题目内容
    */
    private String title;
    /**
    * 分数
    */
    private Integer score;
    /**
    * 参考答案
    */
    private String reference;
    /**
    * 科目类型
    */
    private Integer subjectId;
    /**
    * 具体章节
    */
    private Integer chapterId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getEssayId() {
        return essayId;
    }

    public void setEssayId(Integer essayId) {
        this.essayId = essayId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getChapterId() {
        return chapterId;
    }

    public void setChapterId(Integer chapterId) {
        this.chapterId = chapterId;
    }

    @Override
    protected Essay setSource() {
        return this;
    }

    @Override
    protected boolean isFieldAnnotationPresent() {
        return false;
    }

    public Essay(Integer score) {
        this.score = score;
    }

    public Essay(String reference) {
        this.reference = reference;
    }

    public Essay(Integer essayId, String title, Integer score, String reference, Integer subjectId, Integer chapterId) {
        this.essayId = essayId;
        this.title = title;
        this.score = score;
        this.reference = reference;
        this.subjectId = subjectId;
        this.chapterId = chapterId;
    }

    public Essay( String title, Integer score, String reference, Integer subjectId, Integer chapterId) {
        this.title = title;
        this.score = score;
        this.reference = reference;
        this.subjectId = subjectId;
        this.chapterId = chapterId;
    }


}