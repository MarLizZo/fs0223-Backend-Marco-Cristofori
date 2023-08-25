package com.incendi.models;

import java.util.Observable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@SuppressWarnings("deprecation")
public class Sonda extends Observable {
    private Long id;
    private String name;
    private Edificio edificio;
    private Integer livelloFumo;

    public void setLivelloFumo(Integer livelloFumo) {
        this.livelloFumo = livelloFumo;
        setChanged();
        notifyObservers(this);
    }
}
