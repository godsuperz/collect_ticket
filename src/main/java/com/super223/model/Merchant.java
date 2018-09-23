package com.super223.model;

import javax.persistence.*;

/**
 * @author superz
 */
public class Merchant {
    /**
     * 商家ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 商家登录名
     */
    private String username;

    /**
     * 商家登录密码
     */
    private String password;

    /**
     * 商家昵称
     */
    private String nickname;

    /**
     * 商家账户
     */
    private Float account;

    /**
     * 商家邮箱
     */
    private String email;

    /**
     * 商家地址
     */
    private String address;

    /**
     * 商家电话
     */
    private String tel;

    /**
     * 商家店铺简介
     */
    private String introduction;

    /**
     * 获取商家ID
     *
     * @return id - 商家ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置商家ID
     *
     * @param id 商家ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取商家登录名
     *
     * @return username - 商家登录名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置商家登录名
     *
     * @param username 商家登录名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取商家登录密码
     *
     * @return password - 商家登录密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置商家登录密码
     *
     * @param password 商家登录密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取商家昵称
     *
     * @return nickname - 商家昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置商家昵称
     *
     * @param nickname 商家昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取商家账户
     *
     * @return account - 商家账户
     */
    public Float getAccount() {
        return account;
    }

    /**
     * 设置商家账户
     *
     * @param account 商家账户
     */
    public void setAccount(Float account) {
        this.account = account;
    }

    /**
     * 获取商家邮箱
     *
     * @return email - 商家邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置商家邮箱
     *
     * @param email 商家邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取商家地址
     *
     * @return address - 商家地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置商家地址
     *
     * @param address 商家地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取商家电话
     *
     * @return tel - 商家电话
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置商家电话
     *
     * @param tel 商家电话
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 获取商家店铺简介
     *
     * @return introduction - 商家店铺简介
     */
    public String getIntroduction() {
        return introduction;
    }

    /**
     * 设置商家店铺简介
     *
     * @param introduction 商家店铺简介
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}