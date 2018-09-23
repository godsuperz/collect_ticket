package com.super223.service;

import org.springframework.boot.configurationprocessor.json.JSONException;

import java.io.IOException;

/**
 * 票务服务层
 * @author superz
 */
public interface TicketService {
    /**
     * 通过json文件添加票务
     */
    void addTicket(int merchantid) throws IOException, JSONException;
}
