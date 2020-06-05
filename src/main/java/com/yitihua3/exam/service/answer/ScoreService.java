package com.yitihua3.exam.service.answer;

import com.yitihua3.exam.dto.answer.ExamUserDTO;
import com.yitihua3.exam.entity.answer.Score;
import java.util.List;

/**
 * (Score)表服务接口
 *
 * @author makejava
 * @since 2020-06-03 15:55:51
 */
public interface ScoreService {

    /**
     * 通过ID查询单条数据
     *
     * @param scoreId 主键
     * @return 实例对象
     */
    Score queryById(Integer scoreId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Score> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param score 实例对象
     * @return 实例对象
     */
    Score insert(Score score);

    /**
     * 修改数据
     *
     * @param score 实例对象
     * @return 实例对象
     */
    Score update(Score score);

    /**
     * 更新分数
     * @param score
     * @return
     */
    int updateMark(Score score);

    /**
     * 通过主键删除数据
     *
     * @param scoreId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer scoreId);

    /**
     * 查询某场考试所有的作答者
     * @param examId
     * @return
     */
    List<ExamUserDTO> selectExamUser(Integer examId);

    /**
     * 查询某场考试所有的作答者分页
     * @param examId
     * @param page
     * @param size
     * @return
     */
    List<ExamUserDTO> selectExamUserPage(Integer examId,Integer page,Integer size);
}