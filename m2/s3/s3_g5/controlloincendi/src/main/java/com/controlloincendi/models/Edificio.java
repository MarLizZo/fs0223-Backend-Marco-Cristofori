package com.controlloincendi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Edificio {
    private Long id;
    private String name;
    private String city;
    private String address;
    private String latitude;
    private String longitude;
}
