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
    /**
     * 角色状态
     */
    private Integer activeStatus;

    /**
     * 角色码
     *
     */
    private String activeCode;

    public String getActiveCode() {
        return activeCode;
    }

    public void setActiveCode(String activeCode) {
        this.activeCode = activeCode;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}