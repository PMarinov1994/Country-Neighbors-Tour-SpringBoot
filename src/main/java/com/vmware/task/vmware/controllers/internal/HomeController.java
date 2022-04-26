package com.vmware.task.vmware.controllers.internal;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController
{
    @RequestMapping(value = "/")
    public String index()
    {
        return "index";
    }



    @RequestMapping(value = "/calculator")
    public String calculator(@AuthenticationPrincipal OAuth2User principal)
    {
        System.out.println(principal);
        
        return "calculator";
    }
}
