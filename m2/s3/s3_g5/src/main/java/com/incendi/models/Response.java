package com.incendi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    private String message;
    private Boolean intervento;
    private TeamPompieri team;
    private Verbale varbale;
}
