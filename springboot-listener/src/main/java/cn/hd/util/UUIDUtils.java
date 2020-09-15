package cn.hd.util;

import lombok.extern.slf4j.Slf4j;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class UUIDUtils {
    static DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");

    public static synchronized String getId() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            log.error("获取id出错，错误信息:{}", e.getMessage());
        }
        return df.format(new Date());
    }
}
