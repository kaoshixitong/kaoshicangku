package com.yitihua3.exam.dto.user;

import com.yitihua3.exam.dto.common.AbstractRelationMapper;
import com.yitihua3.exam.dto.common.FieldMapper;
import com.yitihua3.exam.entity.user.User;
import lombok.Data;

/**
 * @author aiwoqe
 * @Type UserDTO
 * @Desc
 * @date 2020年05月09日
 * @Version V1.0
 */
@Data
@FieldMapper
public class AuthorizationUserDTO extends AbstractRelationMapper<AuthorizationUserDTO, User> {
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private char[] passwordChar;
    /**
     * 加密密码
     */
    private String password;
    /**
     * 加密的盐值
     */
    private String salt;

    /**
     * 用户状态
     */
    private Integer state;
    /**
     * 角色
     */
    private AuthorizationRoleDTO authorizationRoleDTO;

    @Override
    protected AuthorizationUserDTO setSource() {
        return this;
    }

    @Override
    protected boolean isFieldAnnotationPresent() {
        return true;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public char[] getPasswordChar() {
        return passwordChar;
    }

    public void setPasswordChar(char[] passwordChar) {
        this.passwordChar = passwordChar;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public AuthorizationRoleDTO getAuthorizationRoleDTO() {
        return authorizationRoleDTO;
    }

    public void setAuthorizationRoleDTO(AuthorizationRoleDTO authorizationRoleDTO) {
        this.authorizationRoleDTO = authorizationRoleDTO;
    }
}
