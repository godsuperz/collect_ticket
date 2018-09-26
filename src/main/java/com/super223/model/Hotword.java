package com.super223.model;

import javax.persistence.*;

public class Hotword {
    /**
     * 热词id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 热词名称
     */
    private String name;

    /**
     * 热词被搜索次数
     */
    private Integer count;

    /**
     * 获取热词id
     *
     * @return id - 热词id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置热词id
     *
     * @param id 热词id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取热词名称
     *
     * @return name - 热词名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置热词名称
     *
     * @param name 热词名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取热词被搜索次数
     *
     * @return count - 热词被搜索次数
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 设置热词被搜索次数
     *
     * @param count 热词被搜索次数
     */
    public void setCount(Integer count) {
        this.count = count;
    }
}