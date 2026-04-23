package com.ejemplar.Ejemplar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplar.Ejemplar.Model.entities.Ejemplar;
import com.ejemplar.Ejemplar.repositories.EjemplarRepository;

@Service
public class EjemplarService {
    
    @Autowired
    private EjemplarRepository ejemplarRepo;

    public List<Ejemplar> ObtenerEjemplares() {
        return ejemplarRepo.findAll();
    }
}
