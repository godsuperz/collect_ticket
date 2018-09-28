package com.super223.service.impl;

import com.super223.mapper.CustomMapper;
import com.super223.mapper.KeepMapper;
import com.super223.mapper.TicketMapper;
import com.super223.mapper.UserMapper;
import com.super223.model.Keep;
import com.super223.model.User;
import com.super223.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CustomMapper customMapper;

    @Override
    @Transactional
    public void addUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public User getUserByUsername(String username) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmptyOrWhitespace(username)) {
            criteria.andEqualTo("username", username);
        }
        return userMapper.selectOneByExample(example);
    }

    @Override
    public void updateUser(User user) {

        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public List<Integer> getUserCollect(String username) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username" ,username);
        User user = userMapper.selectOneByExample(example);

        return customMapper.getUserCollect(user.getId());
    }

    @Override
    public void removeCollect(Integer userid, Integer ticketid) {
        customMapper.deleteCollect(userid, ticketid);
    }

    @Override
    public void addCollect(Integer userid, Integer ticketid) {
        List<Integer> ticketidList = customMapper.getUserCollect(userid);
        if (!ticketidList.contains(ticketid)) {
            customMapper.addCollect(userid, ticketid);
        }
    }
}
