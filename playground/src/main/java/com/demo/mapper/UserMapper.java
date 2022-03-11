package com.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author GaoJJ
 * @date 2022/3/10 17:44
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
