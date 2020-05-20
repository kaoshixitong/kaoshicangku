package com.yitihua3.exam.service.user;

import java.util.List;

/**
 * @author aiwoqe
 * @Type JWTService
 * @Desc
 * @date 2020年05月11日
 * @Version V1.0
 */
public interface JWTService {
    String generateJWTToken(String username) ;

    /**
     * 获取上次token生成时的salt值
     * @param username
     * @return
     */
    String getJwtTokenInfo(String username);

    /**
     * 清除token信息
     * @param username 登录用户名
     */
     void deleteLoginInfo(String username);

    /**
     * 获取数据库中保存的用户信息，主要是加密后的密码
     * @param userName
     * @return
     */
//     AuthorizationUserDTO getUserInfo(String userName) ;

    /**
     * 获取用户角色列表，强烈建议从缓存中获取
     * @param userId
     * @return
     */
     List<String> getUserRoles(Long userId);
}
