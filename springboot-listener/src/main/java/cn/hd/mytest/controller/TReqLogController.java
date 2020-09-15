package cn.hd.mytest.controller;

import cn.hd.mytest.entity.TReqLog;
import cn.hd.mytest.service.TReqLogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TReqLog)表控制层
 *
 * @author makejava
 * @since 2020-09-15 18:56:48
 */
@RestController
@RequestMapping("/tReqLog")
public class TReqLogController {
    /**
     * 服务对象
     */
    @Resource
    private TReqLogService tReqLogService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public TReqLog selectOne(String id) {
        return this.tReqLogService.queryById(id);
    }
    @GetMapping("/findAll")
    public List<TReqLog> findAll(){
        return tReqLogService.queryAll();
    }

}