package com.super223.model;

import javax.persistence.*;

/**
 * @author superz
 */
public class Type {
    /**
     * 类型id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 类型名
     */
    private String name;

    /**
     * 获取类型id
     *
     * @return id - 类型id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置类型id
     *
     * @param id 类型id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取类型名
     *
     * @return name - 类型名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置类型名
     *
     * @param name 类型名
     */
    public void setName(String name) {
        this.name = name;
    }
}