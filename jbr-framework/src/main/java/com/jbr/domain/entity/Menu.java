package com.jbr.domain.entity;


import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * (Menu)表实体类
 *
 * @author makejava
 * @since 2022-08-29 11:30:15
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu  {
    @ApiModelProperty("id")
    private Integer id;
    @ApiModelProperty("url")
    private String url;
    @ApiModelProperty("path")
    private String path;
    @ApiModelProperty("组件")
    private String component;
    @ApiModelProperty("菜单名")
    private String name;
    @ApiModelProperty("图标")
    private String iconcls;
    @ApiModelProperty("是否保持激活")
    private Integer keepalive;
    @ApiModelProperty("是否要求权限")
    private Integer requireauth;
    @ApiModelProperty("父id")
    private Integer parentid;
    @ApiModelProperty("是否启用")
    private Integer enabled;
    @ApiModelProperty("所属角色")
    private Integer role;
    @ApiModelProperty("子菜单")
    private List<Menu> children;

    private List<Role> roles;




}

