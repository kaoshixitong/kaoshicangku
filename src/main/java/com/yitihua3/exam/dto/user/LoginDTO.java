package com.yitihua3.exam.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @author aiwoqe
 * @Type UserDTO
 * @Desc
 * @date 2020年04月28日
 * @Version V1.0
 */
@Data
@AllArgsConstructor
public class LoginDTO {
    /**
     * 用户名
     */
    @NotNull(message="用户名不能为空")
    @Length(min=6, max=10)
    private String username;
    /**
     * 密码
     */
    @NotNull(message="密码不能为空")
    @Length(min=6, max=20)
    private String password;
    /**
     * 角色编号
     */

    private Integer roleId;

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

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
