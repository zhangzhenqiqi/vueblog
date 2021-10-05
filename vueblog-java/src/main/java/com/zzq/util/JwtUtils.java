package com.zzq.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
@Data
@Component
@ConfigurationProperties(prefix = "zzq.jwt")
public class JwtUtils {
    private String secret;
    private long expire;
    private String header;

    /**
     * 生成json-web-token
     * */
    public String generateToken(long userId) {
        Date nowDate = new Date();
        Date expireDate = new Date(nowDate.getTime() + expire * 1000);
        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setSubject(userId + "")
                .setIssuedAt(nowDate)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * 解密jwt
     * */
    public Claims getClaimByToken(String token) {
        try {
            return Jwts.parser().setSigningKey(secret)
                    .parseClaimsJws(token).getBody();
        } catch (Exception e) {
            log.debug("validate is token error", e);
            return null;
        }
    }

    public boolean isTokenExpired(Date expiration) {
        return expiration.before(new Date());
    }
}
