package com.yitihua3.exam.service.user;

import com.yitihua3.exam.dto.user.RegisterDTO;
import com.yitihua3.exam.entity.user.User;

/**
 * @author aiwoqe
 * @Type RegisterService
 * @Desc
 * @date 2020年05月29日
 * @Version V1.0
 */
public interface RegisterService {
    /**
     * 核对两次密码是否一致
     * @param registerDTO
     */
    void check(RegisterDTO registerDTO);

    /**
     * 对用户密码进行加密
     * @param user
     * @return User对象
     */
    User encrypt(User user);

    /**
     * 生成盐值
     * @return
     */
    String generateSalt();

}
