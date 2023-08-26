package com.incendi.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Verbale {
    private Long id;
    private Integer livelloFumo;
    private LocalDate date;
    private TeamPompieri team;
}
