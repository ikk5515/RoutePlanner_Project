package RoutePlanner.core.controller;

import RoutePlanner.core.controller.dao.DataPopAlgorithm;
import RoutePlanner.core.controller.dao.PointDAO;
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
    public String mainPage(Model model) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sc = new StringBuilder();

        DataPopAlgorithm pPop = new DataPopAlgorithm(); //play
        DataPopAlgorithm pPop1 = new DataPopAlgorithm(); //play
        DataPopAlgorithm pPop2 = new DataPopAlgorithm(); //play
        DataPopAlgorithm teriaPop = new DataPopAlgorithm(); //cafeteria
        DataPopAlgorithm cPop = new DataPopAlgorithm(); //cafe


        sb.append(pPop.playPop()  + "===================>");
        sb.append(teriaPop.cafeteriaPop()  + "===================>");
        sb.append(cPop.cafePop()  + "===================>");
        sb.append(pPop1.playPop()  + "===================>");
//        sb.append(pPop2.playPop()  + "===================>");

//        sb.append(teriaPop.cafeteriaPop() + "===================>");


//        DataPopAlgorithm uPop = new DataPopAlgorithm();

//        sb.append(uPop.userPop());
        PointDAO.totalAddr = null;
        model.addAttribute("data", sb);

        return "/main";
    }
}
