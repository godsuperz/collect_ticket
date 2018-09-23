package com.super223.model;

import javax.persistence.*;

/**
 * @author superz
 */
public class Keep {
    /**
     * 收藏id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    private Integer userid;

    private Integer ticketid;

    /**
     * 获取收藏id
     *
     * @return id - 收藏id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置收藏id
     *
     * @param id 收藏id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return userid
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * @param userid
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * @return ticketid
     */
    public Integer getTicketid() {
        return ticketid;
    }

    /**
     * @param ticketid
     */
    public void setTicketid(Integer ticketid) {
        this.ticketid = ticketid;
    }
}