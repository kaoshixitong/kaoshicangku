package com.yitihua3.exam.entity.subject;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
/**
 * (Subject)实体类
 *
 * @author makejava
 * @since 2020-04-19 17:19:36
 */
@Getter
@Setter
public class Subject implements Serializable {
    private static final long serialVersionUID = 296211198356581115L;
    /**
    * 科目编号
    */
    private Integer subjectId;
    /**
    * 科目名字
    */
    private String name;
}