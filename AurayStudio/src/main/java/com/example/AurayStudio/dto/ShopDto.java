package com.example.AurayStudio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ShopDto {
    private int id;
    private String shop;
    private double lat;
    private double lng;
    private String description;
}
