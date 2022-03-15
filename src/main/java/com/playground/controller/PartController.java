package com.playground.controller;

import com.ejlchina.searcher.BeanSearcher;
import com.ejlchina.searcher.MapSearcher;
import com.ejlchina.searcher.SearchResult;
import com.ejlchina.searcher.util.MapUtils;
import com.playground.pojo.HttpStatus;
import com.playground.pojo.User;
import com.playground.service.HttpStatusService;
import com.sun.org.glassfish.gmbal.ParameterNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author sww
 * @create 2022-03-15 14:26
 **/
@RestController
public class PartController {

    @Autowired
    private MapSearcher mapSearcher;

    @Autowired
    private BeanSearcher beanSearcher;


    @PostMapping("/tool1")
    public SearchResult<Map<String, Object>> http_code(HttpServletRequest request,@RequestParam Map<String,Object> map){
        SearchResult<Map<String, Object>> search = mapSearcher.search(HttpStatus.class, map);
        return search;
    }
}
