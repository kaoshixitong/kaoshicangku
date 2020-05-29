package com.yitihua3.exam.service.user.impl;

import com.yitihua3.exam.entity.user.User;
import com.yitihua3.exam.exception.ServiceException;
import com.yitihua3.exam.response.ResultCode;
import com.yitihua3.exam.service.user.JWTService;
import com.yitihua3.exam.utils.JWTUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author aiwoqe
 * @Type JWTService
 * @Desc
 * @date 2020年05月11日
 * @Version V1.0
 */
@Service("jwtService")
public class JWTServiceImpl implements JWTService {

    private static final String JWT_TOKEN_PREFIX = "jwt:token:";

    private static final long EXPIRE=3600*24*5;

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 保存user登录信息，返回token
     * @param user
     */
    @Override
    public String generateJWTToken(User user) {

        String salt = JWTUtils.generateSalt();
        //salt保存到数据库或者缓存中
        redisTemplate.opsForValue().set(JWT_TOKEN_PREFIX+user.getUsername(), salt, EXPIRE, TimeUnit.SECONDS);
        //生成jwt token，设置过期时间为1小时
        return JWTUtils.sign(user.getUsername(), user.getUserId(), salt, EXPIRE);
    }

    /**
     * 获取上次token生成时的salt值和登录用户信息
     * @param username
     * @return
     */
    @Override
    public String getJwtTokenSalt(String username) {
        //从数据库或者缓存中取出jwt token生成时用的salt
        String salt = redisTemplate.opsForValue().get(JWT_TOKEN_PREFIX+username);
        if (salt==null){
            throw new ServiceException(ResultCode.NO_LOGIN,"服务端发生错误请重新登录");
        }
        return salt;
    }

    /**
     * 清除token信息
     * @param username 登录用户名
     */
    @Override
    public void deleteLoginInfo(String username) {
        //删除数据库或者缓存中保存的salt
        redisTemplate.delete(JWT_TOKEN_PREFIX+username);
    }

    /**
     * 获取用户信息，强烈建议从缓存中获取
     * @return 用户信息
     */
    @Override
    public User getSubjectUser() {
        Subject subject= SecurityUtils.getSubject();
        User user = (User)subject.getPrincipals().getPrimaryPrincipal();
        return user;
    }
}
