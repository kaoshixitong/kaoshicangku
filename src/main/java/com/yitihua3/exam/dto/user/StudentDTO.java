package com.yitihua3.exam.dto.user;

import com.yitihua3.exam.dto.common.AbstractRelationMapper;
import com.yitihua3.exam.entity.user.Student;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author aiwoqe
 * @Type StudentDTO
 * @Desc
 * @date 2020年05月24日
 * @Version V1.0
 */
@Data
@AllArgsConstructor
public class StudentDTO extends AbstractRelationMapper<StudentDTO, Student> {

    @Override
    protected StudentDTO setSource() {
        return this;
    }

    @Override
    protected boolean isFieldAnnotationPresent() {
        return true;
    }
}
