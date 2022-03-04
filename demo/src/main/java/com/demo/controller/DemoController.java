package com.demo.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("demo")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class DemoController {

    @ResponseBody
    @GetMapping("demo")
    public String show(){
        return "文物小狗！";
    }
}
