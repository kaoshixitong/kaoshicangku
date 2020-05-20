package com.yitihua3.exam.mapper.common;

import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

/**
 * @author aiwoqe
 * @Type CommonMapper
 * @Desc
 * @date 2020年04月27日
 * @Version V1.0
 */
@Mapper
public interface CommonMapper<T>
        extends BaseMapper<T>, ConditionMapper<T>, IdsMapper<T>, InsertListMapper<T>{}
