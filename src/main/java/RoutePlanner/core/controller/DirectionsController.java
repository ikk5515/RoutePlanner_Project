package RoutePlanner.core.controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DirectionsController {
    public static Object xyToPolyLine(String s, String g, String w1, String w2) {
        String clientId = "echp7ietnz";
        String clientSecret = "TvwWk2a5zwXugw8FaIglU9UIgGiUepjUkOzsf9IT";
        String start = s;
        String goal = g;
        String way1 = w1;
        String way2 = w2;

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        Object resArr = null;
        try {
            String apiURL = "https://naveropenapi.apigw.ntruss.com/map-direction/v1/driving?start=" + start + "&goal=" + goal + "&waypoints=" + way1 + "|" + way2 + "&option={trafast}";
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
            con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
            BufferedReader br;
            if (200 == con.getResponseCode()) { // 응답코드가 200(정상)이면 결과값을 br에 받아온다.
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }


            StringBuffer response = new StringBuffer();

            String inputLine;
            while((inputLine = br.readLine()) != null) { //받아올 값이 없을때까지 반복
                response.append(inputLine);
            }

            br.close();

            String response2 = response.toString();

            JSONParser parser = new JSONParser();
            try {
                JSONObject jsonObject = (JSONObject) parser.parse(response2);
                JSONObject jsonObject1 = (JSONObject) jsonObject.get("route");
                JSONArray array = (JSONArray) jsonObject1.get("traoptimal");
                JSONObject array1 = (JSONObject) array.get(0);
                resArr = array1.get("path");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resArr;
    }
}