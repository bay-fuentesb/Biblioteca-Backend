package com.example.casosemestral.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.casosemestral.model.entities.Multas;




@Repository
public interface MultasRepository extends JpaRepository<Multas, Integer> {
    


}