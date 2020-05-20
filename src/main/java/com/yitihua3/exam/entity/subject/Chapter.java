package com.yitihua3.exam.entity.subject;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
/**
 * (Chapter)实体类
 *
 * @author makejava
 * @since 2020-04-19 17:19:22
 */
@Getter
@Setter
public class Chapter implements Serializable {
    private static final long serialVersionUID = 896547759515911503L;
    /**
    * 章节编号
    */
    private Integer chapterId;
    /**
    * 科目从属
    */
    private Integer subjectId;
    /**
    * 章节名字
    */
    private String name;


}