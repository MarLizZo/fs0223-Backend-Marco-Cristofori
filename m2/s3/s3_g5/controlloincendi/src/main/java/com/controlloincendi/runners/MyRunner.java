package com.controlloincendi.runners;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.controlloincendi.models.TeamPompieri;
import com.controlloincendi.service.MyService;

@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    MyService svc;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(".. Running ..");
        List<TeamPompieri> lst = new ArrayList<TeamPompieri>();

        lst.add(TeamPompieri.builder().name("Guardiani della fenice").person_count(9).city("Roma").busy(false).build());

        lst.add(TeamPompieri.builder().name("Fuoco e fiamme").person_count(5).city("Frosinone").busy(false).build());

        lst.add(TeamPompieri.builder().name("Acquaroli").person_count(6).city("Viterbo").busy(false).build());

        lst.add(TeamPompieri.builder().name("Benzinari").person_count(5).city("Chieti").busy(false).build());

        lst.add(TeamPompieri.builder().name("Ghiaccioli").person_count(4).city("Latina").busy(false).build());

        lst.add(TeamPompieri.builder().name("Terrapiattisti").person_count(7).city("Milano").busy(false).build());

        lst.add(TeamPompieri.builder().name("Uaglioni del fuoco").person_count(8).city("Napoli").busy(false).build());

        lst.add(TeamPompieri.builder().name("Sicily in fire").person_count(6).city("Palermo").busy(false).build());

        lst.forEach(team -> svc.saveTeam(team));
    }
}
