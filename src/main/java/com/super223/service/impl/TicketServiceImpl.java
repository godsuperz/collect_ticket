package com.super223.service.impl;

import com.github.pagehelper.PageHelper;
import com.super223.mapper.CustomMapper;
import com.super223.mapper.HotwordMapper;
import com.super223.mapper.TicketMapper;
import com.super223.mapper.TypeMapper;
import com.super223.model.Hotword;
import com.super223.model.Ticket;
import com.super223.service.TicketService;
import com.super223.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;
import sun.misc.IOUtils;
import tk.mybatis.mapper.entity.Example;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

/**
 * 票务service实现类
 * @author superz
 */
@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketMapper ticketMapper;

    @Autowired
    private HotwordMapper hotwordMapper;

    @Autowired
    private CustomMapper customMapper;

    @Autowired
    private TypeMapper typeMapper;

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
            if (!ticket.isNull("showtime") && !"".equals(ticket.getString("showtime")) && Character.isDigit(showtime.charAt(0))&& Character.isDigit(showtime.charAt(1))&& Character.isDigit(showtime.charAt(2))&& Character.isDigit(showtime.charAt(3)) && !StringUtil.isChinese(showtime.substring(0,9))) {
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
            if (!ticket.isNull("projectid") && !"".equals(ticket.getString("projectid"))) {
                t.setProjectid(ticket.getString("projectid"));
            }
            if (!ticket.isNull("price_str") && !"".equals(ticket.getString("price_str"))) {
                t.setPriceStr(ticket.getString("price_str"));
            }
            // 将数据插入数据库
            ticketMapper.insertSelective(t);
        }
    }

    @Override
    public List<Ticket> getAllTicket(Integer page, Integer pageSize) {

        // 使用PageHelper进行分页
        PageHelper.startPage(page, pageSize);
        return ticketMapper.selectAll();
    }

    @Override
    public List<Ticket> getTicketByName(String name) {
        Example example = new Example(Ticket.class);
        Example.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmptyOrWhitespace(name)){
            criteria.andLike("name", "%" + name + "%");
        }

        List<Ticket> ticketList = ticketMapper.selectByExample(example);
        return ticketList;
    }

    @Override
    public List<Ticket> getTicketByCondition(Ticket ticket) {

        Example example = new Example(Ticket.class);
        Example.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmptyOrWhitespace(ticket.getName())) {
            criteria.andLike("name", "%" + ticket.getName() + "%");
        }
        if(!StringUtils.isEmptyOrWhitespace(ticket.getCityname())) {
            criteria.andEqualTo("cityname", ticket.getCityname());
        }
        if (!StringUtils.isEmptyOrWhitespace(ticket.getCategoryname())) {
            criteria.andEqualTo("categoryname", ticket.getCategoryname());
        }
        if (ticket.getStartTime() != null) {
            criteria.andLessThan("startTime", ticket.getStartTime());
            criteria.orEqualTo("startTime", null);
        }

        return ticketMapper.selectByExample(example);
    }

    @Override
    public List<Hotword> getHotWordByNum(Integer num) {
        PageHelper.startPage(1, num);
        Example example = new Example(Hotword.class);
        example.setOrderByClause("count desc");
        return hotwordMapper.selectByExample(example);
    }

    @Override
    public Hotword getHotWordByName(String name) {
        Example example = new Example(Hotword.class);
        Example.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmptyOrWhitespace(name)){
            criteria.andEqualTo("name", name);
        }

        return hotwordMapper.selectOneByExample(example);
    }

    @Override
    public void addHotWord(Hotword hotword) {
        hotwordMapper.insert(hotword);
    }

    @Override
    public void updateHotWord(Hotword hotword) {
        hotwordMapper.updateByPrimaryKeySelective(hotword);
    }

    @Override
    public List<String> getAllCity() {
        return customMapper.getAllAddress();
    }

    @Override
    public List<String> getAllType() {
        return customMapper.getAllType();
    }

    @Override
    public List<Ticket> getTopByClick() {

        Example example = new Example(Ticket.class);
        example.setOrderByClause("click desc,purchase desc");

        return ticketMapper.selectByExample(example);
    }

    @Override
    public List<String> getCityByKeyWord(String key) {
        return customMapper.getCityByKeyWord(key);
    }

    @Override
    public List<String> getTypeByKeyWord(String key) {
        return customMapper.getTypeByKeyWord(key);
    }

}
