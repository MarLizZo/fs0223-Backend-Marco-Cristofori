package com.controlloincendi.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controlloincendi.models.CustomResponse;
import com.controlloincendi.models.Sonda;
import com.controlloincendi.models.TeamPompieri;
import com.controlloincendi.models.Verbale;
import com.controlloincendi.repositories.TeamRepo;
import com.controlloincendi.repositories.VerbaleRepo;

@Service
public class MyService {

    @Autowired
    TeamRepo t_repo;
    @Autowired
    VerbaleRepo v_repo;

    public TeamPompieri getById(Long id) {
        return t_repo.existsById(id) ? t_repo.findById(id).get() : null;
    }

    public TeamPompieri saveTeam(TeamPompieri t) {
        return t_repo.existsByName(t.getName()) ? null : t_repo.save(t);
    }

    public TeamPompieri updateTeam(TeamPompieri t) {
        if (t_repo.existsById(t.getId())) {
            return t_repo.save(t);
        }
        return null;
    }

    public TeamPompieri setIntervento(TeamPompieri t, Boolean flag) {
        t.setBusy(false);
        return updateTeam(t);
    }

    public Verbale saveVerbale(Verbale v) {
        return v_repo.save(v);
    }

    public CustomResponse allertaVigili(Sonda s) {
        List<TeamPompieri> ls = t_repo.findByBusyFalseAndCity(s.getEdificio().getCity());
        if (!ls.isEmpty()) {
            TeamPompieri team = ls.get(0);
            Verbale verb = saveVerbale(Verbale.builder().livelloFumo(s.getLivelloFumo())
                    .date(LocalDate.now()).team(team).build());
            team.setBusy(true);
            updateTeam(team);

            String msg = "Team di pompieri " + team.getName() + " inviato all'edificio " + s.getEdificio().getName();
            System.out.println(msg);
            return new CustomResponse(msg, true, team, verb);
        } else {
            String msg = "Nessuna squadra di vigili del fuoco disponibile. E mo che famo?";
            System.out.println(msg);
            return new CustomResponse(msg, false, null, null);
        }
    }
}
