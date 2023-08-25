package com.controlloincendi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controlloincendi.models.TeamPompieri;

public interface TeamRepo extends JpaRepository<TeamPompieri, Long> {

    public List<TeamPompieri> findByBusyFalseAndCity(String city);

    public boolean existsByName(String name);
}
