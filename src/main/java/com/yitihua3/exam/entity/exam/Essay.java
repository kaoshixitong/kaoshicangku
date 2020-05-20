package com.yitihua3.exam.entity.exam;

import com.yitihua3.exam.dto.exam.EssayDTO;
import com.yitihua3.exam.dto.common.AbstractRelationMapper;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
/**
 * (Essay)实体类
 *
 * @author makejava
 * @since 2020-04-19 15:22:47
 */
@Data
@NoArgsConstructor
public class Essay extends AbstractRelationMapper<Essay, EssayDTO> implements Serializable {
    private static final long serialVersionUID = -28314802908035852L;
    /**
    * 主观题编号
    */
    private Integer essayId;
    /**
    * 题目内容
    */
    private String title;
    /**
    * 分数
    */
    private Integer score;
    /**
    * 参考答案
    */
    private String reference;
    /**
    * 科目类型
    */
    private Integer subjectId;
    /**
    * 具体章节
    */
    private Integer chapterId;


    @Override
    protected Essay setSource() {
        return this;
    }

    @Override
    protected boolean isFieldAnnotationPresent() {
        return false;
    }

}