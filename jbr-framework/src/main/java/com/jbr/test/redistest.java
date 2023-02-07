/**
 * @author : zxw
 * @date : 2022-08-29 14:50
 * @version : 1.0
 **/
package com.jbr.test;

import com.jbr.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;


public class redistest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test01() {
        System.out.println(redisTemplate.opsForValue().get("name"));

    }

}
