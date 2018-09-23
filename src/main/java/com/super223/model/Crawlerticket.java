package com.super223.model;

import java.util.Date;
import javax.persistence.*;

/**
 * @author superz
 */
public class Crawlerticket {
    /**
     * 票务id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 票务名称
     */
    private String name;

    /**
     * 票务时间
     */
    private Date time;

    /**
     * 票务价格
     */
    private Float price;

    /**
     * 图片地址
     */
    private String img;

    /**
     * 票务地点
     */
    private Integer locationid;

    /**
     * 商家名称
     */
    private String merchant;

    /**
     * 来源地址
     */
    private String url;

    /**
     * 票务介绍
     */
    private String introduction;

    /**
     * 获取票务id
     *
     * @return id - 票务id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置票务id
     *
     * @param id 票务id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取票务名称
     *
     * @return name - 票务名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置票务名称
     *
     * @param name 票务名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取票务时间
     *
     * @return time - 票务时间
     */
    public Date getTime() {
        return time;
    }

    /**
     * 设置票务时间
     *
     * @param time 票务时间
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * 获取票务价格
     *
     * @return price - 票务价格
     */
    public Float getPrice() {
        return price;
    }

    /**
     * 设置票务价格
     *
     * @param price 票务价格
     */
    public void setPrice(Float price) {
        this.price = price;
    }

    /**
     * 获取图片地址
     *
     * @return img - 图片地址
     */
    public String getImg() {
        return img;
    }

    /**
     * 设置图片地址
     *
     * @param img 图片地址
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * 获取票务地点
     *
     * @return locationid - 票务地点
     */
    public Integer getLocationid() {
        return locationid;
    }

    /**
     * 设置票务地点
     *
     * @param locationid 票务地点
     */
    public void setLocationid(Integer locationid) {
        this.locationid = locationid;
    }

    /**
     * 获取商家名称
     *
     * @return merchant - 商家名称
     */
    public String getMerchant() {
        return merchant;
    }

    /**
     * 设置商家名称
     *
     * @param merchant 商家名称
     */
    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    /**
     * 获取来源地址
     *
     * @return url - 来源地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置来源地址
     *
     * @param url 来源地址
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取票务介绍
     *
     * @return introduction - 票务介绍
     */
    public String getIntroduction() {
        return introduction;
    }

    /**
     * 设置票务介绍
     *
     * @param introduction 票务介绍
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}