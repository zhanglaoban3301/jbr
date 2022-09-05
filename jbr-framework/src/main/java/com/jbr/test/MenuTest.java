package com.jbr.test;

import com.jbr.domain.entity.Menu;
import com.jbr.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author zxw
 * @Date 2022/9/4 14:56
 * @Description:
 * @Version 1.0
 */

public class MenuTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test1(){
        List<Menu> result = new ArrayList();
        List<Menu> menus = userMapper.getMenuByName("admin");
        result = getMenuDg(menus,result);


    }

    public List<Menu> getMenuDg(List<Menu> menus,List<Menu> result){
        for(Menu menu : menus){
            List<Menu> result1 = menus.stream().filter(v->v.getParentid().equals(menu.getId())).collect(Collectors.toList());
            if(result1==null || result1.size()==0){
                //没有下级
                result.add(menu);
            }else{
                //继续找下级
                menu.setChildren(result1);
                getMenuDg(result1,result);
            }
        }
        return result;
    }
}
