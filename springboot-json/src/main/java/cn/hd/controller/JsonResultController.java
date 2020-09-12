package cn.hd.controller;

import cn.hd.entity.User;
import cn.hd.returnvo.JsonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/jsonResult")
public class JsonResultController {
    /**
     * 获取单个对象的 json 数据
     */
    @GetMapping("/getUser")
    public JsonResult<User> getUser() {
        User user = new User(1, "ldh", "123456");
        return new JsonResult<>(user);
    }

    /**
     * 获取 list 集合数据
     */
    @GetMapping("/getUserList")
    public JsonResult<List> getUserList() {
        List<User> list = new ArrayList<>();
        list.add(new User(1, "ldh1", "1234561"));
        list.add(new User(2, "ldh2", "1234562"));
        list.add(new User(3, "ldh3", "1234563"));
        list.add(new User(4, "ldh4", "1234564"));
        list.add(new User(5, "ldh5", "1234565"));
        list.add(new User(6, "ldh6", "1234566"));
        return new JsonResult<>(list,"获取用户列表成功");
    }

    /**
     * 获取 set 集合数据
     */
    @GetMapping("/getUserSet")
    public JsonResult<Set> getUserSet() {
        Set<User> set = new HashSet<>();
        set.add(new User(1, "ldh1", "1234561"));
        set.add(new User(2, "ldh2", "1234562"));
        set.add(new User(3, "ldh3", "1234563"));
        set.add(new User(4, "ldh4", "1234564"));
        set.add(new User(5, "ldh5", "1234565"));
        set.add(new User(6, "ldh6", "1234566"));
        return new JsonResult<>(set,"200","获取用户列表SET成功");
    }

    /**
     * 获取 map 集合数据
     */
    @GetMapping("/getUserMap")
    public JsonResult<Map> getUserMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("作者", new User(1, "ldh1", "1234561"));
        map.put("学校", "中科院大学");
        map.put("小妾",null);
        return new JsonResult<>(map);
    }


}
