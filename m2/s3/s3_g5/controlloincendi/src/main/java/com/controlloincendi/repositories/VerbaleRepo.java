package com.controlloincendi.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controlloincendi.models.Verbale;

public interface VerbaleRepo extends JpaRepository<Verbale, Long> {

    List<Verbale> getByDateBetween(LocalDate start, LocalDate end);
}
