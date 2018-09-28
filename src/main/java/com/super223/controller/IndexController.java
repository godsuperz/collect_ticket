package com.super223.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.super223.common.constant.Const;
import com.super223.model.JSONResult;
import com.super223.model.Ticket;
import com.super223.service.TicketService;
import com.super223.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

/**
 * 首页异步请求控制层
 * @author superz
 */

@RestController
public class IndexController {

    private final TicketService ticketService;

    @Autowired
    public IndexController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    /**
     * 获取搜索热词
     * @return 热词json对象
     */
    @GetMapping("/getHotWords")
    public JSONResult getHotWords(){
        return JSONResult.ok(ticketService.getHotWordByNum(9));
    }

    /**
     * 获取搜索推荐列表
     * @param condition 输入框中的数据
     * @return 推荐列表
     */
    @PostMapping("/searchList")
    public JSONResult searchList(@RequestParam("condition") String condition){
        List<Ticket> ticketList = ticketService.getTicketByName(condition);
        if (ticketList.size() > Const.SEARCHLIST_COUNT){
            return JSONResult.ok(ticketList.subList(0, 10));
        }
        return JSONResult.ok(ticketList);
    }

    /**
     * 条件搜索票务
     * @return 搜索结果列表
     */
    @PostMapping("/searchTicket")
    public JSONResult searchTicket(@RequestParam("currPage") Integer page,
                                   @RequestParam("keyword") String name,
                                   @RequestParam("city") String city,
                                   @RequestParam("type") String type,
                                   @RequestParam("time") Integer time){
        LocalDate startTime = DateUtil.Condition2Date(time);
        Ticket ticket = new Ticket();
        ticket.setName(name);
        ticket.setCityname(city);
        ticket.setCategoryname(type);
        ticket.setStartTime(startTime);

        PageHelper.startPage(page, Const.PAGE_SIZE);
        List<Ticket> ticketList = ticketService.getTicketByCondition(ticket);

        PageInfo<Ticket> pageInfo = new PageInfo<>(ticketList);
        int currPage = pageInfo.getPageNum();
        int pages = pageInfo.getPages();

        return JSONResult.ok(ticketList, pages-currPage);
    }

    /**
     * 获取票务top3
     * @return top3列表
     */
    @GetMapping("/getEveryoneLookFor")
    public JSONResult getEveryoneLookFor(){
        PageHelper.startPage(1, Const.TOP_CLICK);
        List<Ticket> ticketList = ticketService.getTopByClick();
        return JSONResult.ok(ticketList);
    }
}
