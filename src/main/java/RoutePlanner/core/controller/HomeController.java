package RoutePlanner.core.controller;

import RoutePlanner.core.controller.dao.DataPopAlgorithm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping("/Main")
    public String mainPage(Model model){
        String rData = "";

        DataPopAlgorithm pPop = new DataPopAlgorithm(); //play
        DataPopAlgorithm teriaPop = new DataPopAlgorithm(); //cafeteria
        DataPopAlgorithm cPop = new DataPopAlgorithm(); //cafe

        rData += pPop.playPop()+"||";
        rData += teriaPop.cafeteriaPop()+"||";
        rData += cPop.cafePop()+"||";

        model.addAttribute("data", rData);
        return "/main";
    }
}
