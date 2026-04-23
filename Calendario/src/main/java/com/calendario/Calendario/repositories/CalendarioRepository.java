package com.calendario.Calendario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.calendario.Calendario.Model.entities.Calendario;

public interface CalendarioRepository extends JpaRepository<Calendario, Integer> {
    
}
