package com.incendi.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Edificio {
    private Long id;
    private String name;
    private String city;
    private String address;
    private String latitude;
    private String longitude;
}
