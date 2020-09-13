package cn.hd.listener;

import cn.hd.entity.User;
import cn.hd.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;

/**
 * 使用ApplicationListener
 * 来初始化一些数据到application域
 * 中的监听器
 */
@Component
public class MyServletContextListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        //1.获取 Application 上下文
        ApplicationContext applicationContext = contextRefreshedEvent.getApplicationContext();
        //2.获取对应的 service
        UserServiceImpl userService = applicationContext.getBean(UserServiceImpl.class);
        //3.获取数据
        User user = userService.getUser();
        //4.获取上下文域对象
        ServletContext app = applicationContext.getBean(ServletContext.class);
        //5.将数据放置到域对象中
        app.setAttribute("user", user);
    }
}
