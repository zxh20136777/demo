package com.example.demo.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author 胡毅宇#81015646
 * @since 2020-09-21
 */
@TableName("uc_menu")
@ApiModel(value = "UcMenu对象", description = "菜单表")
public class UcMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
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

    @ApiModelProperty(value = "功能地址")
    private String menuUrl;

    @ApiModelProperty(value = "展示样式")
    private String iconClass;

    @ApiModelProperty(value = "逻辑删除字段,开发者无需关心 0:存在 1:删除")
    @TableLogic
    private Integer deleted;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createDate;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime modifyDate;

    @ApiModelProperty(value = "功能描述")
    private String menuDesc;

    @ApiModelProperty(value = "功能状态 0 不可用 1 可用")
    private Integer menuStatus;

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

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getIconClass() {
        return iconClass;
    }

    public void setIconClass(String iconClass) {
        this.iconClass = iconClass;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(LocalDateTime modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public String getMenuDesc() {
        return menuDesc;
    }

    public void setMenuDesc(String menuDesc) {
        this.menuDesc = menuDesc;
    }

    public Integer getMenuStatus() {
        return menuStatus;
    }

    public void setMenuStatus(Integer menuStatus) {
        this.menuStatus = menuStatus;
    }

    @Override
    public String toString() {
        return "UcMenu{" +
            "id=" + id +
            ", appId=" + appId +
            ", parentId=" + parentId +
            ", menuName=" + menuName +
            ", sort=" + sort +
            ", iconClass=" + iconClass +
            ", deleted=" + deleted +
            ", type=" + type +
            ", menuUrl=" + menuUrl +
            ", iconClass=" + iconClass +
            ", createDate=" + createDate +
            ", modifyDate=" + modifyDate +
            "}";
    }
}
