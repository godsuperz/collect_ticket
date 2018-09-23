package com.super223.utils;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author superz
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
