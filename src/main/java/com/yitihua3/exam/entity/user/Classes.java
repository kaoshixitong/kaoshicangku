package com.yitihua3.exam.entity.user;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
/**
 * (Classes)实体类
 *
 * @author makejava
 * @since 2020-04-19 17:16:57
 */
@Getter
@Setter
public class Classes implements Serializable {
    private static final long serialVersionUID = -11222330554396474L;
    /**
    * 班级编号
    */
    private Integer classId;
    /**
    * 班级名字
    */
    private String name;


}