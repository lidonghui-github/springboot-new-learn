package cn.hd.mytest.dao;

import cn.hd.mytest.entity.TReqLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (TReqLog)表数据库访问层
 *
 * @author makejava
 * @since 2020-09-15 18:56:45
 */
@Repository
public interface TReqLogDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TReqLog queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TReqLog> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tReqLog 实例对象
     * @return 对象列表
     */
    List<TReqLog> queryAll(TReqLog tReqLog);

    /**
     * 新增数据
     *
     * @param tReqLog 实例对象
     * @return 影响行数
     */
    int insert(TReqLog tReqLog);

    /**
     * 修改数据
     *
     * @param tReqLog 实例对象
     * @return 影响行数
     */
    int update(TReqLog tReqLog);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}