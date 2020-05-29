package com.yitihua3.exam.mapper.exam;
import com.yitihua3.exam.entity.exam.Paper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Paper)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-25 11:56:54
 */
public interface PaperMapper {

    /**
     * 通过Id查询单条数据
     *
     * @param paperId 主键
     * @return 实例对象
     */
    Paper queryById(Integer paperId);




    /**
     * 通过实体作为筛选条件查询
     *
     * 
     */
    List<Paper> queryAll();

    /**
     * 新增数据
     *
     * @param paper 实例对象
     * @return 影响行数
     */
    int insert(Paper paper);

    /**
     * 修改数据
     *
     * @param paper 实例对象
     * @return 影响行数
     */
    int update(Paper paper);

    /**
     * 通过主键删除数据
     *
     * @param paperId 主键
     * @return 影响行数
     */
    int deleteById(Integer paperId);

}