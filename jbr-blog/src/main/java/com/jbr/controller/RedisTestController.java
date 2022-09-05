/**
 * @author : zxw
 * @date : 2022-08-29 14:54
 * @version : 1.0
 **/
package com.jbr.controller;

import com.jbr.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisTestController {
    @Autowired
    private RedisUtil redisUtil;
    @GetMapping("/GetRedis")
    public Object GetRedis(){
       return redisUtil.get("menu_admin");
    }
    @GetMapping("/redis1")
    public void DeleteRedis(){
         redisUtil.del("menu_admin");
    }

}
