package com.jbr.mapper;

import com.jbr.domain.entity.Accountno;
import com.jbr.domain.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 根据name查询账号信息
     * @param username
     * @return
     */
    @Select("select * from jbr.accountno where username = #{username}")
    public Accountno getAccountnoByName(String username);

    /**
     * 根据id查询菜单信息
     * @param username
     * @return
     */
    @Select("select * from jbr.menu A    where A.role = (select role from jbr.accountno where username = #{username}) order by px ")
    public List<Menu> getMenuByName(String username);
    @Select("select * from jbr.menu")
    public List<Menu> getMenuAll();
    @Select("select * from jbr.menu where id = #{id} and role = (select role from jbr.accountno where username = #{username}) order by px " )
    public List<Menu> getMenuById(@Param("id") Integer id, @Param("username")String username);

    @Select("select * from jbr.menu where parentid = #{id} and role = (select role from jbr.accountno where username = #{username}) order by px")
    public List<Menu> getChildrenMenuById(@Param("id")Integer id,@Param("username")String username);
}
