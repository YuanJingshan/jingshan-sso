package com.up.jingshan.client.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

/**
 * @author YuanJingshan
 * @version 1.fontawesome
 * @description
 * @date 2019/12/19
 */
@Controller
public class YYCController {

    @GetMapping("/index")
    public String list() {
        return "index";
    }

    @GetMapping("/info")
    @ResponseBody
    public Principal info(Principal principal) {
        return principal;
    }

    @GetMapping("/me")
    @ResponseBody
    public Authentication me(Authentication authentication) {
        authentication.getName();
        System.out.println(authentication);
        return authentication;
    }

}
