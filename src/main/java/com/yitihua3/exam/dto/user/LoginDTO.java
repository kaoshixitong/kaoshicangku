package com.yitihua3.exam.dto.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

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
    @ApiModelProperty(value = "用户名", name = "username", required = true, example = "小明")
    @NotNull(message="用户名不能为空")
    @Length(min=2, max=10,message = "用户名长度应大于2小于10")
    private String username;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码", name = "password", required = true)
    @NotNull(message="密码不能为空")
    @Length(min=3, max=20,message = "密码长度应大于3小于20")
    private String password;
    /**
     * 角色编号
     */
    @ApiModelProperty(value = "角色编号", name = "roleId", required = true,example = "1")
    @NotNull(message="身份编号不能为空")
    @Range(min=1, max=3,message = "身份id为1或2或3")
    private Integer roleId;
}
