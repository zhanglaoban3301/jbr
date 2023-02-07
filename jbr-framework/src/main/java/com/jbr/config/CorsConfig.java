/**
 * @author : zxw
 * @date : 2022-09-30 13:11
 * @version : 1.0
 **/
package com.jbr.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {


    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {
        corsRegistry.addMapping("/**")
                //允许跨域的主机地址,*表示所有都可以
                .allowedOriginPatterns("*")
                //允许跨域的请求头
                .allowedHeaders("*")
                //允许跨域的请求方法
                .allowedMethods("GET","POST","PUT","DELETE","HEAD","OPTIONS")
                //是否允许携带cookie,true表示允许
                .allowCredentials(true)
                //单位为秒, 重新预检验跨域的缓存时间,表示该时间内，不用重新检验跨域
                .maxAge(3600);
    }
}
