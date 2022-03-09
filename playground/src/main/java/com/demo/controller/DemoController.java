package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ：THEFU
 * @date ：Created in 2022/3/4 14:12
 * @description：
 * @version: 1.0
 */
@Controller
@RequestMapping("demo")
public class DemoController {

    @ResponseBody
    @GetMapping("show")
    public String show(){
        return "文武小狗！";
    }

    @ResponseBody
    @GetMapping("showAll")
    public String showAll(){
        return "<h1 style='color:red'>都是小狗！</h1>";
    }
}

