package com.controlloincendi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Sonda {
    private Long id;
    private String name;
    private Edificio edificio;
    private Integer livelloFumo;
}
