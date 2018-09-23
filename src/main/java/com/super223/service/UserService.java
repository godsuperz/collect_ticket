package com.super223.service;

import com.super223.model.User;

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
}
