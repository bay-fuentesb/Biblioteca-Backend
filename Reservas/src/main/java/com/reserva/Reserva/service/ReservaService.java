package com.reserva.Reserva.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reserva.Reserva.Model.entities.Reserva;
import com.reserva.Reserva.repositories.ReservaRepository;

@Service
public class ReservaService {
    
    @Autowired
    private ReservaRepository reservaRepository;

    public List<Reserva> ObtenerReservas() {
        return reservaRepository.findAll();
    }
}
