package com.yitihua3.exam.service.answer;

import com.yitihua3.exam.dto.answer.EssayScoreDTO;
import com.yitihua3.exam.entity.answer.EssayAnswer;

import java.util.List;

/**
 * (EssayAnswer)表服务接口
 *
 * @author makejava
 * @since 2020-06-01 19:13:09
 */
public interface EssayAnswerService {

    /**
     * 根据考试id和用户id查询作答的简答题和原题
     * @param examId
     * @param userId
     * @return
     */
    List<EssayScoreDTO> selectEssayScore(Integer examId, Integer userId);

    /**
     * 通过ID查询单条数据
     *
     * @param answerId 主键
     * @return 实例对象
     */
    EssayAnswer queryById(Integer answerId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<EssayAnswer> queryAllByLimit(int offset, int limit);



    /**
     * 新增数据
     *
     * @param essayAnswer 实例对象
     * @return 实例对象
     */
    EssayAnswer insert(EssayAnswer essayAnswer);

    /**
     * 修改数据
     *
     * @param essayAnswer 实例对象
     * @return 实例对象
     */
    EssayAnswer update(EssayAnswer essayAnswer);

    /**
     * 批量更新应用题分数
     * @param essayScoreList
     * @return
     */
    int updateEssayScore(List<EssayScoreDTO> essayScoreList);

    /**
     * 通过主键删除数据
     *
     * @param answerId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer answerId);

}