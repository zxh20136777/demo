package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableLogic;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 用户账号表
 * </p>
 *
 * @author Anson
 * @since 2021-01-13
 */
@TableName("uc_user")
@ApiModel(value="UcUser对象", description="用户账号表")
public class UcUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "用户名")
    private String userCode;

    @ApiModelProperty(value = "密码 md5(username+password)")
    private String passwd;

    @ApiModelProperty(value = "0:不可用,1:可用")
    private Boolean enabled;

    @ApiModelProperty(value = "称谓,1:先生,2:小姐,3:女士")
    private Integer appellation;

    @ApiModelProperty(value = "英文名称")
    private String firstName;

    @ApiModelProperty(value = "英文姓氏")
    private String lastName;

    @ApiModelProperty(value = "国家名称")
    private String countryNameEn;

    @ApiModelProperty(value = "国家编码")
    private String countryCodeEn;

    @ApiModelProperty(value = "国家电话号码前缀")
    private String telNoCountry;

    @ApiModelProperty(value = "地区电话号码前缀")
    private String telNoArea;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "显示名称")
    private String nickName;

    @ApiModelProperty(value = "是否创建者 0:否 1:是")
    private Boolean rootRole;

    @ApiModelProperty(value = "0:未校验邮箱 1:已经校验")
    private Boolean hasCheckEmail;

    @ApiModelProperty(value = "电话号码")
    private String mobile;

    @ApiModelProperty(value = "0:未校验手机 1:已经校验")
    private Boolean hasCheckMobile;

    @ApiModelProperty(value = "0:没有im账号 1:有im账号")
    private Boolean hasImAccount;

    @ApiModelProperty(value = "所属主账号")
    private Long accountId;

    @ApiModelProperty(value = "逻辑删除字段,开发者无需关心 0:存在 1:删除")
    @TableLogic
    private Integer deleted;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createDate;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime modifyDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }
    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
    public Integer getAppellation() {
        return appellation;
    }

    public void setAppellation(Integer appellation) {
        this.appellation = appellation;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getCountryNameEn() {
        return countryNameEn;
    }

    public void setCountryNameEn(String countryNameEn) {
        this.countryNameEn = countryNameEn;
    }
    public String getCountryCodeEn() {
        return countryCodeEn;
    }

    public void setCountryCodeEn(String countryCodeEn) {
        this.countryCodeEn = countryCodeEn;
    }
    public String getTelNoCountry() {
        return telNoCountry;
    }

    public void setTelNoCountry(String telNoCountry) {
        this.telNoCountry = telNoCountry;
    }
    public String getTelNoArea() {
        return telNoArea;
    }

    public void setTelNoArea(String telNoArea) {
        this.telNoArea = telNoArea;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public Boolean getRootRole() {
        return rootRole;
    }

    public void setRootRole(Boolean rootRole) {
        this.rootRole = rootRole;
    }
    public Boolean getHasCheckEmail() {
        return hasCheckEmail;
    }

    public void setHasCheckEmail(Boolean hasCheckEmail) {
        this.hasCheckEmail = hasCheckEmail;
    }
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public Boolean getHasCheckMobile() {
        return hasCheckMobile;
    }

    public void setHasCheckMobile(Boolean hasCheckMobile) {
        this.hasCheckMobile = hasCheckMobile;
    }
    public Boolean getHasImAccount() {
        return hasImAccount;
    }

    public void setHasImAccount(Boolean hasImAccount) {
        this.hasImAccount = hasImAccount;
    }
    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
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

    @Override
    public String toString() {
        return "UcUser{" +
        "id=" + id +
        ", userCode=" + userCode +
        ", passwd=" + passwd +
        ", enabled=" + enabled +
        ", appellation=" + appellation +
        ", firstName=" + firstName +
        ", lastName=" + lastName +
        ", countryNameEn=" + countryNameEn +
        ", countryCodeEn=" + countryCodeEn +
        ", telNoCountry=" + telNoCountry +
        ", telNoArea=" + telNoArea +
        ", email=" + email +
        ", nickName=" + nickName +
        ", rootRole=" + rootRole +
        ", hasCheckEmail=" + hasCheckEmail +
        ", mobile=" + mobile +
        ", hasCheckMobile=" + hasCheckMobile +
        ", hasImAccount=" + hasImAccount +
        ", accountId=" + accountId +
        ", deleted=" + deleted +
        ", createDate=" + createDate +
        ", modifyDate=" + modifyDate +
        "}";
    }
}
