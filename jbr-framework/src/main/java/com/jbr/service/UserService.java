/**
 * @author : zxw
 * @date : 2022-08-24 15:45
 * @version : 1.0
 **/
package com.jbr.service;


import com.jbr.domain.entity.Accountno;
import com.jbr.domain.entity.Menu;
import com.jbr.domain.entity.Role;
import com.jbr.domain.pojo.RespBean;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {
    /**
     * login
     * @param username
     * @param password
     * @param code
     * @param request
     * @return
     */
    public RespBean login(String username, String password, String code,HttpServletRequest request);

    /**
     * 根据用户名查询账号信息
     * @param username
     * @return
     */
    public Accountno getAccountnoByName(String username);

    /**
     * 根据用户名查询菜单
     * @return
     */
    public List<Menu> getMenuByName();
    /**
     * 根据用户名查询角色
     * @return
     */
    public List<Role> getRoleByName(String username);

    /**
     * 查询全部菜单
     * @return
     */
    public List<Menu> getMenuAll();

    /**
     * 根据id查询角色名称
     * @param id
     * @return
     */
    public String getRolesNameById(Integer id);

    /**
     * 根据id查询角色
     * @param id
     * @return
     */
    public Role getRoleInfoById(Integer id);

    /**
     * 根据id查询菜单
     * @param id
     * @return
     */
    public List<Menu> getMenuById(Integer id,String username);

    /**
     * 根据id查询子菜单
     * @param id
     * @return
     */
    public List<Menu> getMenuChildrenById(Integer id,String username);
}
