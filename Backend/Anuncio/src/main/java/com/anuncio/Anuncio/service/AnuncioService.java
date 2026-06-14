package com.anuncio.Anuncio.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.server.ResponseStatusException;

import com.anuncio.Anuncio.Model.dto.AnuncioDto;
import com.anuncio.Anuncio.Model.entities.Anuncio;
import com.anuncio.Anuncio.Model.request.AnuncioActualizarRequest;
import com.anuncio.Anuncio.Model.request.AnuncioRequest;
import com.anuncio.Anuncio.repositories.AnuncioRepository;

@Service
public class AnuncioService {
    
    private final AnuncioRepository anuncioRepo;
    private final WebClient webClient;

    // Inyección por constructor limpia (Mala práctica eliminada: se quitaron los @Autowired duplicados)
    public AnuncioService(AnuncioRepository anuncioRepo, WebClient webClient) {
        this.anuncioRepo = anuncioRepo;
        this.webClient = webClient;
    }

    public Anuncio obtenerAnuncioporId(int idAnuncio) {
        return anuncioRepo.findById(idAnuncio).orElse(null);
    }

    public List<Anuncio> obtenerAnuncio() {
        return anuncioRepo.findAll();
    }

    public Anuncio AgregarAnuncio(AnuncioRequest nuevoAnuncio) {
        AnuncioDto fecha = null;
        try {
            // CORREGIDO: Se añadió la plantilla de variable "{fecha}" en la URI
            fecha = webClient.get()
                    .uri("anuncio/fecha/{fecha}", nuevoAnuncio.getFecha_exacta())
                    .retrieve()
                    .bodyToMono(AnuncioDto.class)
                    .block();
        } catch (WebClientResponseException e) {
            throw new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode().value()),
            "Error al obtener la fecha: " + e.getResponseBodyAsString());
        } catch(Exception e){
            throw new ResponseStatusException(
                HttpStatus.SERVICE_UNAVAILABLE,
                "Error al agregar la fecha: " + e.getMessage());
        }

        Anuncio anuncio = new Anuncio();
        anuncio.setFechaExacta(nuevoAnuncio.getFecha_exacta());
        anuncio.setMotivo(nuevoAnuncio.getMotivo());
        anuncio.setHora_inicio(nuevoAnuncio.getHora_inicio());
        
        // CORREGIDO CRÍTICO: ¡Ahora sí guardamos el registro en la base de datos MySQL!
        return anuncioRepo.save(anuncio); 
    }

    public Anuncio actualizaranuncio(AnuncioActualizarRequest anuncioEditado){
        Anuncio anuncioexiste = anuncioRepo.findById(anuncioEditado.getId_anuncio()).orElse(null);
        if (anuncioexiste == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "anuncio no encontrado");
        }
        anuncioexiste.setFechaExacta(anuncioEditado.getFecha_exacta());
        anuncioexiste.setMotivo(anuncioEditado.getMotivo());
        anuncioexiste.setHora_inicio(anuncioEditado.getHora_inicio());
        
        return anuncioRepo.save(anuncioexiste);
    }

    public String eliminaranuncio(int idAnuncio){
        Anuncio anuncioexiste = anuncioRepo.findById(idAnuncio).orElse(null);
        if (anuncioexiste == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "anuncio no encontrado");
        }
        anuncioRepo.deleteById(idAnuncio);
        return "anuncio eliminado correctamente";
    }
}