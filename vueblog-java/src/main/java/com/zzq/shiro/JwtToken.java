package com.zzq.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * shiro默认supports的是UsernamePasswordToken，而我们采用了jwt方式，所以
 * 这里自定义一个JwtToken来完成shiro的supports方法。
 * */
public class JwtToken implements AuthenticationToken {
    private String token;

    public JwtToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
