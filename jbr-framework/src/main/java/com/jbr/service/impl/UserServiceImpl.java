/**
 * @author : zxw
 * @date : 2022-08-24 15:51
 * @version : 1.0
 **/
package com.jbr.service.impl;

import com.jbr.config.security.JwtTokenUtil;
import com.jbr.domain.entity.Accountno;
import com.jbr.domain.entity.Menu;
import com.jbr.domain.entity.Role;
import com.jbr.domain.pojo.RespBean;
import com.jbr.mapper.RoleMapper;
import com.jbr.mapper.UserMapper;
import com.jbr.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;


import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil JwtTokenUtil;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Override
    public RespBean login(String username, String password, String code,HttpServletRequest request) {

        String captcha = (String)request.getSession().getAttribute("captcha");
        if(code == null || !captcha.equalsIgnoreCase(code)){
            return RespBean.error("验证码输入错误,请重新输入");
        }
        //登录
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if(userDetails == null || !passwordEncoder.matches(password,userDetails.getPassword())){
            return  RespBean.error("用户名或者密码不正确");
        }
        //更新security登录用户对象
        UsernamePasswordAuthenticationToken authenticationToken =
               new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        //生成token
        String token = JwtTokenUtil.generateToken(userDetails);
        Map<String ,String> map = new HashMap<String ,String>();
        map.put("token",token);
        map.put("tokenHead",tokenHead);
        return RespBean.success("登录成功",map);
    }

    @Override
    public Accountno getAccountnoByName(String username) {
        return userMapper.getAccountnoByName(username);
    }

    @Override
    public List<Menu> getMenuByName() {
        String  username = ((Accountno) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        List<Menu> menus = (List<Menu>)valueOperations.get("menu_"+username);
        if(CollectionUtils.isEmpty(menus)){
            menus = new ArrayList<Menu>();
            //查询根节点  home carpetShow
            List<Menu> result1 = userMapper.getChildrenMenuById(1,username);
            //往下查
            for(Menu item1 : result1){
                //carpetInfo profit
                List<Menu> result2 = userMapper.getChildrenMenuById(item1.getId(),username);
                item1.setChildren(result2);
                for(Menu item2 : result2){
                    List<Menu> result3 = userMapper.getChildrenMenuById(item2.getId(),username);
                    item2.setChildren(result3);
                }
                menus.add(item1);
            }

            valueOperations.set("menu_"+username,menus);
        }
        return menus;
    }

    @Override
    public List<Role> getRoleByName(String username) {
        return roleMapper.getRoles(username);
    }

    @Override
    public List<Menu> getMenuAll() {
        return userMapper.getMenuAll();
    }

    @Override
    public String getRolesNameById(Integer id) {
        return roleMapper.getRolesNameById(id);
    }

    @Override
    public Role getRoleInfoById(Integer id) {
        return roleMapper.getRoleInfoById(id);
    }

    @Override
    public List<Menu> getMenuById(Integer id,String username) {
        return userMapper.getMenuById(id,username);
    }

    @Override
    public List<Menu> getMenuChildrenById(Integer id,String username) {
        return userMapper.getChildrenMenuById(id,username);
    }


}
