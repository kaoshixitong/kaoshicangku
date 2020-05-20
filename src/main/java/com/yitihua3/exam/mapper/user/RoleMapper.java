package com.yitihua3.exam.mapper.user;

import com.yitihua3.exam.entity.user.Role;
import com.yitihua3.exam.mapper.common.CommonMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Role)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-28 12:33:40
 */
@Mapper
public interface RoleMapper extends CommonMapper<Role> {
    /**
     * 根据用户名返回用户
     * @param username
     * @return
     */
//    R selectByUsername(String username);
}