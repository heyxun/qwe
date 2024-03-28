package com.smart.water.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {
    @GetMapping("page")
    public String page(Model model){
        model.addAttribute("msg","扬大");
        return "test/index";
    }
}
