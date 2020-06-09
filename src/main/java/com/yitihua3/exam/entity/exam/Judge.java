package com.yitihua3.exam.entity.exam;

import com.yitihua3.exam.dto.exam.JudgeDTO;
import com.yitihua3.exam.dto.common.AbstractRelationMapper;
import io.swagger.models.auth.In;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
/**
 * (Judge)实体类
 *
 * @author makejava
 * @since 2020-04-19 15:22:38
 */
@Data
@NoArgsConstructor
@Getter
@Setter
public class Judge extends AbstractRelationMapper<Judge, JudgeDTO> implements Serializable {
    private static final long serialVersionUID = 270882539600710585L;
    /**
    * 判断题编号
    */
    private Integer judgeId;
    /**
    * 题目内容
    */
    private String title;
    /**
    * 选项A
    */
    private String typeA;
    /**
    * 选项B
    */
    private String typeB;
    /**
    * 正确答案
    */
    private String right;
    /**
    * 分数
    */
    private Integer score;
    /**
    * 科目类型
    */
    private Integer subjectId;
    /**
    * 具体章节
    */
    private Integer chapterId;

    /**
     * 所属试卷
     *
     */
    private Integer paperId;

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getJudgeId() {
        return judgeId;
    }

    public void setJudgeId(Integer judgeId) {
        this.judgeId = judgeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTypeA() {
        return typeA;
    }

    public void setTypeA(String typeA) {
        this.typeA = typeA;
    }

    public String getTypeB() {
        return typeB;
    }

    public void setTypeB(String typeB) {
        this.typeB = typeB;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
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
    protected Judge setSource() {
        return this;
    }

    @Override
    protected boolean isFieldAnnotationPresent() {
        return false;
    }

    public Judge(String right) {
        this.right = right;
    }

    public Judge(Integer score) {
        this.score = score;
    }

    public Judge(Integer judgeId, String title,Integer score, String typeA, String typeB) {
        this.judgeId = judgeId;
        this.title = title;
        this.typeA = typeA;
        this.typeB = typeB;
        this.score = score;
    }

    public Judge(Integer judgeId, String title, String typeA, String typeB, String right, Integer score, Integer subjectId, Integer chapterId, Integer paperId) {
        this.judgeId = judgeId;
        this.title = title;
        this.typeA = typeA;
        this.typeB = typeB;
        this.right = right;
        this.score = score;
        this.subjectId = subjectId;
        this.chapterId = chapterId;
        this.paperId = paperId;
    }
    public Judge( String title, String typeA, String typeB, String right, Integer score, Integer subjectId, Integer chapterId,Integer paperId) {
        this.title = title;
        this.typeA = typeA;
        this.typeB = typeB;
        this.right = right;
        this.score = score;
        this.subjectId = subjectId;
        this.chapterId = chapterId;
        this.paperId = paperId;
    }
}