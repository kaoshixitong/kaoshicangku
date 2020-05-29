package com.yitihua3.exam.service.user;

import com.yitihua3.exam.entity.user.User;

/**
 * @author aiwoqe
 * @Type JWTService
 * @Desc
 * @date 2020年05月11日
 * @Version V1.0
 */
public interface JWTService {
    /**
     * 保存user登录信息，返回token
     * @param user
     * @return
     */
    String generateJWTToken(User user) ;

    /**
     * 获取上次token生成时的salt值
     * @param username
     * @return
     */
    String getJwtTokenSalt(String username);

    /**
     * 清除token信息
     * @param username 登录用户名
     */
     void deleteLoginInfo(String username);


    /**
     * 获取用户信息，强烈建议从缓存中获取
     * @return 用户信息
     */
     User getSubjectUser();
}
