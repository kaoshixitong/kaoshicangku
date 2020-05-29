package com.yitihua3.exam.mapper.exam;
import com.yitihua3.exam.entity.exam.Judge;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Judge)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-26 17:05:04
 */
public interface JudgeMapper {

    /**
     * 通过Id查询单条数据
     *
     * @param judgeId 主键
     * @return 实例对象
     */
    Judge queryById(Integer judgeId);

    /**
    
    /**
     * 通过Id查询成绩
     *
     * @param judgeId 主键
     * @return 实例对象
     */
    Judge queryScoreById(Integer judgeId);

    /**
    
    /**
     * 查询总成绩
     * 
     */
    Judge queryScore();
    
    /**
     * 通过Id查询答案
     *
     * @param judgeId 主键
     * @return 实例对象
     */
    Judge queryRightById(Integer judgeId);
    
    /**
     * 查询所有答案
     *
     */
    Judge queryRight();
    
    /**
     * 通过Id查询科目
     *
     */
    Judge querySubjectById(Integer judgeId);
    
    /**
     * 通过Id查询章节
     *
     */
    Judge queryChapterById(Integer judgeId);

    /**
     * 通过实体作为筛选条件查询
     *
     */
    List<Judge> queryAll();
    
      /**
     * 查询试题
     *
     */
    List<Judge> queryAllTest();


    /**
     * 新增数据
     *
     * @param judge 实例对象
     * @return 影响行数
     */
    int insert(Judge judge);

    /**
     * 修改数据
     *
     * @param judge 实例对象
     * @return 影响行数
     */
    int update(Judge judge);

    /**
     * 通过主键删除数据
     *
     * @param judgeId 主键
     * @return 影响行数
     */
    int deleteById(Integer judgeId);

}