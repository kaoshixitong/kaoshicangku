package com.yitihua3.exam.entity.exam;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
/**
 * (Paper)实体类
 *
 * @author makejava
 * @since 2020-04-17 21:20:04
 */
@Getter
@Setter
public class Paper implements Serializable {
    private static final long serialVersionUID = 446787645165245338L;
    /**
    * 试卷编号
    */
    private Integer paperId;
    /**
    * 试卷名字
    */
    private String name;
    /**
    * 试卷总分
    */
    private Integer total;

    /**
     *
     * 科目编号
     */
    private Integer subjectId;

    /**
     *
     * 章节编号
     */
    private Integer chapterId;


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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Paper(Integer paperId, String name, Integer total,Integer subjectId,Integer chapterId) {
        this.paperId = paperId;
        this.name = name;
        this.total = total;
        this.subjectId = subjectId;
        this.chapterId = chapterId;
    }
    public Paper( String name, Integer total,Integer subjectId,Integer chapterId) {
        this.name = name;
        this.total = total;
        this.subjectId = subjectId;
        this.chapterId = chapterId;
    }
}