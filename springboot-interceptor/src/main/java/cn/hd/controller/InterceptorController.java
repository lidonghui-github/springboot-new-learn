package cn.hd.controller;

import cn.hd.annotation.UnInterception;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/interceptor")
@Slf4j
public class InterceptorController {
    @RequestMapping("/test")
    public String test(@RequestParam(required = false) String name) {
        log.info("传入的参数:{}",name);
        return "hello";
    }

    @UnInterception
    @RequestMapping("/test2")
    public String test2() {
        return "123";
    }

}
