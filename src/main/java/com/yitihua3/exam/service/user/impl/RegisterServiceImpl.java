package com.yitihua3.exam.service.user.impl;

import com.yitihua3.exam.dto.user.RegisterDTO;
import com.yitihua3.exam.entity.user.User;
import com.yitihua3.exam.exception.ClientException;
import com.yitihua3.exam.response.ResultCode;
import com.yitihua3.exam.service.user.RegisterService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author aiwoqe
 * @Type RegisterServiceImpl
 * @Desc
 * @date 2020年05月29日
 * @Version V1.0
 */
@Service("registerService")
public class RegisterServiceImpl implements RegisterService {
    @Override
    public void check(RegisterDTO registerDTO) {
        if (registerDTO==null)
            throw new ClientException(ResultCode.REGISTER_EXCEPTION,"注册信息为空");
        if(!registerDTO.getConfirm().equals(registerDTO.getPassword()))
            throw new ClientException(ResultCode.REGISTER_EXCEPTION,"确认密码有误");
    }

    @Override
    public User encrypt(User user) {
        String salt = generateSalt();
        user.setSalt(salt);
        String hashAlgorithmName = "MD5";
        Object credentials = user.getPassword();
        int hashIterations = 2;
        String result = new SimpleHash(hashAlgorithmName, credentials, ByteSource.Util.bytes(salt), hashIterations).toString();
        user.setPassword(result);
        return null;
    }

    @Override
    public String generateSalt() {
        Random r = new Random();
        StringBuilder sb = new StringBuilder(16);
        sb.append(r.nextInt(99999999)).append(r.nextInt(99999999));
        int len = sb.length();
        if (len < 16) {
            for (int i = 0; i < 16 - len; i++) {
                sb.append("0");
            }
        }
        String salt = sb.toString();
        return salt;
    }
}
