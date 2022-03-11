package com.playground.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.playground.mapper.UserMapper;
import com.playground.pojo.User;
import com.playground.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author GaoJJ
 * @date 2022/3/10 17:47
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
