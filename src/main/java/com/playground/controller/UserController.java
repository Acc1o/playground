package com.playground.controller;

import com.ejlchina.searcher.BeanSearcher;
import com.ejlchina.searcher.MapSearcher;
import com.ejlchina.searcher.SearchResult;
import com.ejlchina.searcher.util.MapUtils;
import com.playground.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author ：THEFU
 * @date ：Created in 2022/3/15 11:08
 * @description：
 * @version: 1.0
 */
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 注入 Map 检索器，它检索出来的数据以 Map 对象呈现
     */
    @Autowired
    private MapSearcher mapSearcher;
    /**
     * 注入 Bean 检索器，它检索出来的数据以 泛型 对象呈现
     */
    @Autowired
    private BeanSearcher beanSearcher;

    @GetMapping("/index")
    public SearchResult<Map<String, Object>> index(HttpServletRequest request) {
        // 一行代码，实现一个用户检索接口（MapUtils.flat 只是收集前端的请求参数）
        return mapSearcher.search(User.class, MapUtils.flat(request.getParameterMap()));
    }
}
