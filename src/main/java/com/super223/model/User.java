package com.super223.model;

import java.time.LocalDate;
import java.util.Date;
import javax.persistence.*;

public class User {
    /**
     * 会员ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 账户
     */
    private Float account;

    /**
     * 是否被禁言　０：未禁言; １：禁言
     */
    private Boolean state;

    /**
     * 盐值
     */
    private String salt;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 创建时间
     */
    private LocalDate createtime;

    /**
     * 生日
     */
    private LocalDate birthday;

    /**
     * 性别（0 . 保密  1 . 男  2 . 女）
     */
    private Integer sex;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 用户角色
     */
    private Integer roleid;

    /**
     * 获取会员ID
     *
     * @return id - 会员ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置会员ID
     *
     * @param id 会员ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取账户
     *
     * @return account - 账户
     */
    public Float getAccount() {
        return account;
    }

    /**
     * 设置账户
     *
     * @param account 账户
     */
    public void setAccount(Float account) {
        this.account = account;
    }

    /**
     * 获取是否被禁言　０：未禁言; １：禁言
     *
     * @return state - 是否被禁言　０：未禁言; １：禁言
     */
    public Boolean getState() {
        return state;
    }

    /**
     * 设置是否被禁言　０：未禁言; １：禁言
     *
     * @param state 是否被禁言　０：未禁言; １：禁言
     */
    public void setState(Boolean state) {
        this.state = state;
    }

    /**
     * 获取盐值
     *
     * @return salt - 盐值
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 设置盐值
     *
     * @param salt 盐值
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * 获取头像
     *
     * @return avatar - 头像
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 设置头像
     *
     * @param avatar 头像
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * 获取创建时间
     *
     * @return createtime - 创建时间
     */
    public LocalDate getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建时间
     *
     * @param createtime 创建时间
     */
    public void setCreatetime(LocalDate createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取生日
     *
     * @return birthday - 生日
     */
    public LocalDate getBirthday() {
        return birthday;
    }

    /**
     * 设置生日
     *
     * @param birthday 生日
     */
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取性别（0 . 保密  1 . 男  2 . 女）
     *
     * @return sex - 性别（0 . 保密  1 . 男  2 . 女）
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置性别（0 . 保密  1 . 男  2 . 女）
     *
     * @param sex 性别（0 . 保密  1 . 男  2 . 女）
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取手机号码
     *
     * @return phone - 手机号码
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号码
     *
     * @param phone 手机号码
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取用户角色
     *
     * @return roleid - 用户角色
     */
    public Integer getRoleid() {
        return roleid;
    }

    /**
     * 设置用户角色
     *
     * @param roleid 用户角色
     */
    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", account=" + account +
                ", state=" + state +
                ", salt='" + salt + '\'' +
                ", avatar='" + avatar + '\'' +
                ", createtime=" + createtime +
                ", birthday=" + birthday +
                ", sex=" + sex +
                ", phone='" + phone + '\'' +
                ", roleid=" + roleid +
                '}';
    }
}