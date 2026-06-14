package com.multa.Multa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.multa.Multa.Model.entities.Multas;

public interface MultasRepository extends JpaRepository<Multas, Integer> {

    List<Multas> findByMotivo(String motivoMulta);
}
