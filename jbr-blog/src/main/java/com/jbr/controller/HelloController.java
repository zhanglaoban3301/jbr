/**
 * @author : zxw
 * @date : 2022-08-26 15:58
 * @version : 1.0
 **/
package com.jbr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return  "hello";
    }
    @GetMapping("/hello/test1")
    public String hello1(){
        return  "hello";
    }
    @GetMapping("/hello/test2")
    public String hello2(){
        return  "hello";
    }

}
