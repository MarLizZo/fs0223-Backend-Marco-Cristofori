package com.controlloincendi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomResponse {
    private String message;
    private Boolean intervento;
    private TeamPompieri team;
    private Verbale verbale;
}
