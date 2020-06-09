package com.yitihua3.exam.dto.answer;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author aiwoqe
 * @Type ExamUserDTO
 * @Desc
 * @date 2020年06月05日
 * @Version V1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamUserDTO {
    /**
     * 考试编号
     */
    @ApiModelProperty(value = "考试编号", name = "examId",  example = "1")
    private Integer examId;
    /**
     * 用户编号
     */
    @ApiModelProperty(value = "用户编号", name = "userId", example = "1")
    private Integer userId;
    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名", name = "username",  example = "小明")
    private String username;
    /**
     * 头像路径
     */
    @ApiModelProperty(value = "头像名字", name = "photo", example = "xx.jpg")
    private String photo;
    /**
     * 学生编号
     */
    @ApiModelProperty(value = "学生编号,修改个人信息时,前面要加student.", name = "studentId", example = "2018011111")
    private Long studentId;
    /**
     * 学生名字
     */
    @ApiModelProperty(value = "学生名字,修改个人信息时,前面要加student.", name = "name", example = "学生1")
    private String name;
}
