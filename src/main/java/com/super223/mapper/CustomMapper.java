package com.super223.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author superz
 */
@Repository
@Mapper
public interface CustomMapper {
    /**
     * 获取全部的地址
     * @return 地址列表
     */
    List<String> getAllAddress();

    /**
     * 获取全部的类型
     * @return 类型列表
     */
    List<String> getAllType();


    /**
     * 获取关键词的城市列表
     * @param keyWord 关键词
     * @return 城市名称列表
     */
    List<String> getCityByKeyWord(String keyWord);

    /**
     * 获取关键词的类型列表
     * @param keyWord 关键词
     * @return 列表名称列表
     */
    List<String> getTypeByKeyWord(String keyWord);
}
