package cn.hd.service;

import cn.hd.entity.User;
import cn.hd.event.MyEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class UserServiceImpl {
    public User getUser() {
        log.error("获取到的用户信息:{}", new User("111", "李东辉", "123456"));
        // 实际中会根据具体的业务场景，从数据库中查询对应的信息
        return new User("111", "李东辉", "123456");
    }

    @Resource
    private ApplicationContext applicationContext;

    /**
     *   * 发布事件
     *   * @return
     *   
     */
    public User getUser2() {
        User user = new User("77777777777777", "孙晓园", "123456");
        // 发布事件
        MyEvent event = new MyEvent(this, user);
        applicationContext.publishEvent(event);
        return user;
    }
}
