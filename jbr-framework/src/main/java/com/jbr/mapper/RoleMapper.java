package com.jbr.mapper;

import com.jbr.domain.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zxw
 */
@Mapper
public interface RoleMapper {
     /**
     * 根据用户名查询角色
     * @param username
     * @return
     */
     @Select("select a.id ,a.name from jbr.role a where a.id = (select b.role from jbr.accountno b where b.username = #{usernmae})")
     public List<Role> getRoles(String username);

    /**
     * 根据id查询角色名
     * @param id
     * @return
     */
    @Select("select name from jbr.role where id = #{id}")
     public String getRolesNameById(Integer id);

    /**
     * 根据id查询角色信息
     * @param id
     * @return
     */
    @Select("select name from jbr.role where id = #{id}")
    public Role getRoleInfoById(Integer id);


}
