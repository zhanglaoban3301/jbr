package com.jbr.domain.entity;


import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * (Accountno)表实体类
 *
 * @author makejava
 * @since 2022-08-24 14:19:15
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Accountno  implements UserDetails, Serializable{
    private static final long serialVersionUID = 1905122041950251207L;
    @ApiModelProperty(value="用户名")
    private String username;
    @ApiModelProperty(value="密码")
    private String password;
    @ApiModelProperty(value="电话")
    private String phone;
    @ApiModelProperty(value="邮箱")
    private String email;
    @ApiModelProperty(value="头像")
    private String img;
    @ApiModelProperty(value="角色")
    private List<Role> roles;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = roles
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());

        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

