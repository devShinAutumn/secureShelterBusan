package com.example.junction.entity;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("ripCrnt")
public class RipCrnt {
    private String beachCode;
    private String beachName;
    private String lon;
    private String lat;
    private String obsTime;
    private Float waveHeight;
    private Float wavePeriod;
    private Float airTemp;
    private Float waterTemp;
    private Float windSpeed;
    private String windDirect;
    private String score;
    private String scoreMsg;
}
