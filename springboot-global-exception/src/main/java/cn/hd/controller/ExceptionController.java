package cn.hd.controller;

import cn.hd.entity.JsonResult;
import cn.hd.enums.BusinessMsgEnum;
import cn.hd.exception.BusinessErrorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exception")
public class ExceptionController {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);

    @PostMapping("/test")
    public JsonResult test(@RequestParam("name") String name, @RequestParam("pass") String pass) {
        logger.info("name：{}", name);
        logger.info("pass：{}", pass);
        return new JsonResult();
    }


    @RequestMapping("/testNullPointException")
    public JsonResult testNullPointException() {
        String s = null;
        logger.error("s :{}", s.length());
        return new JsonResult();
    }

    @GetMapping("/testByZero")
    public JsonResult testByZero() {
        int i = 1 / 0;
        return new JsonResult();
    }


    @GetMapping("/business")
    public JsonResult testException() {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            throw new BusinessErrorException(BusinessMsgEnum.UNEXPECTED_EXCEPTION);
        }
        return new JsonResult();
    }
}
