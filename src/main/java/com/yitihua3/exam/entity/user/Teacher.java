package com.yitihua3.exam.entity.user;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
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
    private Long teacherId;
    /**
    * 教师名字
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
    * 电话号码
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