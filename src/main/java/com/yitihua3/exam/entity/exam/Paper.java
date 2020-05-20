package com.yitihua3.exam.entity.exam;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
/**
 * (Paper)实体类
 *
 * @author makejava
 * @since 2020-04-17 21:20:04
 */
@Getter
@Setter
public class Paper implements Serializable {
    private static final long serialVersionUID = 446787645165245338L;
    /**
    * 试卷编号
    */
    private Integer paperId;
    /**
    * 试卷名字
    */
    private String name;
    /**
    * 试卷总分
    */
    private Integer total;
}