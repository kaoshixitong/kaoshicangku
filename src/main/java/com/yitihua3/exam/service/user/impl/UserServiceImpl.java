package com.yitihua3.exam.service.user.impl;

import com.yitihua3.exam.dto.user.RegisterDTO;
import com.yitihua3.exam.entity.user.User;
import com.yitihua3.exam.mapper.user.UserMapper;
import com.yitihua3.exam.service.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (User)表服务实现类
 *
 * @author aiwoqe
 * @since 2020-04-17 22:01:20
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;


    @Override
    public User selectByUsername(String username) {
        return userMapper.selectByUsername(username);
    }

    @Override
    public void register(RegisterDTO registerDTO) {

    }

    @Override
    public void updatePhoto(String photoName,User user) {
        userMapper.updatePhotoById(photoName,user.getUserId());
    }

    @Override
    public User updateUser(User user) {
        userMapper.updateById(user);
        return user;
    }

    @Override
    public void insertUser(User user) {
        userMapper.insert(user);
    }
}