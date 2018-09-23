package com.super223.model;

import javax.persistence.*;

/**
 * @author superz
 */
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", account=" + account +
                ", state=" + state +
                '}';
    }
}