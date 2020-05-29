package com.yitihua3.exam.entity.exam;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
/**
 * (Exam)实体类
 *
 * @author makejava
 * @since 2020-04-28 20:42:34
 */
@Getter
@Setter
public class Exam implements Serializable {
    private static final long serialVersionUID = 177938692851206493L;
    /**
    * 考试编号
    */
    private Integer examId;
    /**
    * 考试名字
    */
    private String name;
    /**
    * 考试开始时间
    */
    private String begin;
    /**
    * 考试结束时间
    */
    private String end;
    /**
    * 考试时长(分钟)
    */
    private Integer during;
    /**
    * 试卷编号
    */
    private Integer paperId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Integer getDuring() {
        return during;
    }

    public void setDuring(Integer during) {
        this.during = during;
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public Exam(Integer examId, String name, String begin, String end, Integer during, Integer paperId) {
        this.examId = examId;
        this.name = name;
        this.begin = begin;
        this.end = end;
        this.during = during;
        this.paperId = paperId;
    }


}