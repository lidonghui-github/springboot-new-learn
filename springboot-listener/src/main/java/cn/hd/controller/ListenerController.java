package cn.hd.controller;

import cn.hd.entity.User;
import cn.hd.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@RestController
@RequestMapping(value = "/listener")
@Slf4j
public class ListenerController {
    @Resource
    UserServiceImpl userService;

    /**
     * 从缓存中获取用户信息
     *
     * @param request
     * @return
     */
    @GetMapping("/getUser")
    public User getUser(HttpServletRequest request) {
        return (User) request.getServletContext().getAttribute("user");
    }

    /**
     * 统计用户在线人数:有  bug
     */
    @GetMapping("/getUserOnLine")
    public Integer getUserOnLine(HttpServletRequest request) {
        Integer count = (Integer) request.getSession().getAttribute("count");
        log.error("当前在线用户人数:{}", count);
        return count;
    }


    /**
     * 统计用户在线人数:无  bug
     */
    @GetMapping("/getUserOnLine2")
    public Integer getUserOnLine2(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        Cookie cookie = new Cookie("JSESSIONID", URLEncoder.encode(request.getSession().getId(), "UTF-8"));
        cookie.setPath("/");
        cookie.setMaxAge(48 * 60 * 60);
        response.addCookie(cookie);
        Integer count = (Integer) request.getSession().getAttribute("count");
        log.error("当前在线用户人数:{}", count);
        return count;
    }

    /**
     * 获取 requestListener中的初始化的name数据
     *
     * @param request
     * @return
     */
    @GetMapping("/getRequestListenerInfo")
    public String getRequestListenerInfo(HttpServletRequest request) {
        return (String) request.getAttribute("name");
    }

    /**
     * 发布事件
     *
     * @return
     */
    @GetMapping("/publish")
    public User publishEvent() {
        return userService.getUser2();
    }
}
