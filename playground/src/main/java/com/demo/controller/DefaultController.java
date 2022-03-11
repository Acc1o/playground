package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ：THEFU
 * @date ：Created in 2022/3/10 11:48
 * @description：
 * @version: 1.0
 */
@Controller
public class DefaultController {
    @RequestMapping("/")
    public String index(){
        return "/html/index.html";
    }
}
