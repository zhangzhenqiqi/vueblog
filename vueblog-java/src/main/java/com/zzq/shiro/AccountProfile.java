package com.zzq.shiro;

import lombok.Data;

import java.io.Serializable;
/**
 * 用户信息载体
 * */
@Data
public class AccountProfile implements Serializable {
    private Long id;
    private String username;
    private String avatar;
}
