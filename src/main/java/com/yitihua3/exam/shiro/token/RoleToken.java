package com.yitihua3.exam.shiro.token;

import com.yitihua3.exam.dto.user.LoginDTO;
import lombok.Getter;
import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @author aiwoqe
 * @Type RoleToken
 * @Desc
 * @date 2020年05月09日
 * @Version V1.0
 */
@Getter
public class RoleToken extends UsernamePasswordToken {
    private Integer roleId;

    public RoleToken(LoginDTO loginDTO) {
        super(loginDTO.getUsername(),loginDTO.getPassword());
        this.roleId = loginDTO.getRoleId();
    }
}
