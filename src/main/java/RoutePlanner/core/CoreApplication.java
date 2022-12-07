package RoutePlanner.core;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;


@SpringBootApplication
public class CoreApplication {

    public static void main(String[] args) {

		SpringApplication.run(CoreApplication.class, args);
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

			String response2 = response.toString();

			JSONParser parser = new JSONParser();
			try {

				JSONObject jsonObject = (JSONObject) parser.parse(response2);
//				System.out.println(response2);
				JSONObject jsonObject1 = (JSONObject) jsonObject.get("route");
				JSONArray array = (JSONArray) jsonObject1.get("traoptimal");
				JSONObject array1 = (JSONObject) array.get(0);
				System.out.println(array1.get("path"));

			} catch (Exception e) {
				e.printStackTrace();
			}

//			JSONParser jsonParser = new JSONParser();
//
//			JSONObject jsonObject = (JSONObject)jsonParser.parse(response2);
//			JSONObject route = (JSONObject) jsonObject.get("route");
//			JSONObject traoptimal = (JSONObject) route.get("traoptimal");
//
//			System.out.println(path);
//						System.out.println(response2);
		} catch (Exception var12) {
			System.out.println(var12);
		}
    }

}