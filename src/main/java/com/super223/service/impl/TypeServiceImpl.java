package com.super223.service.impl;

import com.super223.mapper.TypeMapper;
import com.super223.model.Type;
import com.super223.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author superz
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;

    @Override
    public List<Type> getTypeShowMenu() {

        Example example = new Example(Type.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("showMenu", 1);
        return typeMapper.selectByExample(example);
    }
}
