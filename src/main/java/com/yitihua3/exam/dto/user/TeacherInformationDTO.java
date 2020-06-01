package com.yitihua3.exam.dto.user;

import com.yitihua3.exam.entity.user.Teacher;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author aiwoqe
 * @Type TeacherInformationDTO
 * @Desc
 * @date 2020年05月24日
 * @Version V1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherInformationDTO {
    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名", name = "username", required = true, example = "小明")
    private String username;
    /**
     * 头像路径
     */
    @ApiModelProperty(value = "头像名字,向后台发送时不用，从后台接收时要", name = "photo", example = "xx.jpg")
    private String photo;
    /**
     * 教师信息
     */
    @ApiModelProperty(value = "教师信息", name = "teacher")
    private Teacher teacher;
}
