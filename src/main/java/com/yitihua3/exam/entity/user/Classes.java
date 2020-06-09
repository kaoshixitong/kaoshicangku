package com.yitihua3.exam.entity.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
/**
 * (Classes)实体类
 *
 * @author makejava
 * @since 2020-04-19 17:16:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Classes implements Serializable {
    private static final long serialVersionUID = -11222330554396474L;
    /**
    * 班级编号
    */
    @ApiModelProperty(value = "班级编号", name = "classId", required = true, example = "1")
    private Integer classId;
    /**
    * 班级名字
    */
    @ApiModelProperty(value = "班级名字", name = "name", required = true, example = "软件一班")
    private String name;

    public Classes(String name) {
        this.name = name;
    }
}