package RoutePlanner.core.controller.dao;

import java.util.*;

public class DataPopAlgorithm {
    String requestData = "";
    public String playPop() {
        PointDAO pData = new PointDAO();

        ArrayList<PlayVO> pList = pData.playAllData();

        for(int i=0; i<pList.size(); i++) {
            PlayVO pvo = pList.get(i);
            requestData += pvo.getPlayno() + ",";
            requestData += pvo.getPlaykind() + ",";
            requestData += pvo.getPlaywhat() + ",";
            requestData += pvo.getPlayname() + ",";
            requestData += pvo.getPlayaddr() + ",";
            requestData += pvo.getPlaygroup() + "\n";
        }
        return requestData;
    }

    public String cafeteriaPop(){
        PointDAO ctData = new PointDAO();

        ArrayList<CafeteriaVO> ctList = ctData.cafeteriaAllData();

        for(int i=0; i<ctList.size(); i++){
            CafeteriaVO cteriavo = ctList.get(i);
            requestData += cteriavo.getRestno() + ",";
            requestData += cteriavo.getRestfrom() + ",";
            requestData += cteriavo.getRestname() + ",";
            requestData += cteriavo.getRestmenu() + ",";
            requestData += cteriavo.getRestaddr() + ",";
            requestData += cteriavo.getRestgroup() + "\n";
        }
        return requestData;
    }

    public String cafePop(){
        PointDAO cData = new PointDAO();

        ArrayList<CafeVO> cList = cData.cafeAllData();

        for(int i=0; i<cList.size(); i++){
            CafeVO cfvo = cList.get(i);
            requestData += cfvo.getCafeno() + ",";
            requestData += cfvo.getCafefrom() + ",";
            requestData += cfvo.getCafename() + ",";
            requestData += cfvo.getCafekind() + ",";
            requestData += cfvo.getCafemenu() + ",";
            requestData += cfvo.getCafeaddr() + "\n";
        }
        return requestData;
    }
}