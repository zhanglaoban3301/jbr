/**
 * @author : zxw
 * @date : 2022-08-29 11:33
 * @version : 1.0
 **/
package com.jbr.controller;

import com.jbr.domain.entity.Menu;
import com.jbr.domain.pojo.UserLogin;
import com.jbr.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/system/cfg")
public class MenuController {
    @Autowired
    private UserService userService;
    @ApiOperation(value = "通过账号查询菜单列表")
    @GetMapping("/meun")
    public List<Menu> getMenuByName(){
        return userService.getMenuByName();
    }
}
