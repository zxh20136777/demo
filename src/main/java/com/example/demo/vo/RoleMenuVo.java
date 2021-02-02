package com.example.demo.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

public class RoleMenuVo implements Serializable {
    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "所属应用")
    private Long appId;

    @ApiModelProperty(value = "父权限")
    private Long parentId;

    @ApiModelProperty(value = "功能名称")
    private String menuName;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "功能类型 1:菜单 2:按钮 3:新开页面单面")
    private Integer type;

    @ApiModelProperty(value = "是否属于选中状态")
    private boolean selected;

    @ApiModelProperty(value = "父节点的子菜单")
    private List<RoleMenuVo> children;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List<RoleMenuVo> getChildren() {
        return children;
    }

    public void setChildren(List<RoleMenuVo> children) {
        this.children = children;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
