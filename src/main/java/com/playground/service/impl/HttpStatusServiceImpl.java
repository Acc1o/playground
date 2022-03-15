package com.playground.service.impl;

import com.playground.mapper.HttpStatusMapper;
import com.playground.pojo.HttpStatus;
import com.playground.service.HttpStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sww
 * @create 2022-03-15 14:44
 **/
@Service
public class HttpStatusServiceImpl implements HttpStatusService {

    @Autowired
    HttpStatusMapper httpStatusMapper;

    @Override
    public List<HttpStatus> listHttpStatus() {
        return httpStatusMapper.listHttpStatus();
    }
}
