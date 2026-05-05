package com.reserva.Reserva.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import com.reserva.Reserva.Model.entities.Reserva;
import com.reserva.Reserva.service.ReservaService;

@RequestMapping("/reservas")
@RestController
public class ReservaController {
    
    @Autowired
    private ReservaService reservaService;

    @GetMapping("")
    public List<Reserva> ObtenerReservas() {
        return reservaService.ObtenerReservas();
    }
}
