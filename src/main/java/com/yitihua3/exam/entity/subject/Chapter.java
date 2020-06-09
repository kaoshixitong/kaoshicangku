package com.yitihua3.exam.entity.subject;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Chapter)实体类
 *
 * @author makejava
 * @since 2020-04-19 17:19:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chapter implements Serializable {
    private static final long serialVersionUID = 896547759515911503L;
    /**
    * 章节编号
    */
    @ApiModelProperty(value = "章节编号", name = "chapterId", example = "1")
    private Integer chapterId;
    /**
    * 科目从属
    */
    @ApiModelProperty(value = "科目从属", name = "subjectId", example = "1")
    private Integer subjectId;
    /**
    * 章节名字
    */
    @ApiModelProperty(value = "章节名字", name = "name", example = "信息安全概述")
    private String name;

    public Chapter(Integer subjectId, String name) {
        this.subjectId = subjectId;
        this.name = name;
    }

    public Chapter(Integer chapterId) {
        this.chapterId = chapterId;
    }
}