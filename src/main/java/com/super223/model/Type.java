package com.super223.model;

import javax.persistence.*;

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
     * 类型图标
     */
    private String icon;

    /**
     * 是否展示在主页菜单
     */
    @Column(name = "show_menu")
    private Boolean showMenu;

    /**
     * 子类型id
     */
    private Integer subcategoryid;

    /**
     * 在菜单中的序号
     */
    private Integer rank;

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

    /**
     * 获取类型图标
     *
     * @return icon - 类型图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置类型图标
     *
     * @param icon 类型图标
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 获取是否展示在主页菜单
     *
     * @return show_menu - 是否展示在主页菜单
     */
    public Boolean getShowMenu() {
        return showMenu;
    }

    /**
     * 设置是否展示在主页菜单
     *
     * @param showMenu 是否展示在主页菜单
     */
    public void setShowMenu(Boolean showMenu) {
        this.showMenu = showMenu;
    }

    /**
     * 获取子类型id
     *
     * @return subcategoryid - 子类型id
     */
    public Integer getSubcategoryid() {
        return subcategoryid;
    }

    /**
     * 设置子类型id
     *
     * @param subcategoryid 子类型id
     */
    public void setSubcategoryid(Integer subcategoryid) {
        this.subcategoryid = subcategoryid;
    }

    /**
     * 获取在菜单中的序号
     *
     * @return rank - 在菜单中的序号
     */
    public Integer getRank() {
        return rank;
    }

    /**
     * 设置在菜单中的序号
     *
     * @param rank 在菜单中的序号
     */
    public void setRank(Integer rank) {
        this.rank = rank;
    }
}