package com.yitihua3.exam.dto.user;

import com.yitihua3.exam.entity.user.Student;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author aiwoqe
 * @Type InformationDTO
 * @Desc
 * @date 2020年05月24日
 * @Version V1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentInformationDTO {
    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名", name = "username", required = true, example = "小明")
    private String username;
    /**
     * 头像名字
     */
    @ApiModelProperty(value = "头像名字,向后台发送时不用，从后台接收时要", name = "photo", example = "xx.jpg")
    private String photo;
    /**
     * 学生信息
     */
    @ApiModelProperty(value = "学生信息", name = "student")
    private Student student;
}
