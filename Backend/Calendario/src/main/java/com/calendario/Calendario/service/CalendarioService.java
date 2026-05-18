package com.calendario.Calendario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.server.ResponseStatusException;

import com.calendario.Calendario.Model.dto.CalendarioDto;
import com.calendario.Calendario.Model.entities.Calendario;
import com.calendario.Calendario.Model.request.CalendarioActualizarRequest;
import com.calendario.Calendario.Model.request.CalendarioRequest;
import com.calendario.Calendario.repositories.CalendarioRepository;

@Service
public class CalendarioService {
    
    @Autowired
    private CalendarioRepository calendarioRepo;

    @Autowired
    private WebClient webClient;  

    public Calendario obteneCalendarioporId(int idCalendario) {
        return calendarioRepo.findById(idCalendario).orElse(null);
    }

    public List<Calendario> obtenerCalendario() {
        return calendarioRepo.findAll();
    }

    public Calendario AgregarCalendario(CalendarioRequest nuevoCalendario) {
        CalendarioDto fecha = null;
        try {
            fecha = webClient.get()
                    .uri("calendario/fecha", nuevoCalendario.getFecha_exacta())
                    .retrieve()
                    .bodyToMono(CalendarioDto.class)
                    .block();
        } catch (WebClientResponseException e) {
            throw new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode().value()),
            "Error al obtener la fecha: " + e.getResponseBodyAsString());
        }catch(Exception e){
            throw new ResponseStatusException(
                HttpStatus.SERVICE_UNAVAILABLE,
                "Error al agregar la fecha: " + e.getMessage());
        }
        Calendario calendario = new Calendario();
        calendario.setFecha_exacta(nuevoCalendario.getFecha_exacta());
        calendario.setMotivo(nuevoCalendario.getMotivo());
        calendario.setHora_inicio(nuevoCalendario.getHora_inicio());
        return calendario;
    }

    public Calendario actualizarCalendario(CalendarioActualizarRequest calendarioEditado){
        Calendario calendarioexiste = calendarioRepo.findById(calendarioEditado.getId_calendario()).orElse(null);
        if (calendarioexiste == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Calendario no encontrado");
        }
        calendarioexiste.setFecha_exacta(calendarioEditado.getFecha_exacta());
        calendarioexiste.setMotivo(calendarioEditado.getMotivo());
        calendarioexiste.setHora_inicio(calendarioEditado.getHora_inicio());
        return calendarioRepo.save(calendarioexiste);
    }

    public String eliminarCalendario(int idCalendario){
        Calendario calendarioexiste = calendarioRepo.findById(idCalendario).orElse(null);
        if (calendarioexiste == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Calendario no encontrado");
        }
        calendarioRepo.deleteById(idCalendario);
        return "Calendario eliminado correctamente";
    }
}
