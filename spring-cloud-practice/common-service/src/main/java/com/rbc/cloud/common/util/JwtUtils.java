package com.rbc.cloud.common.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

/**
 * JWT 工具类
 *
 * @author moqi
 */
@Slf4j
public class JwtUtils {

    /**
     * 生成token
     *
     * @param secretKey  秘钥
     * @param header     头
     * @param claims     载荷
     * @param expireDate 过期时间
     * @return token
     */
    public static String createToken(String secretKey,
                                     Map<String, Object> header,
                                     Map<String, Object> claims,
                                     Date expireDate) {
        if (Objects.isNull(claims)) {
            log.info("载荷内容 [claims] 不能为空");
            return null;
        }

        try {
            Key key = new SecretKeySpec(secretKey.getBytes(), SignatureAlgorithm.HS512.getJcaName());
            JwtBuilder builder = Jwts.builder().addClaims(claims);
            if (Objects.nonNull(header)) {
                builder.setHeader(header);
            }
            if (Objects.nonNull(expireDate)) {
                builder.setExpiration(expireDate);
            }
            return builder.signWith(key).compact();
        } catch (Exception ex) {
            log.error("生成 JWT Token 错误", ex);
            System.out.println(ex);
        }
        return null;
    }

    /**
     * 解析token
     *
     * @param secretKey 秘钥
     * @param token     token
     * @return 载荷
     */
    public static Claims decodeToken(String secretKey,
                                     String token) {
        try {
            Key key = new SecretKeySpec(secretKey.getBytes(), SignatureAlgorithm.HS512.getJcaName());
            return Jwts.parserBuilder().setSigningKey(key)
                    .build().parseClaimsJws(token).getBody();
        } catch (Exception ex) {
            log.error("解析 JWT Token 错误", ex);
        }
        return null;
    }


}