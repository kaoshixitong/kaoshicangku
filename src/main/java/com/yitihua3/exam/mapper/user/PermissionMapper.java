package com.yitihua3.exam.mapper.user;

import com.yitihua3.exam.entity.user.Permission;
import com.yitihua3.exam.mapper.common.CommonMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Permission)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-28 12:33:58
 */
@Mapper
public interface PermissionMapper extends CommonMapper<Permission> {
}