package RoutePlanner.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProcPolyLineController {
    @RequestMapping (value = "/test.action", method = {RequestMethod.POST })
    @ResponseBody
    public Object toJsPolyData() {
        String[] total = PolyLineController.tXY;
        Object res = DirectionsController.xyToPolyLine(total[0], total[1], total[2], total[3]);

        return res;
    }
}
