package com.zzq.shiro;

import cn.hutool.core.bean.BeanUtil;
import com.zzq.entity.User;
import com.zzq.service.IUserService;

import com.zzq.util.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AccountRealm extends AuthorizingRealm {

    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    IUserService userService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("调用了授权方法");
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("调用了认证方法");
        JwtToken jwt = (JwtToken) authenticationToken;
        String userId = jwtUtils.getClaimByToken(String.valueOf(jwt.getPrincipal())).getSubject();
        User user = userService.getById(Long.parseLong(userId));
        if (user == null) {
            throw new UnknownAccountException("账户不存在！");
        }
        if (user.getStatus() == -1) {
            throw new LockedAccountException("账户已被锁定！");
        }
        AccountProfile profile = new AccountProfile();
        BeanUtil.copyProperties(user, profile);
        return new SimpleAuthenticationInfo(profile, jwt.getCredentials(), getName());
    }
}
