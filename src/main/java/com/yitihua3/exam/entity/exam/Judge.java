package com.yitihua3.exam.entity.exam;

import com.yitihua3.exam.dto.exam.JudgeDTO;
import com.yitihua3.exam.dto.common.AbstractRelationMapper;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
/**
 * (Judge)实体类
 *
 * @author makejava
 * @since 2020-04-19 15:22:38
 */
@Data
@NoArgsConstructor
public class Judge extends AbstractRelationMapper<Judge, JudgeDTO> implements Serializable {
    private static final long serialVersionUID = 270882539600710585L;
    /**
    * 判断题编号
    */
    private Integer judgeId;
    /**
    * 题目内容
    */
    private String title;
    /**
    * 选项A
    */
    private String typeA;
    /**
    * 选项B
    */
    private String typeB;
    /**
    * 正确答案
    */
    private String right;
    /**
    * 分数
    */
    private String score;
    /**
    * 科目类型
    */
    private Integer subjectId;
    /**
    * 具体章节
    */
    private Integer chapterId;


    @Override
    protected Judge setSource() {
        return this;
    }

    @Override
    protected boolean isFieldAnnotationPresent() {
        return false;
    }

}