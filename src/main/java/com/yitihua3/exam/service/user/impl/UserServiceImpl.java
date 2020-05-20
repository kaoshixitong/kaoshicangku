package com.yitihua3.exam.service.user.impl;

import com.yitihua3.exam.entity.user.User;
import com.yitihua3.exam.mapper.user.UserMapper;
import com.yitihua3.exam.service.common.AbstractService;
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
public class UserServiceImpl extends AbstractService<User> implements UserService {
    @Resource
    private UserMapper userMapper;



}