package RoutePlanner.core;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Directions {

    public static void main(String[] args) {
        String clientId = "echp7ietnz";
        String clientSecret = "TvwWk2a5zwXugw8FaIglU9UIgGiUepjUkOzsf9IT";
        String start = "126.8799922,37.4660208"; //우리집
        String goal = "126.9014944,37.4853149"; // 구로디지털단지
        String way = "126.8933034,37.4684444"; //독산동

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        try {
            String apiURL = "https://naveropenapi.apigw.ntruss.com/map-direction/v1/driving?start=" + start + "&goal=" + goal + "&waypoints=" + way + "&option={trafast}";
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
            System.out.println(response);
        } catch (Exception var12) {
            System.out.println(var12);
        }
    }
}