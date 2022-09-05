/**
 * @author : zxw
 * @date : 2022-08-24 15:41
 * @version : 1.0
 **/
package com.jbr.controller;

import com.jbr.domain.entity.Accountno;
import com.jbr.domain.pojo.RespBean;
import com.jbr.domain.pojo.UserLogin;
import com.jbr.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@RestController
@Api(tags = "UserLoginController")
public class UserLoginController {
    @Autowired
    private UserService userService;

    /**
     * 用户登录
     * @param userLogin
     * @param request
     * @return
     */
    @ApiOperation(value = "登录之后返回token")
    @PostMapping("/login")
    public RespBean login(@RequestBody UserLogin userLogin, HttpServletRequest request){
        return userService.login(userLogin.getUsername(),userLogin.getPassword(),userLogin.getCode(),request);
    }

    /**
     * 退出登录
     * @return
     */
    @ApiOperation(value = "退出登录")
    @PostMapping("/logout")
    public RespBean logout(){
        return RespBean.success("注销成功");
    }

    /**
     * 查看账户信息
     * @param principal
     * @return
     */
    @ApiOperation(value="查看账户信息")
    @GetMapping("/login/getInfo")
    public Accountno getAccountnoByName(Principal principal){
        if(principal == null){
            return null;
        }
        String username = principal.getName();

        Accountno accountno = userService.getAccountnoByName(username);
        accountno.setPassword(null);
        accountno.setRoles(userService.getRoleByName(username));
        return accountno;
    }


}
