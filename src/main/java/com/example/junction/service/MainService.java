package com.example.junction.service;


import com.example.junction.dto.MainDto;
import com.example.junction.entity.SsbExpect;
import com.example.junction.dto.CollectorDto;
import com.example.junction.external.HttpRequestHandler;

import com.example.junction.repository.MainRepository;
import com.google.gson.JsonObject;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.HashMap;
import java.util.List;

@Service
public class MainService {

    private MainRepository mainRepository;

    public MainService(MainRepository mainRepository) { this.mainRepository = mainRepository; }


    public SsbExpect getSsbExpect(HashMap<String, Object> map) throws Exception {
        return mainRepository.getSsbExpect(map);
    }
    public HashMap<String, Object> getGraphMapData(HashMap<String, Object> map) throws Exception {
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("ssbShelterData", mainRepository.getSsbShelter(map));
        resultMap.put("livingPopulation", mainRepository.getLivingPopulation(map));
        return resultMap;
    }
    public HashMap<String, Object> getGraphLineData(HashMap<String, Object> map) throws Exception {
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("ripCrntList", mainRepository.getRipCrnt(map));
        resultMap.put("tidalObservList", mainRepository.getTidalObserv(map));
        resultMap.put("obsAsosTimList", mainRepository.getObsAsosTim(map));
        return resultMap;
    }
    public HashMap<String, Object> getRhymeRhymeans(HashMap<String, Object> map) throws Exception {
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("rhymeRhymeansData", mainRepository.getRhymeRhymeans(map));
        return resultMap;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor={Exception.class})
    public int BusanRainfalldepthInfoService() throws Exception{
        Integer totalPageNum = 1;
        try {
            String strUrl = "http://apis.data.go.kr/6260000/BusanRainfalldepthInfoService/getRainfallInfo?serviceKey=Pcz3s%2FSAp1vpz9fEAiz%2BaNqizVbo1ZnADMtqdJW8dfWphWBVR63gnczI%2FmQocekDFGmvXLAUSiikmLHOtsQtYA%3D%3D&pageNo=1&numOfRows=25";
            JsonObject message = new JsonObject();
            HttpRequestHandler hrh = new HttpRequestHandler();

            JSONObject resultJson = hrh.sendHttpGetXML(strUrl, message,null);
            HashMap<String, Object> hm = (HashMap<String, Object>) ((HashMap<String, Object>) resultJson.get("response")).get("body");
            Integer totalCnt = Integer.valueOf(String.valueOf(hm.get("totalCount")));
            Integer totalPage = Integer.valueOf(totalCnt / 100) + 1;
            String items = String.valueOf(hm.get("items"));
            if (totalCnt > 0 && !items.equals(""))	{
                List<HashMap<String, Object>> list = new ArrayList<>();
                if (items.contains("[")) {
                    list = (List<HashMap<String, Object>>) ((HashMap<String, Object>) hm.get("items")).get("item");
                } else {
                    list.add((HashMap<String, Object>) ((HashMap<String, Object>) hm.get("items")).get("item"));
                }

                for (int i = 0; i<list.size(); i++) {
                    HashMap<String, Object> listEach = list.get(i);
					CollectorDto collectorDto = new CollectorDto();
                    collectorDto.setTimeDay(String.valueOf(listEach.get("timeDay")));
                    collectorDto.setLastRainDt(String.valueOf(listEach.get("lastRainDt")));
                    collectorDto.setLevel6(String.valueOf(listEach.get("level6")));
                    collectorDto.setAccRain(String.valueOf(listEach.get("accRain")));
                    collectorDto.setClientId(String.valueOf(listEach.get("clientId")));
                    collectorDto.setAccRainDt(String.valueOf(listEach.get("accRainDt")));
                    collectorDto.setClientName(String.valueOf(listEach.get("clientName")));
                    collectorDto.setLevel12(String.valueOf(listEach.get("level12")));
					mainRepository.insertBusanRainfalldepthInfo(collectorDto);
                }
            }
            totalPageNum = totalPage;
            //Thread.sleep(600);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new Exception(e);
        }
        return totalPageNum;
    }
}
