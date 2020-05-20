package com.yitihua3.exam.entity.exam;

import com.yitihua3.exam.dto.exam.ChoiceDTO;
import com.yitihua3.exam.dto.common.AbstractRelationMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
/**
 * (Choice)实体类
 *
 * @author makejava
 * @since 2020-04-19 15:22:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Choice extends AbstractRelationMapper<Choice,ChoiceDTO> implements Serializable {
    private static final long serialVersionUID = -47025859645571687L;
    /**
    * 选择题编号
    */
    private Integer choiceId;
    /**
    * 题目
    */
    private String title;
    /**
    * A选项
    */
    private String typeA;
    /**
    * B选项
    */
    private String typeB;
    /**
    * C选项
    */
    private String typeC;
    /**
    * D选项
    */
    private String typeD;
    /**
    * 正确答案
    */
    private String right;
    /**
    * 分数
    */
    private Integer score;
    /**
    * 科目类型
    */
    private Integer subjectId;
    /**
    * 具体章节
    */
    private Integer chapterId;
    /**
    * 是否单选(1单选0多选)
    */
    private Integer single;

    @Override
    protected Choice setSource() {
        return this;
    }

    @Override
    protected boolean isFieldAnnotationPresent() {
        return false;
    }

}