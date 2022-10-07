package RoutePlanner.core.controller;

import RoutePlanner.core.domain.member.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/index")
    public String home() {
        return "index";
    }

    @GetMapping("/Login")
    public String loginHome() {
        return "/members/home";
    }
}
