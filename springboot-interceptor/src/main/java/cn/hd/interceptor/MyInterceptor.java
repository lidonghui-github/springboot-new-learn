package cn.hd.interceptor;

import cn.hd.annotation.UnInterception;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;

/**
 * 自定义拦截器
 */
@Slf4j
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        String methodName = method.getName();
        log.info("====拦截到了方法：{}，在该方法执行之前执行====", methodName);
        int parameterCount = method.getParameterCount();
        log.info("该方法具有的参数个数是:{}", parameterCount);
        Type returnType = method.getGenericReturnType();
        log.info("该方法的返回类型是:{}", returnType);
        Parameter[] parameters = method.getParameters();
        if (parameters != null && parameters.length > 0) {
            for (Parameter p : parameters) {
                log.info("该方法的参数分别是:{}", p);
            }
        }
        log.info("此次请求的SESSIONID是:{}",request.getSession().getId());
        log.info("此次请求的URL是:{}",request.getRequestURL());
        log.info("此次请求的IP是:{}",request.getLocalAddr());
        // 通过方法，可以获取该方法上的自定义注解，然后通过注解来判断该方法是否要被拦截
        // @UnInterception 是我们自定义的注解
        UnInterception unInterception = method.getAnnotation(UnInterception.class);
        if (null != unInterception) {
            return true;
        }

        // 判断用户有没有登陆，一般登陆之后的用户都有一个对应的token
        String token = request.getParameter("token");
        if (null == token || "".equals(token)) {
            log.info("用户未登录，没有权限执行……请登录");
            return false;
        }

        // 返回true才会继续执行，返回false则取消当前请求
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        log.info("执行完方法之后进执行(Controller方法调用之后)，但是此时还没进行视图渲染");
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        String methodName = method.getName();
        log.info("====拦截到了方法：{}，在该方法执行之后执行====", methodName);
        int parameterCount = method.getParameterCount();
        log.info("该方法具有的参数个数是:{}", parameterCount);
        Type returnType = method.getGenericReturnType();
        log.info("该方法的返回类型是:{}", returnType);
        Parameter[] parameters = method.getParameters();
        if (parameters != null && parameters.length > 0) {
            for (Parameter p : parameters) {
                log.info("该方法的参数分别是:{}", p);
            }
        }
        log.info("此次请求的SESSIONID是:{}",request.getSession().getId());
        log.info("此次请求的URL是:{}",request.getRequestURL());
        log.info("此次请求的IP是:{}",request.getLocalAddr());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        log.info("整个请求都处理完咯，DispatcherServlet也渲染了对应的视图咯，此时我可以做一些清理的工作了");
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        String methodName = method.getName();
        log.info("====拦截到了方法：{}，在该方法执行之后前执行====", methodName);
        int parameterCount = method.getParameterCount();
        log.info("该方法具有的参数个数是:{}", parameterCount);
        Type returnType = method.getGenericReturnType();
        log.info("该方法的返回类型是:{}", returnType);
        Parameter[] parameters = method.getParameters();
        if (parameters != null && parameters.length > 0) {
            for (Parameter p : parameters) {
                log.info("该方法的参数分别是:{}", p);
            }
        }
        log.info("此次请求的SESSIONID是:{}",request.getSession().getId());
        log.info("此次请求的URL是:{}",request.getRequestURL());
        log.info("此次请求的IP是:{}",request.getLocalAddr());
    }
}
