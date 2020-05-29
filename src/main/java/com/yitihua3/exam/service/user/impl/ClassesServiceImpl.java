package com.yitihua3.exam.service.user.impl;

import com.yitihua3.exam.entity.user.Classes;
import com.yitihua3.exam.mapper.user.ClassesMapper;
import com.yitihua3.exam.service.user.ClassesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Classes)表服务实现类
 *
 * @author makejava
 * @since 2020-04-19 17:16:57
 */
@Service("classesService")
public class ClassesServiceImpl implements ClassesService {
    @Resource
    ClassesMapper classesMapper;

    @Override
    public List<Classes> selectAll() {
        return classesMapper.queryAll(null);
    }

    @Override
    public Classes updateClasses(Classes classes) {
        classesMapper.update(classes);
        return classes;
    }

    @Override
    public void insertClasses(Classes classes) {
        classesMapper.insert(classes);
    }

    @Override
    public Integer deleteClasses(Integer classId) {
        classesMapper.deleteById(classId);
        return classId;
    }
}