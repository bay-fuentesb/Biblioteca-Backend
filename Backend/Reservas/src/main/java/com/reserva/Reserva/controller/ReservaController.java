package com.reserva.Reserva.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reserva.Reserva.Model.entities.Reserva;
import com.reserva.Reserva.Model.request.ReservaActualizadoRequest;
import com.reserva.Reserva.Model.request.ReservaRequest;
import com.reserva.Reserva.service.ReservaService;
import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/reservas")
@RestController
public class ReservaController {
    
    @Autowired
    private ReservaService reservaService;


    @GetMapping("")
    public List<Reserva> obtenerTodasReservas() {
        return reservaService.obtenerTodasReservas();
    }



    @PostMapping("")
    public Reserva crearReserva(@Valid @RequestBody ReservaRequest reservaRequest) {
        return reservaService.agregarReserva(reservaRequest);
    }

    @PutMapping("")
    public Reserva actualizarReserva(@Valid @RequestBody ReservaActualizadoRequest reservaActualizarRequest) {
        return reservaService.actualizarReserva(reservaActualizarRequest);
    }

 
    @DeleteMapping("/{idReserva}")
    public String eliminarReserva(@PathVariable int idReserva) {
        return reservaService.eliminarReserva(idReserva);
    }
}