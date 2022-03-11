package com.demo.controller;

import com.demo.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author ：THEFU
 * @date ：Created in 2022/3/4 14:12
 * @description：
 * @version: 1.0
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/show")
    public String show(){
        return "文武小狗！";
    }

    @GetMapping("/showAll")
    public String showAll(){
        return "<h1 style='color:red'>都是小狗！</h1>";
    }

}

