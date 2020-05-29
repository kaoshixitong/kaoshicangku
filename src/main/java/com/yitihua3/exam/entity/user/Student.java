package com.yitihua3.exam.entity.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
/**
 * (Student)实体类
 *
 * @author makejava
 * @since 2020-04-19 17:17:46
 */
@Getter
@Setter
public class Student implements Serializable{
    private static final long serialVersionUID = -56664928668223580L;
    /**
    * 学生编号
    */
    @ApiModelProperty(value = "学生编号", name = "studentId", required = true, example = "2018011111")
    private Long studentId;
    /**
    * 学生名字
    */
    @ApiModelProperty(value = "学生名字", name = "name", example = "学生1")
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
    * 班级编号
    */
    @ApiModelProperty(value = "班级编号", name = "classId", example = "1")
    private Integer classId;
    /**
    * 手机电话
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