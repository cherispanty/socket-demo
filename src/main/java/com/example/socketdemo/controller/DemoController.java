package com.example.socketdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author linchong
 * @date 2020/9/10 13:36
 */
@Controller
public class DemoController {

    @GetMapping("/index")
    public String index(String clientId, ModelMap modelMap){
        modelMap.addAttribute("clientId",clientId);
        System.out.println(modelMap.get("clientId"));
        return "index";
    }
}
