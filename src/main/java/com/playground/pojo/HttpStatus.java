package com.playground.pojo;

import lombok.Data;

/**
 * @author sww
 * @create 2022-03-15 14:28
 **/
@Data
public class HttpStatus {
    private String code_id;
    private String status_code;
    private String cause;
    private String cause_info;
    private String type;
    private String edition;
}
