package com.example.junction.controller;

import com.example.junction.dto.MainDto;
import com.example.junction.entity.SsbExpect;
import com.example.junction.service.MainService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {


    private MainService mainService;

    public MainController(MainService mainService) { this.mainService = mainService; }

    @GetMapping("")
    public String main(Model model, @RequestParam HashMap<String, Object> map) throws Exception {

        return "main";
    }
    @ResponseBody
    @GetMapping("ssbExpect")
    public SsbExpect getSsbExpect(@RequestParam HashMap<String, Object> map) throws Exception {
        return mainService.getSsbExpect(map);
    }
    @ResponseBody
    @GetMapping("graph/map")
    public HashMap<String, Object> getGraphMapData(@RequestParam HashMap<String, Object> map) throws Exception {
        return mainService.getGraphMapData(map);
    }
    @ResponseBody
    @GetMapping("graph/line")
    public HashMap<String,Object> getGraphLineData(@RequestParam HashMap<String, Object> map) throws Exception {
        return mainService.getGraphLineData(map);
    }

    @ResponseBody
    @GetMapping("graph/getRhymeRhymeans")
    public HashMap<String, Object> getRhymeRhymeans(@RequestParam HashMap<String, Object> map) throws Exception {
        return mainService.getRhymeRhymeans(map);
    }
}
