package com.anuncio.Anuncio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anuncio.Anuncio.Model.entities.Anuncio;

public interface AnuncioRepository extends JpaRepository<Anuncio, Integer> {

    List<Anuncio> findByFechaExacta(String fechaExacta);
    
}
