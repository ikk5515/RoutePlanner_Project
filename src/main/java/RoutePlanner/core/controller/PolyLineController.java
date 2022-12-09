package RoutePlanner.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class PolyLineController {
    static String[] tXY;
    @RequestMapping(value="procPolyLine", method={RequestMethod.POST})
    @ResponseBody
    public static void srr(@RequestParam(value="result_x[]") ArrayList<Double> result_x, @RequestParam(value="result_y[]") ArrayList<Double> result_y) {
        String xData = result_x.toString();
        String yData = result_y.toString();

        String xp1 = xData.replace("[", "");
        xp1 = xp1.replace("]", "");
        String[] xp2 = xp1.split(",");

        String yp1 = yData.replace("[", "");
        yp1 = yp1.replace("]", "");
        String[] yp2 = yp1.split(",");

        String[] total = new String[4];

        for (int i=0; i< total.length; i++){
            total[i] = xp2[i] + "," + yp2[i];
        }

        tXY = total;
    }
}
