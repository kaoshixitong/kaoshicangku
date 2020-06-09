package com.yitihua3.exam.dto.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * @author aiwoqe
 * @Type Register
 * @Desc
 * @date 2020年05月21日
 * @Version V1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {
    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名", name = "username", required = true, example = "小明")
    @NotNull(message="用户名不能为空")
    @Length(min=2, max=10,message = "用户名长度需要在2和10之间")
    private String username;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码", name = "password", required = true)
    @NotNull(message="密码不能为空")
    @Length(min=3, max=20,message = "密码长度需要在3和20之间")
    private String password;
    /**
     * 确认密码
     */
    @ApiModelProperty(value = "确认密码", name = "confirm", required = true)
    @NotNull(message="密码不能为空")
    @Length(min=3, max=20,message = "确认密码长度需要在3和20之间")
    private String confirm;

    /**
     * 用户身份
     */
    @ApiModelProperty(value = "角色编号", name = "roleId", required = true,example = "1")
    @NotNull(message = "用户身份不能为空")
    @Range(min=1, max=3,message = "身份id为1或2或3")
    private Integer roleId;

}
