package com.super223.service.impl;

import com.super223.mapper.UserMapper;
import com.super223.model.User;
import com.super223.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public void addUser(User user) {
        userMapper.insert(user);
    }
}
