package com.example.junction.entity;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("ssbShelter")
public class SsbShelter {
    private String id;
    private String sidoName;
    private String sigunguName;
    private String remarks;
    private String shelNm;
    private String address;
    private String shelAv;
    private String lenth;
    private String shelDivType;
    private String seismic;
    private String height;
    private String manageGov;
    private String tel;
    private String dtRegt;
    private String delYn;
    private String lon;
    private String lat;
    private String population;
}
