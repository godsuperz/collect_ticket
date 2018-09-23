package com.super223.model;

import javax.persistence.*;

/**
 * @author superz
 */
public class Subscribe {
    /**
     * 订阅id

     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 外键　关联user表
     */
    private Integer userid;

    /**
     * 外键　关联type表
     */
    private Integer typeid;

    /**
     * 获取订阅id

     *
     * @return id - 订阅id

     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置订阅id

     *
     * @param id 订阅id

     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取外键　关联user表
     *
     * @return userid - 外键　关联user表
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * 设置外键　关联user表
     *
     * @param userid 外键　关联user表
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * 获取外键　关联type表
     *
     * @return typeid - 外键　关联type表
     */
    public Integer getTypeid() {
        return typeid;
    }

    /**
     * 设置外键　关联type表
     *
     * @param typeid 外键　关联type表
     */
    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }
}