package com.yitihua3.exam.entity.user;

import lombok.Data;

import java.io.Serializable;
/**
 * (User)实体类
 *
 * @author makejava
 * @since 2020-04-17 22:01:20
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -14210060581838316L;
    /**
     * 用户编号
     */
    private Integer userId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 头像路径
     */
    private String photo;
    /**
     * 加密的盐值
     */
    private String salt;
    /**
     * 用户状态
     */
    private Integer state;
    /**
     * 角色编号
     */
    private Integer roleId;
}