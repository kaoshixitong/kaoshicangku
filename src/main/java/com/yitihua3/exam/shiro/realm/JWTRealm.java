package com.yitihua3.exam.shiro.realm;


import com.yitihua3.exam.entity.user.User;
import com.yitihua3.exam.mapper.user.UserMapper;
import com.yitihua3.exam.shiro.token.JWTToken;
import com.yitihua3.exam.utils.JWTUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.context.annotation.Lazy;

import javax.annotation.Resource;


public class JWTRealm extends AuthorizingRealm {

    @Lazy
    @Resource
    UserMapper userMapper;

    private static final int LOCKED=1;
    private static final int DISABLED=2;
    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = (String) authenticationToken.getCredentials();
        // 解密获得username，用于和数据库进行对比
        String username = JWTUtils.getUsername(token);
        User user = userMapper.selectByUsername(username);
        if (user == null) {
            // || !user.getRoleId().equals(token.)
            throw new UnknownAccountException("用户名或密码错误！");
        }

        if (LOCKED==(user.getState())) {
            throw new LockedAccountException("账号已被锁定,请联系管理员！");
        }

        if (DISABLED==(user.getState())) {
            throw new DisabledAccountException("账号已被禁用,请联系管理员！");
        }
        return new SimpleAuthenticationInfo(user.getUsername(),user.getSalt(), getName());
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * 重写方法,清除当前用户的的 授权缓存
     * @param principals
     */
    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
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
