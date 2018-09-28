package com.super223.service;

import com.super223.model.User;

import java.util.List;

/**
 * 用户服务层
 * @author superz
 */
public interface UserService {
    /**
     * 添加会员
     * @param user 会员对象
     */
    void addUser(User user);

    /**
     * 通过用户名查询用户
     * @param username 用户名
     * @return 用户对象
     */
    User getUserByUsername(String username);

    /**
     * 更新用户
     * @param user 用户信息
     */
    void updateUser(User user);

    /**
     * 获取用户收藏列表
     * @return 收藏列表
     */
    List<Integer> getUserCollect(String username);

    /**
     * 移除收藏
     * @param userid 用户id
     * @param ticketid 票务id
     */
    void removeCollect(Integer userid, Integer ticketid);

    /**
     * 添加收藏
     * @param userid 用户id
     * @param ticketid 票务id
     */
    void addCollect(Integer userid, Integer ticketid);
}
