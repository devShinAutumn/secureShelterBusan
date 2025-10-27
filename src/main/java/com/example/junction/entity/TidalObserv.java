package com.example.junction.entity;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("tidalObserv")
public class TidalObserv {
    private String obsPostId;
    private String obsPostName;
    private String obsLat;
    private String obsLon;
    private String recordTime;
    private String windDir;
    private String windSpeed;
    private String windGust;
    private String airTemp;
    private String airPress;
    private String waterTemp;
    private String tideLevel;
    private String salinity;
    private String waveHight;
    private String currentDir;
    private String currentSpeed;
}
