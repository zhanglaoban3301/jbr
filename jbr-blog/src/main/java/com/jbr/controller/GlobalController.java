/**
 * @author : zxw
 * @date : 2022-09-20 14:53
 * @version : 1.0
 **/
package com.jbr.controller;


import com.jbr.domain.entity.Global;
import com.jbr.domain.pojo.RespBean;
import com.jbr.service.GlobalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GlobalController {
    @Autowired
    private GlobalService globalMapper;

    @GetMapping("/getglobal")
    public List<Global> getGlobal(){
        return globalMapper.getGlobal();
    }
}
