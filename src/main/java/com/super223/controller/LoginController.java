package com.super223.controller;

import com.super223.model.RegisterForm;
import com.super223.model.User;
import com.super223.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author superz
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("User/register")
    public String register(ModelMap map){
        RegisterForm form = new RegisterForm();
        map.put("form", form);
        return "user/zhuce";
    }

    @RequestMapping(value = "User/login", method = RequestMethod.GET)
    public String login(){

        return "user/denglu";
    }

    @PostMapping("/loginVali")
    public String loginVali(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            HttpServletRequest request,
                            ModelMap map){
        if (!StringUtils.isEmptyOrWhitespace(username)) {
            User user = userService.getUserByUsername(username.trim());
            if (user.getPassword().equals(password.trim())) {
                request.getSession().setAttribute("username", username);
                request.getSession().getAttribute("username");
                map.put("username", username);
                return "shouye";
            } else {
                return "user/denglu";
            }
        } else {
            return "user/denglu";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        if (!StringUtils.isEmptyOrWhitespace((String) request.getSession().getAttribute("username"))){
            request.getSession().removeAttribute("username");
        }
        return "shouye";
    }

}
