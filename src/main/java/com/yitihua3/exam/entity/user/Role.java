package com.yitihua3.exam.entity.user;

import lombok.Data;

import java.io.Serializable;

/**
 * (Role)实体类
 *
 * @author makejava
 * @since 2020-04-16 18:50:19
 */
@Data
public class Role implements Serializable {
    private static final long serialVersionUID = 453501224338129885L;
    /**
    * 角色编号
    */
    private Integer roleId;
    /**
    * 角色
    */
    private String role;
    /**
    * 角色描述
    */
    private String description;

}