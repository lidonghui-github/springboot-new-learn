package cn.hd.listener;

import cn.hd.mytest.dao.TReqLogDao;
import cn.hd.mytest.entity.TReqLog;
import cn.hd.util.UUIDUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;

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
        Method method = (Method) request.getSession().getServletContext().getAttribute("method");
        dealReqLog(request,method);
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        HttpServletRequest request = (HttpServletRequest)
                servletRequestEvent.getServletRequest();
        log.info("session id为：{}", request.getRequestedSessionId());
        log.info("request url为：{}", request.getRequestURL());
        request.setAttribute("name", "李东辉");

    }

    @Autowired
    TReqLogDao tReqLogDao;


    public void dealReqLog(HttpServletRequest request, Method method) {
        TReqLog tReqLog = new TReqLog();
        tReqLog.setId(UUIDUtils.getId());
        tReqLog.setReqIp(request.getLocalAddr());
        tReqLog.setReqUrl(new String(request.getRequestURL()));
        tReqLog.setReqUri(request.getRequestURI());
        tReqLog.setReqSessionId(request.getSession().getId());
        tReqLog.setReqMethodName(method.getName());
        tReqLog.setReqMethodType(request.getMethod().toUpperCase());
        tReqLog.setReqMethodReturnType(method.getReturnType().getTypeName());
        String ano = method.getDeclaredAnnotations()[0].toString();
        System.out.println(ano.substring(0,ano.indexOf("(")));
        tReqLog.setReqMethodAnnotationType(method.getDeclaredAnnotations()[0].toString().substring(0, (method.getDeclaredAnnotations()[0].toString().indexOf("("))));
        tReqLog.setReqCrtTime(new Date());
        Map<String, String[]> map = request.getParameterMap();
        System.out.println(map.size());
        tReqLog.setReqParamCount(map.size());
        tReqLogDao.insert(tReqLog);
    }
}
