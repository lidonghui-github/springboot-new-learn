package cn.hd.controller;


import cn.hd.service.IUserService;
import cn.hd.entity.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    IUserService userService;

    @GetMapping("/findAll")
    public List<User> findAllUsers() {
        List<User> list = userService.findAll();
        logger.info("查询所有用户信息:{}", list);
        return list;
    }

    @RequestMapping("/save")
    public User saveUser(User user){
        if (StringUtils.isEmpty(user.getId())) {
            user.setId(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
        }
        userService.saveUser(user);
        return user;

    }
    @RequestMapping("/save2")
    public User saveUser2(User user) throws SQLException {
        if (StringUtils.isEmpty(user.getId())) {
            user.setId(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
        }
        userService.saveUser2(user);
        return user;

    }
    @RequestMapping("/save3")
    public User saveUser3(User user) throws SQLException {
        if (StringUtils.isEmpty(user.getId())) {
            user.setId(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
        }
        userService.saveUser3(user);
        return user;

    }

    @RequestMapping("/save4")
    public User saveUser4(User user) throws SQLException {
        if (StringUtils.isEmpty(user.getId())) {
            user.setId(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
        }
        userService.saveUser4(user);
        return user;

    }

    @RequestMapping("/save5")
    public User saveUser5(User user) throws SQLException {
        if (StringUtils.isEmpty(user.getId())) {
            user.setId(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
        }
        userService.saveUser5(user);
        return user;

    }


}
