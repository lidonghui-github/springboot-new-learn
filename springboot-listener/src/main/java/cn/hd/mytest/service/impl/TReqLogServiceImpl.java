package cn.hd.mytest.service.impl;

import cn.hd.mytest.dao.TReqLogDao;
import cn.hd.mytest.entity.TReqLog;
import cn.hd.mytest.service.TReqLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TReqLog)表服务实现类
 *
 * @author makejava
 * @since 2020-09-15 18:56:47
 */
@Service("tReqLogService")
public class TReqLogServiceImpl implements TReqLogService {
    @Resource
    private TReqLogDao tReqLogDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TReqLog queryById(String id) {
        return this.tReqLogDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TReqLog> queryAllByLimit(int offset, int limit) {
        return this.tReqLogDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tReqLog 实例对象
     * @return 实例对象
     */
    @Override
    public TReqLog insert(TReqLog tReqLog) {
        this.tReqLogDao.insert(tReqLog);
        return tReqLog;
    }

    /**
     * 修改数据
     *
     * @param tReqLog 实例对象
     * @return 实例对象
     */
    @Override
    public TReqLog update(TReqLog tReqLog) {
        this.tReqLogDao.update(tReqLog);
        return this.queryById(tReqLog.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.tReqLogDao.deleteById(id) > 0;
    }

    @Override
    public List<TReqLog> queryAll() {
        return tReqLogDao.queryAll(new TReqLog());
    }
}