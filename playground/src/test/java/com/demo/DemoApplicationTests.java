package com.demo;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest
class DemoApplicationTests {

    @Test
    public void contextLoads() {

        String password = "123456";
        System.err.println("原密码：" + password);

        Md5Hash md5Hash = new Md5Hash(password);
        System.err.println("MD5加密：" + md5Hash.toHex());


        //加盐加密
        String num=(new Random().nextInt(90000)+10000) + "";
        System.err.println("盐：" + num);
        Md5Hash md5Hash1 = new Md5Hash(password,num);
        System.err.println("加盐加密：" + md5Hash1);


    }

}
