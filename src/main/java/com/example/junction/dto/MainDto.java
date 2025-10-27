package com.example.junction.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("mainDto")
public class MainDto {
    private String mainDtoId;
}
