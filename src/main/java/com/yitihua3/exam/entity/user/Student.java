package com.yitihua3.exam.entity.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
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
    @ApiModelProperty(value = "学生编号,修改个人信息时,前面要加student.", name = "studentId", example = "2018011111")
    private Long studentId;
    /**
    * 学生名字
    */
    @NotNull(message = "学生名字不能为空")
    @Length(min=2, max=5,message = "学生名字长度应大于2小于5")
    @ApiModelProperty(value = "学生名字,修改个人信息时,前面要加student.", name = "name",required = true, example = "学生1")
    private String name;
    /**
    * 性别
    */
    @ApiModelProperty(value = "性别,修改个人信息时,前面要加student.", name = "sex", example = "女")
    private String sex;
    /**
    * 出生日期
    */
    @ApiModelProperty(value = "出生日期,修改个人信息时,前面要加student.", name = "birthday", example = "2000-01-01")
    private String birthday;
    /**
    * 班级编号
    */
    @ApiModelProperty(value = "班级编号,修改个人信息时,前面要加student.", name = "classId", example = "1")
    private Integer classId;
    /**
    * 手机电话
    */
    @ApiModelProperty(value = "手机电话,修改个人信息时,前面要加student.", name = "phone", example = "110")
    private String phone;
    /**
    * 邮箱
    */
    @ApiModelProperty(value = "邮箱,修改个人信息时,前面要加student.", name = "email", example = "xx@qq.com")
    private String email;
    /**
    * 用户编号
    */
    @ApiModelProperty(value = "用户编号,修改个人信息时,前面要加student.", name = "userId", example = "1")
    private Integer userId;
}