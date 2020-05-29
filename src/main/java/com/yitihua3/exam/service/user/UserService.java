package com.yitihua3.exam.service.user;

import com.yitihua3.exam.dto.user.RegisterDTO;
import com.yitihua3.exam.entity.user.User;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2020-04-17 22:01:20
 */
public interface UserService {
    /**
     * 通过用户名来查询用户
     * @param username
     * @return
     */
    User selectByUsername(String username);

    /**
     * 注册
     * @param registerDTO
     */
    void register(RegisterDTO registerDTO);

    /**
     * 更新头像
     * @param user
     * @param photoName
     */
    void updatePhoto(String photoName,User user);

    /**
     * 按照id修改用户
     * @param user
     * @return
     */
    User updateUser(User user);

    /**
     * 增加用户
     * @param user
     */
    void insertUser(User user);
}