package RoutePlanner.core.Service.DAO;

import RoutePlanner.core.Service.VO.CafeVO;
import RoutePlanner.core.Service.VO.CafeteriaVO;
import RoutePlanner.core.Service.VO.PlayVO;
import RoutePlanner.core.Service.VO.surveyVO;

import java.util.*;

public class DataPopAlgorithm {
    StringBuilder sb = new StringBuilder();
    public StringBuilder playPop() {
        PointDAO pData = new PointDAO();

        ArrayList<PlayVO> pList = pData.playAllData();

        for(int i=0; i<pList.size(); i++) {
            PlayVO pvo = pList.get(i);
            sb.append(pvo.getPlayno() + ",");
            sb.append(pvo.getPlaykind() + ",");
            sb.append(pvo.getPlaywhat() + ",");
            sb.append(pvo.getPlayname() + ",");
            sb.append(pvo.getPlayaddr() + ",");
            sb.append(pvo.getPlaygroup() + "\n");
        }
        return sb;
    }

    public StringBuilder cafeteriaPop(){
        PointDAO ctData = new PointDAO();

        ArrayList<CafeteriaVO> ctList = ctData.cafeteriaAllData();

        for(int i=0; i<ctList.size(); i++){
            CafeteriaVO cteriavo = ctList.get(i);
            sb.append(cteriavo.getRestno() + ",");
            sb.append(cteriavo.getRestfrom() + ",");
            sb.append(cteriavo.getRestname() + ",");
            sb.append(cteriavo.getRestmenu() + ",");
            sb.append(cteriavo.getRestaddr() + ",");
            sb.append(cteriavo.getRestgroup() + "\n");
        }
        return sb;
    }

    public StringBuilder cafePop(){
        PointDAO cData = new PointDAO();

        ArrayList<CafeVO> cList = cData.cafeAllData();

        for(int i=0; i<cList.size(); i++){
            CafeVO cfvo = cList.get(i);
            sb.append(cfvo.getCafeno() + ",");
            sb.append(cfvo.getCafefrom() + ",");
            sb.append(cfvo.getCafename() + ",");
            sb.append(cfvo.getCafekind() + ",");
            sb.append(cfvo.getCafemenu() + ",");
            sb.append(cfvo.getCafeaddr() + "\n");
        }
        return sb;
    }
}