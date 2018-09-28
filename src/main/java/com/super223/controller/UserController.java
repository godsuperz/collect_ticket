package com.super223.controller;

import com.super223.model.JSONResult;
import com.super223.model.RegisterForm;
import com.super223.model.Ticket;
import com.super223.model.User;
import com.super223.service.TicketService;
import com.super223.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * 会员模块控制器
 * @author superz
 */
@Controller
@RequestMapping("User")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TicketService ticketService;

    @RequestMapping("/addUser")
    public String addUser(RegisterForm form, HttpServletRequest request){
        if (!"".equals(form.getUsername().trim())){
            if (!"".equals(form.getEmail().trim())){
                if (!"".equals(form.getPassword().trim())){
                    if (!"".equals(form.getConfirmPassword().trim())){
                        if (form.getPassword().equals(form.getConfirmPassword())){
                            User user = new User();
                            user.setUsername(form.getUsername());
                            user.setEmail(form.getEmail());
                            user.setPassword(form.getPassword());
                            user.setAccount(0.00f);
                            user.setState(false);
                            userService.addUser(user);
                            request.getSession().setAttribute("username", form.getUsername());
                            return "redirect:/";
                        } else {
                            return "redirect:/User/register";
                        }
                    } else {
                        return "redirect:/User/register";
                    }
                } else {
                    return "redirect:/User/register";
                }
            } else {
                return "redirect:/User/register";
            }
        } else {
            return "redirect:/User/register";
        }
    }

    @PostMapping("/updateUser")
    public String updateUser(HttpServletRequest request, ModelMap map, @RequestParam("userid") Integer id,
                           @RequestParam("username") String username,
                           @RequestParam("useremail") String email,
                           @RequestParam("userphone") String phone,
                           @RequestParam("usergender") Integer sex,
                           @RequestParam("userbirthday") String birthday){

        System.out.println("username" + username);
        User user = new User();
        user.setId(id);
        user.setSex(sex);
        if (!StringUtils.isEmptyOrWhitespace(username)){
            user.setUsername(username);
        }
        if (!StringUtils.isEmptyOrWhitespace(email)){
            user.setEmail(email);
        }
        if (!StringUtils.isEmptyOrWhitespace(phone)){
            user.setPhone(phone);
        }
        if (!StringUtils.isEmptyOrWhitespace(birthday)){
            user.setBirthday(LocalDate.parse(birthday));
        }

        userService.updateUser(user);
        return "redirect:/User/myprofile";
    }

    @RequestMapping("/myprofile")
    public String myprofile(HttpServletRequest request, ModelMap map){
        String username = (String) request.getSession().getAttribute("username");
        if (!StringUtils.isEmptyOrWhitespace(username)){
            map.put("username", username);
        } else {
            return "user/denglu";
        }
        User user = userService.getUserByUsername(username);
        map.put("user", user);
        return "user/myprofile";
    }

    @RequestMapping("/collectticket")
    @ResponseBody
    public JSONResult collectTicket(){
        return JSONResult.ok();
    }

    @RequestMapping("/mycollect")
    public String myCollect(HttpServletRequest request, ModelMap map){
        String username = (String) request.getSession().getAttribute("username");
        if (!StringUtils.isEmptyOrWhitespace(username)){
            map.put("username", username);
            List<Integer> ticketIdList = userService.getUserCollect(username);
            System.out.println("我的输出: "+ticketIdList);
            List<Ticket> ticketList = new ArrayList<>();
            for (Integer aTicketIdList : ticketIdList) {
                ticketList.add(ticketService.getTicketInfoById(aTicketIdList));
            }
            map.put("collectList", ticketList);
        } else {
            return "user/denglu";
        }
        return "user/mycollect";
    }

    /**
     * 我的订单
     * @param request request
     * @param map map
     * @return
     */
    @RequestMapping("/myorderlist")
    public String myOrderList(HttpServletRequest request, ModelMap map){
        String username = (String) request.getSession().getAttribute("username");
        if (!StringUtils.isEmptyOrWhitespace(username)){
            map.put("username", username);
        } else {
            map.put("username", null);
        }
        return "user/myorderlist";
    }

    /**
     * 获取用户收藏列表
     * @return 收藏列表
     */
    @RequestMapping("/getUserCollect")
    @ResponseBody
    public JSONResult getUserCollect(@RequestParam(value = "username", required = false) String username){
        if (!StringUtils.isEmptyOrWhitespace(username)) {
            List<Integer> collectList = userService.getUserCollect(username);
            return JSONResult.ok(collectList);
        }
        return JSONResult.ok();
    }

    @RequestMapping("/addCollect")
    public String addCollect(HttpServletRequest request,
                             @RequestParam("ticketid") Integer ticketid){
        String username = (String) request.getSession().getAttribute("username");
        User user = userService.getUserByUsername(username);
        System.out.println("我的输出 :" + user.getId() + "  "+ ticketid);
        userService.addCollect(user.getId(), ticketid);
        return "redirect:/User/mycollect";
    }

    @RequestMapping("/removeCollect")
    public String removeCollect(HttpServletRequest request,
                                @RequestParam("ticketid") Integer ticketid){

        String username = (String) request.getSession().getAttribute("username");
        User user = userService.getUserByUsername(username);
        System.out.println(user.getId());
        userService.removeCollect(user.getId(), ticketid);
        return "redirect:/User/mycollect";
    }
}
