package com.hunter.rain.user.controller;


import com.hunter.rain.framework.bean.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController extends BaseController {

    @GetMapping("/")
    @ResponseBody
    public String userIndex() {
        return "you win !";
    }
}

