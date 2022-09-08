/**
 * @author : zxw
 * @date : 2022-08-24 14:32
 * @version : 1.0
 **/
package com.jbr.config.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class JwtTokenUtil {

    private static final String CLAIM_KEY_USERNAME="sub";
    private static final String CLAIM_KEY_CREATED="created";
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private Long expiration;

    /**
     *根据用户信息生成token
     *@parama userdetails  generateToken
     *
     */
    public String generateToken(UserDetails userdetails){
        Map<String,Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME,userdetails.getUsername());
        claims.put(CLAIM_KEY_CREATED,new Date());
        return gereratedToken(claims);
    }

    /**
     * 从token中获取登录用户名
     * @param token
     * @return
     */
    public String getUserNameFromToken(String token){
        String username;
        try{
            Claims claims = getClaimsFormToken(token);
            username = claims.getSubject();
        }catch(Exception e){
            username = null;
        }

        return username;
    }

    /**
     * 从token获取荷载
     * @param token
     * @return
     */
    private Claims getClaimsFormToken(String token) {
        Claims claims = null;
        try{
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        }catch(Exception e){
            e.printStackTrace();
        }

        return claims;
    }


    public String gereratedToken(Map<String,Object> claims){
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact();
    }

    private Date generateExpirationDate(){
        return new Date(System.currentTimeMillis() + expiration );
    }

    /**
     * token是否有效
     * @param token
     * @param userdetails
     * @return
     */
   public boolean validateToken(String token,UserDetails userdetails){
        String username = getUserNameFromToken(token);
        return username.equals(userdetails.getUsername())&&!isTokenExpired(token);
   }

    /**
     * token是否可以被刷新
     * @param token
     * @return
     */
   public boolean canRefresh(String token){
       return !isTokenExpired(token);
   }

    /**
     * 刷新token
     * @param token
     * @return
     */
    public String refreshToken(String token){
       Claims claims = getClaimsFormToken(token);
       claims.put(CLAIM_KEY_CREATED,new Date());
       return gereratedToken(claims);
    }


    /**
     * 判断token是否失效
     * @param token
     * @return
     */
   public boolean isTokenExpired(String token){
       Date expired = getExpiredDateFromToken(token);
       return expired.before(new Date());
   }

    /**
     * 从token中获取失效时间
     * @param token
     * @return
     */
   public Date getExpiredDateFromToken(String token){
       Claims claims = getClaimsFormToken(token);
       return claims.getExpiration();
   }
}
