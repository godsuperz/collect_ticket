package com.super223.model;

import javax.persistence.*;

/**
 * @author superz
 */
public class Location {
    /**
     * 地点ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 地点名称
     */
    private String name;

    /**
     * 获取地点ID
     *
     * @return id - 地点ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置地点ID
     *
     * @param id 地点ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取地点名称
     *
     * @return name - 地点名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置地点名称
     *
     * @param name 地点名称
     */
    public void setName(String name) {
        this.name = name;
    }
}