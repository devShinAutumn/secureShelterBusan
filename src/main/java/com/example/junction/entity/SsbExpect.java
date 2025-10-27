package com.example.junction.entity;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("ssbExpect")
public class SsbExpect {
    private String date;
    private String totalRate;
    private String earthquakeRate;
    private String mountainRate;
    private String sinkhallRate;
    private String shoreRate;

}
