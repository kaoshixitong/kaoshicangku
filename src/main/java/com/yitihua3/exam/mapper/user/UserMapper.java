package com.yitihua3.exam.mapper.user;

import com.yitihua3.exam.dto.user.AuthorizationUserDTO;
import com.yitihua3.exam.entity.user.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author aiwoqe
 * @Type UserMapper
 * @Desc
 * @date 2020年04月27日
 * @Version V1.0
 */
public interface UserMapper {
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
     * 按照id查询用户
     * @param userId
     * @return
     */
    User selectById(Integer userId);
    /**
     * 按照userId来修改头像
     * @param photo
     * @param userId
     * @return
     */
    int updatePhotoById(@Param("photo") String photo, @Param("userId")Integer userId);

    /**
     * 按照userId来修改用户
     * @param user
     * @return 被修改的用户
     */
    int updateById(User user);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    int insert(User user);


}
