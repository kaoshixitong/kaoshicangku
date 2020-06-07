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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}