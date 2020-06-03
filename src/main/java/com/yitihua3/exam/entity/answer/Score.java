package com.yitihua3.exam.entity.answer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Score)实体类
 *
 * @author makejava
 * @since 2020-06-03 15:55:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Score implements Serializable {
    private static final long serialVersionUID = 419840965657911337L;
    /**
    * 成绩编号
    */
    private Integer scoreId;
    /**
    * 用户编号
    */
    private Integer userId;
    /**
    * 考试编号
    */
    private Integer examId;
    /**
    * 试卷成绩
    */
    private Integer mark;
    /**
    * 答题开始时间
    */
    private String begin;
    /**
    * 答题结束时间
    */
    private String end;


    public Score(Integer userId, Integer examId) {
        this.userId = userId;
        this.examId = examId;
    }
}