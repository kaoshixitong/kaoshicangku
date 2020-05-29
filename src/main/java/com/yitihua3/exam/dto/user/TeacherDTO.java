package com.yitihua3.exam.dto.user;

import com.yitihua3.exam.dto.common.AbstractRelationMapper;
import com.yitihua3.exam.entity.user.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author aiwoqe
 * @Type TeacherDTO
 * @Desc
 * @date 2020年05月24日
 * @Version V1.0
 */
@Data
@AllArgsConstructor
public class TeacherDTO extends AbstractRelationMapper<TeacherDTO, Teacher> {

    @Override
    protected TeacherDTO setSource() {
        return this;
    }

    @Override
    protected boolean isFieldAnnotationPresent() {
        return true;
    }
}
