package cn.hd.service;


import cn.hd.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserService {
    public List<User> findAll();

    public void saveUser(User user);
    public void saveUser2(User user) throws SQLException;
    public void saveUser3(User user) throws SQLException;
    public void saveUser4(User user) throws SQLException;
    public void saveUser5(User user) throws SQLException;
}
