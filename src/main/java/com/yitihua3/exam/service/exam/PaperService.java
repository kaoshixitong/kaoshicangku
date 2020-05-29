package com.yitihua3.exam.service.exam;
import com.yitihua3.exam.entity.exam.Paper;
import java.util.List;

/**
 * (Paper)表服务接口
 *
 * @author makejava
 * @since 2020-05-26 17:14:48
 */
public interface PaperService {

    /**
     * 通过Id查询单条数据
     *
     * @param paperId 主键
     * @return 实例对象
     */
    Paper queryById(Integer paperId);

   

    /**
     * 新增数据
     *
     * @param paper 实例对象
     * @return 实例对象
     */
    Paper insert(Paper paper);

    /**
     * 修改数据
     *
     * @param paper 实例对象
     * @return 实例对象
     */
    Paper update(Paper paper);

    /**
     * 通过主键删除数据
     *
     * @param paperId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer paperId);

    /**
     * 查询所有试卷
     */
    List<Paper> queryAll();

}