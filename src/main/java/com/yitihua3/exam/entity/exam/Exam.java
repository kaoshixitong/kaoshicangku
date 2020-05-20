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


}