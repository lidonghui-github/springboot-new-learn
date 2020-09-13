package cn.hd.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 使用HttpSessionListener统计在线用户数的监听器
 */
@Component
@Slf4j
public class MyHttpSessionListener implements HttpSessionListener {
    public Integer count = 0;

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        log.error("新用户上线了,用户的SessionId是:{}", httpSessionEvent.getSession().getId());
        count = count + 1;
        httpSessionEvent.getSession().setAttribute("count", count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        log.error("有用户上线了,用户的SessionId是:{}", httpSessionEvent.getSession().getId());
        count = count - 1;
        httpSessionEvent.getSession().setAttribute("count", count);
    }
}
