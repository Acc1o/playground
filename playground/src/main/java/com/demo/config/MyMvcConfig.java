package com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ：THEFU
 * @date ：Created in 2022/3/10 17:51
 * @description：
 * @version: 1.0
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Bean
    public MyLocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}
