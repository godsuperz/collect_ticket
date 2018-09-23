package com.super223.model;

import javax.persistence.*;

/**
 * @author superz
 */
public class Administrator {
    /**
     * 管理员ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 管理员登录名
     */
    private String name;

    /**
     * 管理员密码
     */
    private String password;

    /**
     * 获取管理员ID
     *
     * @return id - 管理员ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置管理员ID
     *
     * @param id 管理员ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取管理员登录名
     *
     * @return name - 管理员登录名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置管理员登录名
     *
     * @param name 管理员登录名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取管理员密码
     *
     * @return password - 管理员密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置管理员密码
     *
     * @param password 管理员密码
     */
    public void setPassword(String password) {
        this.password = password;
    }
}