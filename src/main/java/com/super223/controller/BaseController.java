package com.super223.controller;

import com.super223.model.Hotword;
import com.super223.model.Ticket;
import com.super223.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author superz
 */
@Controller
public class BaseController {

    @Autowired
    private TicketService ticketService;

    /**
     * 网站首页
     * @return 在templates中的模板
     */
    @GetMapping("/")
    public String index(HttpServletRequest request, ModelMap map){
        String username = (String) request.getSession().getAttribute("username");
        if (!StringUtils.isEmptyOrWhitespace(username)){
            map.put("username", username);
        } else {
            map.put("username", null);
        }
        return "shouye";
    }

    @GetMapping("/search")
    public String search(ModelMap map,
                             @RequestParam(value = "k", required = false) String key,
                         @RequestParam(value = "type", required = false) String type,
                         HttpServletRequest request){

        String username = (String) request.getSession().getAttribute("username");
        if (!StringUtils.isEmptyOrWhitespace(username)){
            map.put("username", username);
        } else {
            map.put("username", null);
        }
        map.put("key", key);
        List<String> typeList;
        List<String> addressList;
        // 热词处理
        if (!StringUtils.isEmptyOrWhitespace(key)) {
            // 有搜索条件
            // 查询数据库中是否已存在该热词
            Hotword hotword = ticketService.getHotWordByName(key);
            if (hotword != null) {
                Hotword w = new Hotword();
                w.setId(hotword.getId());
                w.setCount(hotword.getCount() + 1);
                ticketService.updateHotWord(w);
            } else {
                Hotword w = new Hotword();
                w.setName(key);
                w.setCount(1);
                ticketService.addHotWord(w);
            }
            // 获取关键词票务城市列表
            addressList = ticketService.getCityByKeyWord(key);
            // 获取关键词票务类型列表
            typeList = ticketService.getTypeByKeyWord(key);
        } else {
            // 获取所有票务城市列表
            addressList = ticketService.getAllCity();
            // 获取所有票务类型列表
            typeList = ticketService.getAllType();
        }


        if (!StringUtils.isEmptyOrWhitespace(type)) {
            map.put("searchType", type);
        } else {
            map.put("searchType", null);
        }
        map.put("addressList", addressList);
        map.put("typeList", typeList);
        return "sousuo";
    }

    /**
     * 票务详细页
     * @return
     */
    @GetMapping("/ticket/item/{id}")
    public String ticketItem(HttpServletRequest request, @PathVariable Integer id, ModelMap map){

        String username = (String) request.getSession().getAttribute("username");
        if (!StringUtils.isEmptyOrWhitespace(username)){
            map.put("username", username);
        } else {
            map.put("username", null);
        }
        Ticket ticket = ticketService.getTicketInfoById(id);
        map.put("ticket", ticket);
        return "user/xiangxi";
//      return JSONResult.ok(ticket);
    }

}
