package com.demo.shiro;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.demo.mapper.UserMapper;
import com.demo.pojo.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author GaoJJ
 * @date 2022/3/10 17:42
 */

public class CustomRealm  extends AuthorizingRealm {

    @Autowired
    private UserMapper userMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //参数authenticationToken就是传递的subject.login(token)中的参数
        UsernamePasswordToken token= (UsernamePasswordToken) authenticationToken;
        //从token中获取用户名
        String username=token.getUsername();

        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("username",username);

        User user= userMapper.selectOne(qw);
        if(user == null){
            return null;
        }
        AuthenticationInfo info=new SimpleAuthenticationInfo(
                username,//当前用户用户名,跟上面的doGetAuthorizationInfo方法是对应的
                user.getPassword(),//从数据库查询出来的安全密码
                ByteSource.Util.bytes(user.getPasswordSalt()),//用户的密码是加了盐的
                getName());
        return info;
    }
}
