package com.calendario.Calendario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.calendario.Calendario.Model.entities.Calendario;
import com.calendario.Calendario.repositories.CalendarioRepository;

@Service
public class CalendarioService {
    
    @Autowired
    private CalendarioRepository calendarioRepo;

    public List<Calendario> obtenerCalendario() {
        return calendarioRepo.findAll();
    }
}
