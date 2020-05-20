package com.yitihua3.exam.entity.user;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * (Permission)实体类
 *
 * @author makejava
 * @since 2020-04-16 18:50:57
 */
@Data
public class Permission implements Serializable {
    private static final long serialVersionUID = 561369948658460282L;
    /**
    * 权限编号
    */
    private Integer permissionId;
    /**
    * 权限内容
    */
    private String permission;
    /**
    * 资源url
    */
    private String url;
    /**
    * 权限名字
    */
    private String name;


}