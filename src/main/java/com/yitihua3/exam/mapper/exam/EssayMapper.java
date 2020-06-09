package com.yitihua3.exam.mapper.exam;
import com.yitihua3.exam.entity.exam.Essay;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Essay)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-26 17:03:15
 */
public interface EssayMapper {

    /**
     * 通过Id查询单条数据
     *
     * @param essayId 主键
     * @return 实例对象
     */
    Essay queryById(Integer essayId);

    /**
    
    /**
     * 通过Id查询成绩
     *
     * @param essayId 主键
     * @return 实例对象
     */
    Essay queryScoreById(Integer essayId);

    /**
    
    /**
     * 查询总成绩
     * 
     */
    List<Essay> queryScore(Integer paperId);

    /**
     * 按试卷编号列举简答题
     */

    List<Essay> queryAllTestById(Integer paperId);

    /**
     * 通过Id查询答案
     *
     * @param essayId 主键
     * @return 实例对象
     */
    Essay queryReferenceById(Integer essayId);
    
    /**
     * 查询所有答案
     *
     */
    List<Essay> queryReference(Integer paperId);
    
    /**
     * 通过Id查询科目
     *
     */
    Essay querySubjectById(Integer essayId);
    
    /**
     * 通过Id查询章节
     *
     */
    Essay queryChapterById(Integer essayId);

    /**
     * 通过实体作为筛选条件查询
     *
     */
    List<Essay> queryAll();
    
      /**
     * 查询试题
     *
     */
    List<Essay> queryAllTest();


    /**
     * 新增数据
     *
     * @param essay 实例对象
     * @return 影响行数
     */
    int insert(Essay essay);

    /**
     * 修改数据
     *
     * @param essay 实例对象
     * @return 影响行数
     */
    int update(Essay essay);

    /**
     * 通过主键删除数据
     *
     * @param essayId 主键
     * @return 影响行数
     */
    int deleteById(Integer essayId);

}