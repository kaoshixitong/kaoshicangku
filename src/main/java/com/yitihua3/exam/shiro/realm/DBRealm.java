package com.yitihua3.exam.shiro.realm;

import com.yitihua3.exam.dto.user.AuthorizationRoleDTO;
import com.yitihua3.exam.dto.user.AuthorizationUserDTO;
import com.yitihua3.exam.entity.user.Permission;
import com.yitihua3.exam.entity.user.User;
import com.yitihua3.exam.mapper.user.UserMapper;
import com.yitihua3.exam.shiro.token.RoleToken;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * @author aiwoqe
 * @Type DBRealm
 * @Desc
 * @date 2020年05月09日
 * @Version V1.0
 */
public class DBRealm extends AuthorizingRealm {

    @Resource
    UserMapper userMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        //拿到当前登录这个对象
        User user = (User)principalCollection.getPrimaryPrincipal();
        AuthorizationUserDTO authorizationUserDTO = userMapper.selectCompleteUser(user.getUsername());
        AuthorizationRoleDTO authorizationRoleDTO = authorizationUserDTO.getAuthorizationRoleDTO();
        SimpleAuthorizationInfo authorizationInfo =  new SimpleAuthorizationInfo();
        authorizationInfo.addRole(authorizationRoleDTO.getRole());

        //获取用户权限
        Set<Permission> permissions = new HashSet<>(authorizationRoleDTO.getPermissionList());
        for (Permission permission:permissions) {
            authorizationInfo.addStringPermission(permission.getPermission());
        }
        return authorizationInfo;
    }

    private static final int LOCKED=1;
    private static final int DISABLED=2;
    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        RoleToken roleToken=(RoleToken)authenticationToken;
        String username = roleToken.getUsername();
        User user = userMapper.selectByUsername(username);
        if (user == null ) {
            throw new UnknownAccountException("用户名或密码错误！");
        }
        if (roleToken.getRoleId()==null || !user.getRoleId().equals(roleToken.getRoleId())) {
            throw new UnknownAccountException("用户名或密码错误！");
        }

        if (LOCKED==(user.getState())) {
            throw new LockedAccountException("账号已被锁定,请联系管理员！");
        }

        if (DISABLED==(user.getState())) {
            throw new DisabledAccountException("账号已被禁用,请联系管理员！");
        }
        ByteSource salt = ByteSource.Util.bytes(user.getSalt());

        return new SimpleAuthenticationInfo(user,user.getPassword(),salt , getName());
    }


    /**
     * 加密，替换当前Realm的credentialsMatcher属性，直接使用HashedCredentialsMatcher对象并设置加密算法
     * @param credentialsMatcher
     */
    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        // 构建凭证对象
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        // 设置加密算法
        matcher.setHashAlgorithmName("MD5");
        // 设置加密次数
        matcher.setHashIterations(2);
        super.setCredentialsMatcher(matcher);
    }


    /**
     * 重写方法,清除当前用户的的 授权缓存
     * @param principals
     */
    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    /**
     * 重写方法，清除当前用户的 认证缓存
     * @param principals
     */
    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    /**
     * 自定义方法：清除所有 授权缓存
     */
    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    /**
     * 自定义方法：清除所有 认证缓存
     */
    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    /**
     * 自定义方法：清除所有的  认证缓存  和 授权缓存
     */
    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }

}
