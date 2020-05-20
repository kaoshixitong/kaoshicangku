package com.yitihua3.exam.service.user.impl;

import com.yitihua3.exam.mapper.user.UserMapper;
import com.yitihua3.exam.service.user.JWTService;
import com.yitihua3.exam.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
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
    private static final String encryptSalt = "F12839WhsnnEV$#23b";

    private static final String JWT_TOKEN_PREFIX = "jwt:token:";

    private static final long EXPIRE=3600;

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 保存user登录信息，返回token
     * @param username
     */

    @Resource
    UserMapper userMapper;

    @Override
    public String generateJWTToken(String username) {

        String salt = JWTUtils.generateSalt();
        //salt保存到数据库或者缓存中
        redisTemplate.opsForValue().set(JWT_TOKEN_PREFIX+username, salt, EXPIRE, TimeUnit.SECONDS);
        userMapper.updateSaltByUsername(salt,username);
        //生成jwt token，设置过期时间为1小时
        return JWTUtils.sign(username, salt, EXPIRE);
    }

    /**
     * 获取上次token生成时的salt值和登录用户信息
     * @param username
     * @return
     */
    @Override
    public String getJwtTokenInfo(String username) {
        //从数据库或者缓存中取出jwt token生成时用的salt
        String salt = redisTemplate.opsForValue().get(JWT_TOKEN_PREFIX+username);
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
     * 获取数据库中保存的用户信息，主要是加密后的密码
     * @param userName
     * @return
     */
//    @Override
//    public AuthorizationUserDTO getUserInfo(String userName) {
//        UserDto user = new UserDto();
//        user.setUserId(1L);
//        user.setUsername("admin");
//        user.setEncryptPwd(new Sha256Hash("123456", encryptSalt).toHex());
//        return user;
//    }

    /**
     * 获取用户角色列表，强烈建议从缓存中获取
     * @param userId
     * @return
     */
    @Override
    public List<String> getUserRoles(Long userId){
        return Arrays.asList("admin");
    }
}
