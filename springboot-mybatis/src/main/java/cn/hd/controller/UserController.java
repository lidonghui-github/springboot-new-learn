package cn.hd.controller;

import cn.hd.entity.User;
import cn.hd.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
        logger.info("查询所有用户信息:{}",list);
        return list;
    }
}
