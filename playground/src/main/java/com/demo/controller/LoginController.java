package com.demo.controller;

import com.demo.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author GaoJJ
 * @date 2022/3/10 17:28
 */

@RestController
@RequestMapping("/loginController")
public class LoginController {

    @PostMapping("/login")
    public String login(@RequestBody User user){

        System.err.println(user);

        System.err.println("原密码：" + user.getPassword());

        Md5Hash md5Hash = new Md5Hash(user.getPassword());
        System.err.println("MD5加密：" + md5Hash.toHex());


        //加盐加密
        String num=(new Random().nextInt(90000) + 10000) + "";
        System.err.println("盐：" + num);
        Md5Hash md5Hash1 = new Md5Hash(user.getPassword(),num);
        System.err.println("加盐加密：" + md5Hash1);


        return md5Hash1.toString();
    }

}
