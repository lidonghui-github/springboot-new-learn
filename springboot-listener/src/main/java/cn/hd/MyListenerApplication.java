package cn.hd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"cn.hd.mytest.dao"})
public class MyListenerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyListenerApplication.class);
    }
}
