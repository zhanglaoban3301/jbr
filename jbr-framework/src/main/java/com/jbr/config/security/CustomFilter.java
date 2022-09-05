/**
 * @author : zxw
 * @date : 2022-09-01 10:06
 * @version : 1.0
 **/
package com.jbr.config.security;

import com.jbr.domain.entity.Accountno;
import com.jbr.domain.entity.Menu;
import com.jbr.domain.entity.Role;
import com.jbr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
@Component
public class CustomFilter implements FilterInvocationSecurityMetadataSource {
    @Autowired
    private UserService userService;

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Autowired
    private UserDetailsService userDetailsService;
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) o).getRequestUrl();

        List<Menu> menus = userService.getMenuAll();
        if(menus == null){
            return SecurityConfig.createList("没配置菜单");
        }
        for (Menu menu : menus) {

            if(antPathMatcher.match(menu.getUrl(),requestUrl)){
                menu.setRoles(Arrays.asList(userService.getRoleInfoById(menu.getParentid())));
                String[] str = menu.getRoles().stream().map(Role::getName).toArray(String[]::new);

                return SecurityConfig.createList(str);
            }
        }
        //没匹配到的url
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
