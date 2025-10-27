package com.example.junction.entity;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("obsAsosTim")
public class ObsAsosTim {
    private String time;
    private String mm;
}
