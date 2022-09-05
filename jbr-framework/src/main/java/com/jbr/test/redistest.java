/**
 * @author : zxw
 * @date : 2022-08-29 14:50
 * @version : 1.0
 **/
package com.jbr.test;

import com.jbr.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class redistest {
    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void test01() {
        for (int i = 0;i<4;i++) {
            try {
                for (int j = 0; j < 10; j++) {
                    System.out.println("hhhh");
                }
                int k = 1 / 0;
            } catch (Exception e) {
                System.out.println("出错了");
            }
        }
    }

}
