package com.super223.service;

import com.super223.model.Hotword;
import com.super223.model.Ticket;
import org.springframework.boot.configurationprocessor.json.JSONException;

import java.io.IOException;
import java.util.List;

/**
 * 票务服务层
 * @author superz
 */
public interface TicketService {
    /**
     * 通过json文件添加票务
     */
    void addTicket(int merchantid) throws IOException, JSONException;

    /**
     * 获取所用票务
     * @param page 分页的当前页数
     * @param pageSize 分页的页大小
     * @return 票务列表
     */
    List<Ticket> getAllTicket(Integer page, Integer pageSize);

    /**
     * 通过票的名字获取票务
     * @param name 票务名称
     * @return 票务列表
     */
    List<Ticket> getTicketByName(String name);

    /**
     * 条件查询票务
     * @param ticket 条件对象
     * @return 票务列表
     */
    List<Ticket> getTicketByCondition(Ticket ticket);

    /**
     * 获取指定数量的热词
     * @param num 要获取的热词数量
     * @return 热词列表
     */
    List<Hotword> getHotWordByNum(Integer num);

    /**
     * 通过热词名称查询热词
     * @param name 热词名称
     * @return 热词对象
     */
    Hotword getHotWordByName(String name);

    /**
     * 添加热词
     * @param hotword 热词对象
     */
    void addHotWord(Hotword hotword);

    /**
     * 修改热词
     * @param hotword 热词对象
     */
    void updateHotWord(Hotword hotword);

    /**
     * 获取城市列表
     * @return 城市列表
     */
    List<String> getAllCity();

    /**
     * 获取类型列表
     * @return 类型列表
     */
    List<String> getAllType();

    /**
     * 获取票务点击top榜
     * @return top榜列表
     */
    List<Ticket> getTopByClick();

    /**
     * 通过关键词获取城市列表
     * @param key 关键词
     * @return
     */
    List<String> getCityByKeyWord(String key);

    /**
     * 通过关键词获取类型列表
     * @param key 关键词
     * @return
     */
    List<String> getTypeByKeyWord(String key);

    /**
     * 通过ID查询票务详细信息
     * @param id 票务id
     * @return 票务信息
     */
    Ticket getTicketInfoById(Integer id);

    /**
     * 通过票务id列表获取票务信息
     * @param ticketIdList 票务id列表
     * @return 票务列表
    List<Ticket> getTicketByIdList(List<Integer> ticketIdList);*/
}
