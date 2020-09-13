package cn.hd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"cn.hd.mapper"})
public class MyTransactionApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyTransactionApplication.class);
    }
}
