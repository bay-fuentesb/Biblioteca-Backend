package com.ejemplar.Ejemplar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemplar.Ejemplar.Model.entities.Ejemplar;

public interface EjemplarRepository extends JpaRepository<Ejemplar, Integer> {
    
}
