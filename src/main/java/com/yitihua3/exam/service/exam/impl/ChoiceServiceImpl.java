package com.yitihua3.exam.service.exam.impl;
import com.yitihua3.exam.entity.exam.Choice;
import com.yitihua3.exam.mapper.exam.ChoiceMapper;
import com.yitihua3.exam.service.exam.ChoiceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Choice)表服务实现类
 *
 * @author makejava
 * @since 2020-05-25 14:39:14
 */
@Service("choiceService")
public class ChoiceServiceImpl implements ChoiceService {
    @Resource
    private ChoiceMapper choiceMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param choiceId 主键
     * @return 实例对象
     */
    @Override
    public Choice queryById(Integer choiceId) {
        Choice choice = choiceMapper.queryById(choiceId);
        return choice;
    }

    /**
     * 显示所有数据
     *
     *
     */
    public void queryAll(){
        choiceMapper.queryAll();
    }
  

    /**
     * 新增数据
     *
     * @param choice 实例对象
     * @return 实例对象
     */
    @Override
    public Choice insert(Choice choice) {
        int result = this.choiceMapper.insert(choice);
        return choice;
    }

    /**
     * 修改数据
     *
     * @param choice 实例对象
     * @return 实例对象
     */
    @Override
    public Choice update(Choice choice) {
        int result = choiceMapper.update(choice);
        Choice choice1 = queryById(choice.getChoiceId());
        return choice1;
    }

    /**
     * 通过主键删除数据
     *
     * @param choiceId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer choiceId) {
        int result = choiceMapper.deleteById(choiceId);
        if(result>0)
            return true;
        else return false;
    }

    @Override
    public void queryAllTest() {
        List<Choice> list = choiceMapper.queryAllTest();
    }

    @Override
    public Choice queryRightById(Integer choiceId) {
        Choice choice = choiceMapper.queryRightById(choiceId);
        return choice;
    }

    @Override
    public Choice queryRight(){
        Choice choice = choiceMapper.queryRight();
        return choice;
    }


    @Override
    public Choice queryScoreById(Integer choiceId) {
        Choice choice = choiceMapper.queryScoreById(choiceId);
        return choice;
    }

    @Override
    public Choice queryScore() {
        Choice choice = choiceMapper.queryScore();
        return choice;
    }


    @Override
    public Choice querySubjectId(Integer choiceId) {
        Choice choice = choiceMapper.querySubjectId(choiceId);
        return choice;
    }

    @Override
    public Choice queryChapterId(Integer choiceId) {
        Choice choice = choiceMapper.queryChapterId(choiceId);
        return choice;
    }
}