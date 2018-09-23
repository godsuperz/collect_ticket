package com.super223.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author superz
 */
@Controller
public class BaseController {
    /**
     * 网站首页
     * @return 在templates中的模板
     */
    @GetMapping("/")
    public String index(){
        return "shouye";
    }
}
