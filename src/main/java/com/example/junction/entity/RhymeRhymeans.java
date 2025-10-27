package com.example.junction.entity;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("rhymeRhymeans")
public class RhymeRhymeans {
    private String rhymeDt;
    private String fullVolume;
    private String lwrmdCloud;

}
