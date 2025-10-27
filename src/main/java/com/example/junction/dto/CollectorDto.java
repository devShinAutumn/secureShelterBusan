package com.example.junction.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Data
@Alias("collectorDto")
public class CollectorDto {

	private String timeDay;
	
	private String lastRainDt;

	private String level6;
	
	private String accRain;
	
	private String clientId;
	
	private String accRainDt;
	
	private String clientName;
	
	private String level12;
	

}
