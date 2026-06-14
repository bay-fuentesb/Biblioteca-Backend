package com.reserva.Reserva.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.reserva.Reserva.Model.entities.Reserva;
import com.reserva.Reserva.Model.request.ReservaActualizadoRequest;
import com.reserva.Reserva.Model.request.ReservaRequest;
import com.reserva.Reserva.repositories.ReservaRepository;

@Service
public class ReservaService {
    
    @Autowired
    private ReservaRepository reservaRepository;


    public Reserva obtenerReservaPorId(int id_Reserva) {
        return reservaRepository.findById(id_Reserva).orElse(null);
    }

    public List<Reserva> obtenerTodasReservas() {
        return reservaRepository.findAll();
    }

    public Reserva agregarReserva(ReservaRequest nuevaReserva) {

        Reserva reserva = new Reserva();
        reserva.setFecha_reserva(nuevaReserva.getFecha_reserva());
        reserva.setEstado_reserva(nuevaReserva.getEstado_reserva());
        
  

        return reservaRepository.save(reserva);
    }

  
    public Reserva actualizarReserva(ReservaActualizadoRequest reservaEditado) {
        Reserva reservaExiste = reservaRepository.findById(reservaEditado.getId_Reserva()).orElse(null);
        if (reservaExiste == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Reserva no encontrada con ID: " + reservaEditado.getId_Reserva());
        }
        
        reservaExiste.setFecha_reserva(reservaEditado.getFecha_reserva());
        reservaExiste.setEstado_reserva(reservaEditado.getEstado_reserva());
        
        return reservaRepository.save(reservaExiste);
    }


    public String eliminarReserva(int id_Reserva) {
        Reserva reservaExiste = reservaRepository.findById(id_Reserva).orElse(null);
        if (reservaExiste == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Reserva no encontrada con ID: " + id_Reserva);
        }
        
        reservaRepository.deleteById(id_Reserva);
        return "Reserva eliminada exitosamente";
    }
}