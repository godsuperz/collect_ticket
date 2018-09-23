package com.super223.model;

import java.util.Date;
import javax.persistence.*;

/**
 * @author superz
 */
public class Comment {
    /**
     * 评论id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 外键　关联ticket表
     */
    private Integer ticketid;

    /**
     * 外键　关联user表
     */
    private Integer userid;

    /**
     * 评论时间
     */
    private Date time;

    /**
     * 评论是否被举报，默认为未举报
     */
    private Byte state;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 获取评论id
     *
     * @return id - 评论id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置评论id
     *
     * @param id 评论id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取外键　关联ticket表
     *
     * @return ticketid - 外键　关联ticket表
     */
    public Integer getTicketid() {
        return ticketid;
    }

    /**
     * 设置外键　关联ticket表
     *
     * @param ticketid 外键　关联ticket表
     */
    public void setTicketid(Integer ticketid) {
        this.ticketid = ticketid;
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
     * 获取评论时间
     *
     * @return time - 评论时间
     */
    public Date getTime() {
        return time;
    }

    /**
     * 设置评论时间
     *
     * @param time 评论时间
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * 获取评论是否被举报，默认为未举报
     *
     * @return state - 评论是否被举报，默认为未举报
     */
    public Byte getState() {
        return state;
    }

    /**
     * 设置评论是否被举报，默认为未举报
     *
     * @param state 评论是否被举报，默认为未举报
     */
    public void setState(Byte state) {
        this.state = state;
    }

    /**
     * 获取评论内容
     *
     * @return content - 评论内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置评论内容
     *
     * @param content 评论内容
     */
    public void setContent(String content) {
        this.content = content;
    }
}