package com.yitihua3.exam.entity.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
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
    @ApiModelProperty(value = "教师编号,修改个人信息时,前面要加teacher.", name = "teacherId", example = "2018000001")
    private Long teacherId;
    /**
    * 教师名字
    */
    @NotNull(message = "教师名字不能为空")
    @Length(min=2, max=5,message = "教师名字长度应大于2小于5")
    @ApiModelProperty(value = "教师名字,修改个人信息时,前面要加teacher.", name = "name", required = true,example = "教师1")
    private String name;
    /**
    * 性别
    */
    @ApiModelProperty(value = "性别,修改个人信息时,前面要加teacher.", name = "sex", example = "女")
    private String sex;
    /**
    * 出生日期
    */
    @ApiModelProperty(value = "出生日期,修改个人信息时,前面要加teacher.", name = "birthday", example = "2000-01-01")
    private String birthday;
    /**
    * 电话号码
    */
    @ApiModelProperty(value = "手机电话,修改个人信息时,前面要加teacher.", name = "phone", example = "110")
    private String phone;
    /**
    * 邮箱
    */
    @ApiModelProperty(value = "邮箱,修改个人信息时,前面要加teacher.", name = "email", example = "xx@qq.com")
    private String email;
    /**
    * 用户编号
    */
    @ApiModelProperty(value = "用户编号,修改个人信息时,前面要加teacher.", name = "userId", example = "1")
    private Integer userId;
}