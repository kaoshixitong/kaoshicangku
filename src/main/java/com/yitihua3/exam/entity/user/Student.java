package com.yitihua3.exam.entity.user;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
/**
 * (Student)实体类
 *
 * @author makejava
 * @since 2020-04-19 17:17:46
 */
@Getter
@Setter
public class Student implements Serializable {
    private static final long serialVersionUID = -56664928668223580L;
    /**
    * 学生编号
    */
    private Long studentId;
    /**
    * 学生名字
    */
    private String name;
    /**
    * 性别
    */
    private String sex;
    /**
    * 出生日期
    */
    private String birthday;
    /**
    * 班级编号
    */
    private Integer classId;
    /**
    * 手机电话
    */
    private String phone;
    /**
    * 邮箱
    */
    private String email;
    /**
    * 用户编号
    */
    private Integer userId;


}