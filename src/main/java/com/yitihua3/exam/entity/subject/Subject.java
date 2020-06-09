package com.yitihua3.exam.entity.subject;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
/**
 * (Subject)实体类
 *
 * @author makejava
 * @since 2020-04-19 17:19:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subject implements Serializable {
    private static final long serialVersionUID = 296211198356581115L;
    /**
    * 科目编号
    */
    @ApiModelProperty(value = "科目编号", name = "subjectId", example = "1")
    private Integer subjectId;
    /**
    * 科目名字
    */
    @ApiModelProperty(value = "科目名字", name = "name", example = "信息安全技术")
    private String name;

    public Subject(String name) {
        this.name = name;
    }
}