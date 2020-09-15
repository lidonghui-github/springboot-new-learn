package cn.hd.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

/**
 * 使用ServletRequestListener获取访问信息
 */
@Component
@Slf4j
public class MyServletRequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        log.info("request end");
        HttpServletRequest request = (HttpServletRequest)servletRequestEvent.getServletRequest();

        log.info("request域中保存的name值为：{}", request.getAttribute("name"));
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        HttpServletRequest request = (HttpServletRequest)
                servletRequestEvent.getServletRequest();
        log.info("session id为：{}", request.getRequestedSessionId());
        log.info("request url为：{}", request.getRequestURL());
        request.setAttribute("name", "李东辉");
    }


}
