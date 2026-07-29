package com.lifegame;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lifegame.mapper")
public class LifeGameApplication {

    public static void main(String[] args) {
        SpringApplication.run(LifeGameApplication.class, args);
    }
}
