package com.demo.pojo;

import lombok.Data;

/**
 * @author GaoJJ
 * @date 2022/3/10 12:02
 */

@Data
public class User {

    private String userId;
    private String username;
    private String password;
    private String passwordSalt;

}
