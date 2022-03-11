package com.playground.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String index(Model model){
        model.addAttribute("name","刘强东");
        return "/html/index.html";
    }
}
