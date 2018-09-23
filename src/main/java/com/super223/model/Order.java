package com.super223.model;

import java.util.Date;
import javax.persistence.*;

/**
 * @author superz
 */
public class Order {
    /**
     * 订单id
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
     * 下单时间
     */
    private Date time;

    /**
     * 订票张数
     */
    private Integer count;

    /**
     * 订单状态
     */
    private Byte state;

    /**
     * 备注
     */
    private String remark;

    /**
     * 交易总额
     */
    private Float sum;

    /**
     * 获取订单id
     *
     * @return id - 订单id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置订单id
     *
     * @param id 订单id
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
     * 获取下单时间
     *
     * @return time - 下单时间
     */
    public Date getTime() {
        return time;
    }

    /**
     * 设置下单时间
     *
     * @param time 下单时间
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * 获取订票张数
     *
     * @return count - 订票张数
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 设置订票张数
     *
     * @param count 订票张数
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 获取订单状态
     *
     * @return state - 订单状态
     */
    public Byte getState() {
        return state;
    }

    /**
     * 设置订单状态
     *
     * @param state 订单状态
     */
    public void setState(Byte state) {
        this.state = state;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取交易总额
     *
     * @return sum - 交易总额
     */
    public Float getSum() {
        return sum;
    }

    /**
     * 设置交易总额
     *
     * @param sum 交易总额
     */
    public void setSum(Float sum) {
        this.sum = sum;
    }
}