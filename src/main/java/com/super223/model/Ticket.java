package com.super223.model;

import java.time.LocalDate;
import java.util.Date;
import javax.persistence.*;

public class Ticket {
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
     * 票价
     */
    private Float price;

    /**
     * 外键　关联merchant表
     */
    private Integer merchantid;

    /**
     * 票务开始时间
     */
    @Column(name = "start_time")
    private LocalDate startTime;

    /**
     * 票务结束时间
     */
    @Column(name = "end_time")
    private LocalDate endTime;

    /**
     * 是否是下架商品 0：非下架　１：已下架
     */
    private Boolean state;

    /**
     * 票务数量
     */
    private Integer count;

    /**
     * 票务介绍
     */
    private String introduction;

    /**
     * 是否审核通过，默认未通过
     */
    private Boolean audit;

    /**
     * 点击数
     */
    private Integer click;

    /**
     * 购买数
     */
    private Integer purchase;

    /**
     * 图片地址
     */
    private String img;

    /**
     * 演员
     */
    private String actors;

    /**
     * 类型名称
     */
    private String categoryname;

    /**
     * 城市名称
     */
    private String cityname;

    /**
     * 是否是电子票
     */
    private Boolean iseticket;

    /**
     * 是否是一般代理票
     */
    private Boolean isgeneralagent;

    /**
     * 是否是超级票
     */
    private Boolean issuperticket;

    /**
     * 是否要选座
     */
    private Boolean isxuanzuo;

    /**
     * 没有HTML的名字
     */
    @Column(name = "nameNoHtml")
    private String namenohtml;

    /**
     * 最高票价
     */
    private Float pricehigh;

    /**
     * 票务状态
     */
    private String showstatus;

    /**
     * 标签
     */
    private String showtag;

    /**
     * 时间
     */
    private String showtime;

    /**
     * 子类型
     */
    private String subcategoryname;

    /**
     * 场馆
     */
    private String venue;

    /**
     * 搜索项目id
     */
    private String projectid;

    /**
     * 价格区间
     */
    @Column(name = "price_str")
    private String priceStr;

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
     * 获取票价
     *
     * @return price - 票价
     */
    public Float getPrice() {
        return price;
    }

    /**
     * 设置票价
     *
     * @param price 票价
     */
    public void setPrice(Float price) {
        this.price = price;
    }

    /**
     * 获取外键　关联merchant表
     *
     * @return merchantid - 外键　关联merchant表
     */
    public Integer getMerchantid() {
        return merchantid;
    }

    /**
     * 设置外键　关联merchant表
     *
     * @param merchantid 外键　关联merchant表
     */
    public void setMerchantid(Integer merchantid) {
        this.merchantid = merchantid;
    }

    /**
     * 获取票务开始时间
     *
     * @return start_time - 票务开始时间
     */
    public LocalDate getStartTime() {
        return startTime;
    }

    /**
     * 设置票务开始时间
     *
     * @param startTime 票务开始时间
     */
    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取票务结束时间
     *
     * @return end_time - 票务结束时间
     */
    public LocalDate getEndTime() {
        return endTime;
    }

    /**
     * 设置票务结束时间
     *
     * @param endTime 票务结束时间
     */
    public void setEndTime(LocalDate endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取是否是下架商品 0：非下架　１：已下架
     *
     * @return state - 是否是下架商品 0：非下架　１：已下架
     */
    public Boolean getState() {
        return state;
    }

    /**
     * 设置是否是下架商品 0：非下架　１：已下架
     *
     * @param state 是否是下架商品 0：非下架　１：已下架
     */
    public void setState(Boolean state) {
        this.state = state;
    }

    /**
     * 获取票务数量
     *
     * @return count - 票务数量
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 设置票务数量
     *
     * @param count 票务数量
     */
    public void setCount(Integer count) {
        this.count = count;
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

    /**
     * 获取是否审核通过，默认未通过
     *
     * @return audit - 是否审核通过，默认未通过
     */
    public Boolean getAudit() {
        return audit;
    }

    /**
     * 设置是否审核通过，默认未通过
     *
     * @param audit 是否审核通过，默认未通过
     */
    public void setAudit(Boolean audit) {
        this.audit = audit;
    }

    /**
     * 获取点击数
     *
     * @return click - 点击数
     */
    public Integer getClick() {
        return click;
    }

    /**
     * 设置点击数
     *
     * @param click 点击数
     */
    public void setClick(Integer click) {
        this.click = click;
    }

    /**
     * 获取购买数
     *
     * @return purchase - 购买数
     */
    public Integer getPurchase() {
        return purchase;
    }

    /**
     * 设置购买数
     *
     * @param purchase 购买数
     */
    public void setPurchase(Integer purchase) {
        this.purchase = purchase;
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
     * 获取演员
     *
     * @return actors - 演员
     */
    public String getActors() {
        return actors;
    }

    /**
     * 设置演员
     *
     * @param actors 演员
     */
    public void setActors(String actors) {
        this.actors = actors;
    }

    /**
     * 获取类型名称
     *
     * @return categoryname - 类型名称
     */
    public String getCategoryname() {
        return categoryname;
    }

    /**
     * 设置类型名称
     *
     * @param categoryname 类型名称
     */
    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    /**
     * 获取城市名称
     *
     * @return cityname - 城市名称
     */
    public String getCityname() {
        return cityname;
    }

    /**
     * 设置城市名称
     *
     * @param cityname 城市名称
     */
    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    /**
     * 获取是否是电子票
     *
     * @return iseticket - 是否是电子票
     */
    public Boolean getIseticket() {
        return iseticket;
    }

    /**
     * 设置是否是电子票
     *
     * @param iseticket 是否是电子票
     */
    public void setIseticket(Boolean iseticket) {
        this.iseticket = iseticket;
    }

    /**
     * 获取是否是一般代理票
     *
     * @return isgeneralagent - 是否是一般代理票
     */
    public Boolean getIsgeneralagent() {
        return isgeneralagent;
    }

    /**
     * 设置是否是一般代理票
     *
     * @param isgeneralagent 是否是一般代理票
     */
    public void setIsgeneralagent(Boolean isgeneralagent) {
        this.isgeneralagent = isgeneralagent;
    }

    /**
     * 获取是否是超级票
     *
     * @return issuperticket - 是否是超级票
     */
    public Boolean getIssuperticket() {
        return issuperticket;
    }

    /**
     * 设置是否是超级票
     *
     * @param issuperticket 是否是超级票
     */
    public void setIssuperticket(Boolean issuperticket) {
        this.issuperticket = issuperticket;
    }

    /**
     * 获取是否要选座
     *
     * @return isxuanzuo - 是否要选座
     */
    public Boolean getIsxuanzuo() {
        return isxuanzuo;
    }

    /**
     * 设置是否要选座
     *
     * @param isxuanzuo 是否要选座
     */
    public void setIsxuanzuo(Boolean isxuanzuo) {
        this.isxuanzuo = isxuanzuo;
    }

    /**
     * 获取没有HTML的名字
     *
     * @return nameNoHtml - 没有HTML的名字
     */
    public String getNamenohtml() {
        return namenohtml;
    }

    /**
     * 设置没有HTML的名字
     *
     * @param namenohtml 没有HTML的名字
     */
    public void setNamenohtml(String namenohtml) {
        this.namenohtml = namenohtml;
    }

    /**
     * 获取最高票价
     *
     * @return pricehigh - 最高票价
     */
    public Float getPricehigh() {
        return pricehigh;
    }

    /**
     * 设置最高票价
     *
     * @param pricehigh 最高票价
     */
    public void setPricehigh(Float pricehigh) {
        this.pricehigh = pricehigh;
    }

    /**
     * 获取票务状态
     *
     * @return showstatus - 票务状态
     */
    public String getShowstatus() {
        return showstatus;
    }

    /**
     * 设置票务状态
     *
     * @param showstatus 票务状态
     */
    public void setShowstatus(String showstatus) {
        this.showstatus = showstatus;
    }

    /**
     * 获取标签
     *
     * @return showtag - 标签
     */
    public String getShowtag() {
        return showtag;
    }

    /**
     * 设置标签
     *
     * @param showtag 标签
     */
    public void setShowtag(String showtag) {
        this.showtag = showtag;
    }

    /**
     * 获取时间
     *
     * @return showtime - 时间
     */
    public String getShowtime() {
        return showtime;
    }

    /**
     * 设置时间
     *
     * @param showtime 时间
     */
    public void setShowtime(String showtime) {
        this.showtime = showtime;
    }

    /**
     * 获取子类型
     *
     * @return subcategoryname - 子类型
     */
    public String getSubcategoryname() {
        return subcategoryname;
    }

    /**
     * 设置子类型
     *
     * @param subcategoryname 子类型
     */
    public void setSubcategoryname(String subcategoryname) {
        this.subcategoryname = subcategoryname;
    }

    /**
     * 获取场馆
     *
     * @return venue - 场馆
     */
    public String getVenue() {
        return venue;
    }

    /**
     * 设置场馆
     *
     * @param venue 场馆
     */
    public void setVenue(String venue) {
        this.venue = venue;
    }

    /**
     * 获取搜索项目id
     *
     * @return projectid - 搜索项目id
     */
    public String getProjectid() {
        return projectid;
    }

    /**
     * 设置搜索项目id
     *
     * @param projectid 搜索项目id
     */
    public void setProjectid(String projectid) {
        this.projectid = projectid;
    }

    /**
     * 获取价格区间
     *
     * @return price_str - 价格区间
     */
    public String getPriceStr() {
        return priceStr;
    }

    /**
     * 设置价格区间
     *
     * @param priceStr 价格区间
     */
    public void setPriceStr(String priceStr) {
        this.priceStr = priceStr;
    }
}