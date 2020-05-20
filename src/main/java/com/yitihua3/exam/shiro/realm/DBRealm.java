package com.yitihua3.exam.shiro.realm;

import com.yitihua3.exam.dto.user.AuthorizationRoleDTO;
import com.yitihua3.exam.dto.user.AuthorizationUserDTO;
import com.yitihua3.exam.entity.user.Permission;
import com.yitihua3.exam.entity.user.User;
import com.yitihua3.exam.mapper.user.UserMapper;
import com.yitihua3.exam.shiro.token.RoleToken;
import com.yitihua3.exam.utils.JWTUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.context.annotation.Lazy;

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

    @Lazy
    @Resource
    UserMapper userMapper;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();

        //拿到当前登录这个对象
        String username = JWTUtils.getUsername(principalCollection.getPrimaryPrincipal().toString());
        AuthorizationUserDTO authorizationUserDTO =userMapper.selectCompleteUser(username);
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
    private static final String ENCRYPT_SALT = "F12839WhsnnEV$#23b";
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

        return new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(), ByteSource.Util.bytes(ENCRYPT_SALT), getName());
    }

    //加密，替换当前Realm的credentialsMatcher属性，直接使用HashedCredentialsMatcher对象并设置加密算法
//    @Override
//    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
//        // 构建凭证对象
//        HashedCredentialsMatcher cMatcher = new HashedCredentialsMatcher();
//        // 设置加密算法
//        cMatcher.setHashAlgorithmName("MD5");
//        // 设置加密次数
//        cMatcher.setHashIterations(1);
//        super.setCredentialsMatcher(cMatcher);
//    }


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
