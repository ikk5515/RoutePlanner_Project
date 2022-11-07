package RoutePlanner.core.controller;

import RoutePlanner.core.domain.member.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/Main")
    public String mainPage(Model model) {
        String hello = "HELLO";
        model.addAttribute("data", hello);
        return "/main";
    }
}
