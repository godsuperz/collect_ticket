package com.super223.service.impl;

import com.super223.mapper.TicketMapper;
import com.super223.model.Ticket;
import com.super223.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.misc.IOUtils;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Random;

/**
 * 票务service实现类
 * @author superz
 */
@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketMapper ticketMapper;

    @Value("classpath:static/json/ticketInfo.json")
    private Resource resource;

    @Override
    @Transactional
    public void addTicket(int merchantid) throws IOException, JSONException {
        // 从JSON文件中获取数据
        String json = new String(IOUtils.readFully(resource.getInputStream(), -1, true));
        // 建立JSON对象
        JSONObject jsonObject = new JSONObject(json);
        // 从resultData中获取JSONArray数组
        JSONArray jsonArray = jsonObject.getJSONArray("resultData");
        // 遍历数组，将数据插入数据库
        for (int i = 0; i < jsonArray.length(); i++) {
            // 建立json对象
            JSONObject ticket = jsonArray.getJSONObject(i);
            // 建立ticket对象
            Ticket t = new Ticket();
            Random random = new Random(27);
            if (!ticket.isNull("name") && !"".equals(ticket.getString("name"))) {
                t.setName(ticket.getString("name"));
            }

            if (!ticket.isNull("price")) {
                t.setPrice((float)ticket.getDouble("price"));
            }

            t.setMerchantid(merchantid);

            String showtime = ticket.getString("showtime").replaceAll("-", ".");
            if (!ticket.isNull("showtime") && !"".equals(ticket.getString("showtime")) && Character.isDigit(showtime.charAt(0))&& Character.isDigit(showtime.charAt(1))&& Character.isDigit(showtime.charAt(2))&& Character.isDigit(showtime.charAt(3)) && !isChinese(showtime.substring(0,9))) {
                int firstDot = showtime.indexOf('.');
                int secondDot = showtime.indexOf('.', firstDot+1);
                int year = Integer.parseInt(showtime.substring(0, firstDot));
                int month = Integer.parseInt(showtime.substring(firstDot+1, secondDot));
                int day = 01;
                if (showtime.length()>9 && Character.isDigit(showtime.charAt(secondDot+2))){
                    day = Integer.parseInt(showtime.substring(secondDot+1, secondDot+3));
                } else {
                    day = Integer.parseInt(showtime.substring(secondDot+1, secondDot+2));
                }

                t.setEndTime(LocalDate.of(year, month, day));
                t.setStartTime(LocalDate.of(year, month, day));
            }

            t.setState(false);

            t.setCount(15432);

            t.setAudit(true);

            t.setClick(random.nextInt(1001));

            t.setPurchase(random.nextInt(101));

            if (!ticket.isNull("verticalPic") && !"".equals(ticket.getString("verticalPic"))) {
                t.setImg(ticket.getString("verticalPic"));
            }

            if (!ticket.isNull("actors") && !"".equals(ticket.getString("actors"))) {
                t.setActors(ticket.getString("actors"));
            }

            if (!ticket.isNull("categoryname") && !"".equals(ticket.getString("categoryname"))) {
                t.setCategoryname(ticket.getString("categoryname"));
            }

            if (!ticket.isNull("cityname") && !"".equals(ticket.getString("cityname"))) {
                t.setCityname(ticket.getString("cityname"));
            }

            if (!ticket.isNull("iseticket")) {
                t.setIseticket((ticket.getInt("iseticket") == 0) ? false : true);
            }

            if (!ticket.isNull("isgeneralagent")) {
                t.setIsgeneralagent(ticket.getInt("isgeneralagent") == 0 ? false : true);
            }

            if (!ticket.isNull("issuperticket")) {
                t.setIssuperticket(ticket.getInt("issuperticket") != 0);
            }

            if (!ticket.isNull("isxuanzuo")) {
                t.setIsxuanzuo(ticket.getInt("isxuanzuo") == 0 ? false : true);
            }

            if (!ticket.isNull("nameNoHtml") && !"".equals(ticket.getString("nameNoHtml"))) {
                t.setNamenohtml(ticket.getString("nameNoHtml"));
            }

            if (!ticket.isNull("pricehigh")) {
                t.setPricehigh((float)ticket.getDouble("pricehigh"));
            }

            if (!ticket.isNull("showstatus") && !"".equals(ticket.getString("showstatus"))) {
                t.setShowstatus(ticket.getString("showstatus"));
            }

            if (!ticket.isNull("showtag") && !"".equals(ticket.getString("showtag"))) {
                t.setShowtag(ticket.getString("showtag"));
            }

            if (!ticket.isNull("showtime") && !"".equals(ticket.getString("showtime"))) {
                t.setShowtime(ticket.getString("showtime"));
            }

            if (!ticket.isNull("subcategoryname") && !"".equals(ticket.getString("subcategoryname"))) {
                t.setSubcategoryname(ticket.getString("subcategoryname"));
            }

            if (!ticket.isNull("venue") && !"".equals(ticket.getString("venue"))) {
                t.setVenue(ticket.getString("venue"));
            }
            // 将数据插入数据库
            ticketMapper.insertSelective(t);
        }
    }

    /**
     *判断一个字符是否是中文
     */
    public static boolean isChinese(char c) {
        // 根据字节码判断
        return c >= 0x4E00 &&  c <= 0x9FA5;
    }

    /**
     *判断一个字符串是否含有中文
     */
    public static boolean isChinese(String str) {
        if (str == null) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (isChinese(c)) {
                // 有一个中文字符就返回
                return true;
            }
        }
        return false;
    }
}
