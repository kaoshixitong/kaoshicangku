package com.yitihua3.exam.entity.exam;

import com.yitihua3.exam.dto.exam.ChoiceDTO;
import com.yitihua3.exam.dto.common.AbstractRelationMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
/**
 * (Choice)实体类
 *
 * @author makejava
 * @since 2020-04-19 15:22:27
 */
@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Choice extends AbstractRelationMapper<Choice,ChoiceDTO> implements Serializable {
    private static final long serialVersionUID = -47025859645571687L;
    /**
    * 选择题编号
    */
    private Integer choiceId;
    /**
    * 题目
    */
    private String title;
    /**
    * A选项
    */
    private String typeA;
    /**
    * B选项
    */
    private String typeB;
    /**
    * C选项
    */
    private String typeC;
    /**
    * D选项
    */
    private String typeD;
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
    * 是否单选(1单选0多选)
    */
    private Integer single;
    /**
     * 所属试卷
     */
    private Integer paperId;

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    @Override
    protected Choice setSource() {
        return this;
    }

    @Override
    protected boolean isFieldAnnotationPresent() {
        return false;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getChoiceId() {
        return choiceId;
    }

    public void setChoiceId(Integer choiceId) {
        this.choiceId = choiceId;
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

    public String getTypeC() {
        return typeC;
    }

    public void setTypeC(String typeC) {
        this.typeC = typeC;
    }

    public String getTypeD() {
        return typeD;
    }

    public void setTypeD(String typeD) {
        this.typeD = typeD;
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

    public Integer getSingle() {
        return single;
    }

    public void setSingle(Integer single) {
        this.single = single;
    }

    public Choice( String title, String typeA, String typeB, String typeC, String typeD, String right, Integer score, Integer subjectId, Integer chapterId, Integer single,Integer paperId) {
        this.title = title;
        this.typeA = typeA;
        this.typeB = typeB;
        this.typeC = typeC;
        this.typeD = typeD;
        this.right = right;
        this.score = score;
        this.subjectId = subjectId;
        this.chapterId = chapterId;
        this.single = single;
        this.paperId = paperId;
    }

    public Choice(Integer choiceId, String title, String typeA, String typeB, String typeC, String typeD, String right, Integer score, Integer subjectId, Integer chapterId, Integer single,Integer paperId) {
        this.choiceId = choiceId;
        this.title = title;
        this.typeA = typeA;
        this.typeB = typeB;
        this.typeC = typeC;
        this.typeD = typeD;
        this.right = right;
        this.score = score;
        this.subjectId = subjectId;
        this.chapterId = chapterId;
        this.single = single;
        this.paperId = paperId;
    }

    public Choice(Integer choiceId, String title,Integer score, String typeA, String typeB, String typeC, String typeD) {
        this.choiceId = choiceId;
        this.title = title;
        this.typeA = typeA;
        this.typeB = typeB;
        this.typeC = typeC;
        this.typeD = typeD;
        this.score = score;

    }

    public Choice(Integer score) {
       this.score = score;
    }

    public Choice(String right) {
        this.right = right;
    }

}