package com.playground.mapper;

import com.playground.pojo.HttpStatus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author sww
 * @create 2022-03-15 14:35
 **/
@Mapper
@Repository
public interface HttpStatusMapper {
    List<HttpStatus> listHttpStatus();
}
