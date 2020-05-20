package com.yitihua3.exam.mapper.user;

import com.yitihua3.exam.dto.user.AuthorizationUserDTO;
import com.yitihua3.exam.entity.user.User;
import com.yitihua3.exam.mapper.common.CommonMapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author aiwoqe
 * @Type UserMapper
 * @Desc
 * @date 2020年04月27日
 * @Version V1.0
 */
public interface UserMapper extends CommonMapper<User> {
    /**
     * 根据用户名返回用户
     * @param username
     * @return
     */
    User selectByUsername(String username);
    /**
     * 根据用户名返回用户(包含权限,角色)
     * @param username
     * @return 根据用户名返回用户(包含权限,角色)
     */
    AuthorizationUserDTO selectCompleteUser(String username);

    /**
     * 按照用户名来修改jwt盐值
     * @param salt
     * @param username
     * @return 被修改的用户
     */
    int updateSaltByUsername(@Param("salt") String salt, @Param("username")String username);
}
