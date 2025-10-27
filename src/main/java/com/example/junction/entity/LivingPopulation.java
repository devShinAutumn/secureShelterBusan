package com.example.junction.entity;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("livingPopulation")
public class LivingPopulation {
    private String stdYm;
    private String hCode;
    private String gName;
    private String hName;
    private String maleH;
    private String femaleH;
    private String age10H;
    private String age20H;
    private String age30H;
    private String age40H;
    private String age50H;
    private String age60H;
    private String age70H;
    private String maleW;
    private String femaleW;
    private String age10W;
    private String age20W;
    private String age30W;
    private String age40W;
    private String age50W;
    private String age60W;
    private String age70W;
    private String maleV;
    private String femaleV;
    private String age10V;
    private String age20V;
    private String age30V;
    private String age40V;
    private String age50V;
    private String age60V;
    private String age70V;
    private String sum;
}
