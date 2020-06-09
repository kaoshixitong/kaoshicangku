package com.yitihua3.exam.service.user.impl;

import com.yitihua3.exam.dto.user.RegisterDTO;
import com.yitihua3.exam.entity.user.User;
import com.yitihua3.exam.mapper.user.UserMapper;
import com.yitihua3.exam.service.user.MailService;
import com.yitihua3.exam.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private MailService mailService;


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
        //获取激活码
        String code = user.getActiveCode();
        System.out.println("激活码:"+code);
        //主题
        String subject = "EGG的测试demo，qq邮箱你做个人吧";
        //上面的激活码发送到用户注册邮箱
        String context = "<a href=\"http://localhost:8080/user/checkCode?code="+code+"\">激活请点击:"+code+"</a>";
        //发送激活邮件
        mailService.sendMimeMail (user.getEmail(),subject,context);
    }