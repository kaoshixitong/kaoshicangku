package com.yitihua3.exam.entity.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
/**
 * (Teacher)实体类
 *
 * @author makejava
 * @since 2020-04-19 17:17:58
 */
@Getter
@Setter
public class Teacher implements Serializable {
    private static final long serialVersionUID = 318524865997285389L;
    /**
    * 教师编号
    */
    @ApiModelProperty(value = "教师编号", name = "teacherId", required = true, example = "2018000001")
    private Long teacherId;
    /**
    * 教师名字
    */
    @ApiModelProperty(value = "教师名字", name = "name", example = "教师1")
    private String name;
    /**
    * 性别
    */
    @ApiModelProperty(value = "性别", name = "sex", example = "女")
    private String sex;
    /**
    * 出生日期
    */
    @ApiModelProperty(value = "出生日期", name = "birthday", example = "2000-01-01")
    private String birthday;
    /**
    * 电话号码
    */
    @ApiModelProperty(value = "手机电话", name = "phone", example = "110")
    private String phone;
    /**
    * 邮箱
    */
    @ApiModelProperty(value = "邮箱", name = "email", example = "xx@qq.com")
    private String email;
    /**
    * 用户编号
    */
    @ApiModelProperty(value = "用户编号", name = "userId", example = "1")
    private Integer userId;


}