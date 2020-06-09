package com.yitihua3.exam.mapper.answer;

import com.yitihua3.exam.dto.answer.EssayScoreDTO;
import com.yitihua3.exam.entity.answer.EssayAnswer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (EssayAnswer)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-01 19:13:09
 */
public interface EssayAnswerMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param answerId 主键
     * @return 实例对象
     */
    EssayAnswer queryById(Integer answerId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<EssayAnswer> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param essayAnswer 实例对象
     * @return 对象列表
     */
    List<EssayAnswer> queryAll(EssayAnswer essayAnswer);

    /**
     * 根据考试id和用户id查询作答的简答题和原题
     * @param examId
     * @param userId
     * @return
     */
    List<EssayScoreDTO> selectEssayScore(Integer examId,Integer userId);

    /**
     * 新增数据
     *
     * @param essayAnswer 实例对象
     * @return 影响行数
     */
    int insert(EssayAnswer essayAnswer);


    /**
     * 批量插入应用题答案
     * @param essayAnswerList
     * @return
     */
    int insertList(List<EssayAnswer> essayAnswerList);

    /**
     * 修改数据
     *
     * @param essayAnswer 实例对象
     * @return 影响行数
     */
    int update(EssayAnswer essayAnswer);

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
     * @return 影响行数
     */
    int deleteById(Integer answerId);

}