package com.example.junction.external;



import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import com.google.gson.JsonObject;
import org.json.XML;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
/**
 * @author JHK
 * date : 2021. 5. 20.
 * description : HTTP 통신 핸들러 (POST)
 */
@Slf4j
@Service
public class HttpRequestHandler {

	/**
	 * @param map
	 * @return
	 * @throws Exception 
	 */

	public JSONObject sendHttpGetXML(String url, JsonObject map, String accessToken) throws Exception {
		StringBuffer rtnString = new StringBuffer();
		URL urlAsUrl;
		JSONObject resultJson = new JSONObject();
		String resultCd ="";
		String sRtnMsg = "";
		try {
			if (null == url || url.equals(""))	throw new ValidationException("INVALID HTTP REQUEST URL");
			urlAsUrl = new URL(url);
			URLConnection con = urlAsUrl.openConnection();
			HttpURLConnection hurlc = (HttpURLConnection) con;
			hurlc.setRequestMethod("GET");

			BufferedReader in;
			if (hurlc.getResponseCode() != 200) {
				in = new BufferedReader(new InputStreamReader(hurlc.getErrorStream(), "UTF-8"));
				resultCd = String.valueOf(hurlc.getResponseCode());
			} else {
				in = new BufferedReader(new InputStreamReader(hurlc.getInputStream(), "UTF-8"));
				resultCd = String.valueOf(hurlc.getResponseCode());
			}
			String inputLine = null;
			while ((inputLine = in.readLine()) != null) {
				rtnString.append(inputLine);
			}
			in.close();
			sRtnMsg = rtnString.toString();
			sRtnMsg = sRtnMsg.replaceAll("<mgmPmsrgstPk>", "<mgmPmsrgstPk>*");
			JSONParser parser = new JSONParser();
			org.json.JSONObject result = XML.toJSONObject(sRtnMsg);
			resultJson = (JSONObject) parser.parse(String.valueOf(result));
			log.info("HTTP REQUEST result : " + resultJson);
			resultJson.put("resultCd", resultCd);
		} catch (ValidationException e) {
			resultJson.put("resultCd", "400");
		} catch (IOException e) {
			resultJson.put("resultCd", "700");
		} catch (Exception e) {
			resultJson.put("resultCd", "900");
			e.printStackTrace();
		}
		//Api 로그 저장
		//saveApiLog(url, "POST", body, sRtnMsg, resultCd);
		return resultJson;
	}


}
