package com.super223.controller;

import com.super223.model.RegisterForm;
import com.super223.model.User;
import com.super223.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 会员模块控制器
 * @author superz
 */
@Controller
@RequestMapping("User")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public String register(ModelMap map){
        RegisterForm form = new RegisterForm();
        map.put("form", form);
        return "user/zhuce";
    }

    @RequestMapping("/login")
    public String login(){

        return "user/denglu";
    }

    @RequestMapping("/addUser")
    public String addUser(RegisterForm form){
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
        return "shouye";
    }
}
