package RoutePlanner.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainpageController {

    @GetMapping("/index")
    public String home() {
        return "index";
    }
}
