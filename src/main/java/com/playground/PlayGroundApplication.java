package com.playground;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan("mapper")
@SpringBootApplication
@EnableCaching
public class PlayGroundApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlayGroundApplication.class, args);
    }

}
