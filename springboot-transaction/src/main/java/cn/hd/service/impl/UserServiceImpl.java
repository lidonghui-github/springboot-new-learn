package cn.hd.service.impl;


import cn.hd.mapper.UserMapper;
import cn.hd.service.IUserService;
import cn.hd.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userMapper.saveUser(user);
        throw new RuntimeException("系统异常");
    }

    /**
     * 异常并没有被 ”捕获“ 到
     *
     * @param user
     * @throws SQLException
     */
    @Override
    @Transactional
    public void saveUser2(User user) throws SQLException {
        userMapper.saveUser(user);
        throw new SQLException("系统异常");
    }

    /**
     * 异常并指定被 ”捕获“ 到
     *
     * @param user
     * @throws SQLException
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveUser3(User user) throws SQLException {
        userMapper.saveUser(user);
        throw new SQLException("系统异常");
    }


    /**
     * 异常被吃
     *
     * @param user
     * @throws SQLException
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveUser4(User user) throws SQLException {

        try {
            userMapper.saveUser(user);
            throw new SQLException("系统异常");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     *  事务的范围
     * @param user
     * @throws SQLException
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public synchronized void saveUser5(User user) throws SQLException {
        userMapper.saveUser(user);
        throw new SQLException("系统异常");
    }
}
