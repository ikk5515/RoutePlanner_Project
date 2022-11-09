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
        StringBuilder sb = new StringBuilder();

//      DataPopAlgorithm pPop = new DataPopAlgorithm(); //play
//      DataPopAlgorithm teriaPop = new DataPopAlgorithm(); //cafeteria
//      DataPopAlgorithm cPop = new DataPopAlgorithm(); //cafe
//
//      sb.append(pPop.playPop());
//      sb.append(teriaPop.cafeteriaPop());
//      sb.append(cPop.cafePop());

        DataPopAlgorithm uPop = new DataPopAlgorithm();

        sb.append(uPop.userPop());

        model.addAttribute("data", sb);
        return "/main";
    }
}
