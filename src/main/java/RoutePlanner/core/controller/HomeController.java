package RoutePlanner.core.controller;

import RoutePlanner.core.controller.dao.DataPopAlgorithm;
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
    public String mainPage(Model model){
        StringBuilder sb = new StringBuilder();

        DataPopAlgorithm pPop = new DataPopAlgorithm(); //play
        DataPopAlgorithm teriaPop = new DataPopAlgorithm(); //cafeteria
        DataPopAlgorithm cPop = new DataPopAlgorithm(); //cafe

        sb.append(pPop.playPop());
        sb.append(teriaPop.cafeteriaPop());
        sb.append(cPop.cafePop());

        model.addAttribute("data", sb);
        return "/main";
    }
}
