package com.incendi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamPompieri {
    private Long id;
    private String name;
    private Integer person_count;
    private String city;
    private Boolean busy;
}
