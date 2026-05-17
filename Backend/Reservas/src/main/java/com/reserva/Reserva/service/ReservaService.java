package com.reserva.Reserva.service;


import java.util.List;

import org.apache.tomcat.websocket.WsFrameClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.server.ResponseStatusException;

import com.reserva.Reserva.Model.dto.ReservaDto;
import com.reserva.Reserva.Model.entities.Reserva;
import com.reserva.Reserva.Model.request.ReservaActualizadoRequest;
import com.reserva.Reserva.Model.request.ReservaRequest;
import com.reserva.Reserva.repositories.ReservaRepository;

@Service
public class ReservaService {
    
    @Autowired
    private ReservaRepository reservaRepository;

    
    @Autowired
    private WebClient webClient;

    public Reserva obtenerReservaPorId(int id_Reserva) {
        return reservaRepository.findById(id_Reserva).orElse(null);
    }

    public List<Reserva> obtenerTodasReservas() {
        return reservaRepository.findAll();
    }

    public Reserva agregarReserva(ReservaRequest nuevaReserva){
        ReservaDto fecha = null;

        try {
            fecha = webClient.get()
            .uri("reserva/{idReserva}", nuevaReserva.getId_Reserva())
            .retrieve()
            .bodyToMono(ReservaDto.class)
            .block();
        }catch (WebClientResponseException e) {
            throw new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode().value()),
            "Error al obtener la reserva: " + e.getStatusText());
        } catch(Exception e){
            throw new ResponseStatusException(
                HttpStatus.SERVICE_UNAVAILABLE,
                "Error de conexion con el servicio de reserva: " + e.getMessage());
        }
        
        Reserva reserva = new Reserva();
        reserva.setFecha_reserva(nuevaReserva.getFecha_reserva());
        reserva.setEstado_reserva(nuevaReserva.getEstado_reserva());
        return reservaRepository.save(reserva);
    }

    public Reserva actualizarReserva(ReservaActualizadoRequest reservaEditado){
        Reserva reservaExiste = reservaRepository.findById(reservaEditado.getId_Reserva()).orElse(null);
        if(reservaExiste == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Reserva no encontrada");
        }
        reservaExiste.setFecha_reserva(reservaEditado.getFecha_reserva());
        reservaExiste.setEstado_reserva(reservaEditado.getEstado_reserva());
        return reservaRepository.save(reservaExiste);
    }

   public String eliminarReserva(int id_Reserva){
        Reserva reservaExiste = reservaRepository.findById(id_Reserva).orElse(null);
        if(reservaExiste == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Reserva no encontrada");
        }
        reservaRepository.deleteById(id_Reserva);
        return "Reserva eliminada exitosamente";
    }
}