package cn.hd.listener;

import cn.hd.entity.User;
import cn.hd.event.MyEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 自定义监听器，监听MyEvent事件
 */
@Slf4j
@Component
public class MyEventListener implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent myEvent) {
        // 把事件中的信息获取到
        User user = myEvent.getUser();
        // 处理事件，实际项目中可以通知别的微服务或者处理其他逻辑等等
        log.info("用户名：{}" , user.getUserName());
        log.info("密码：{}" , user.getPassword());
    }
}
