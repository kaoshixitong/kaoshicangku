package com.yitihua3.exam.dto.user;

import com.yitihua3.exam.dto.common.AbstractRelationMapper;
import com.yitihua3.exam.dto.common.FieldMapper;
import com.yitihua3.exam.entity.user.Permission;
import com.yitihua3.exam.entity.user.Role;
import lombok.Data;

import java.util.List;

/**
 * @author aiwoqe
 * @Type RoleDTO
 * @Desc
 * @date 2020年05月09日
 * @Version V1.0
 */
@Data
@FieldMapper
public class AuthorizationRoleDTO extends AbstractRelationMapper<AuthorizationRoleDTO, Role> {
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
    /**
     * 权限
     */
    private List<Permission> permissionList;

    @Override
    protected AuthorizationRoleDTO setSource() {
        return this;
    }

    @Override
    protected boolean isFieldAnnotationPresent() {
        return true;
    }
}
