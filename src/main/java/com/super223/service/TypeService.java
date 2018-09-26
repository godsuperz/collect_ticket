package com.super223.service;

import com.super223.model.Type;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 票务类型服务层
 * @author superz
 */
public interface TypeService {
    /**
     * 获取在菜单中展示的类型
     */
    List<Type> getTypeShowMenu();

}
