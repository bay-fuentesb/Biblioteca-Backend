package com.anuncio.Anuncio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    
    @Autowired
    private  AnuncioRepository anuncioRepo;

    @Autowired
    private  WebClient webClient;

    public Anuncio obtenerAnuncioporId(int idAnuncio) {
        return anuncioRepo.findById(idAnuncio).orElse(null);
     }


     public List<Anuncio> obtenerAnuncio() {
        return anuncioRepo.findAll();
     }

     public Anuncio agregarAnuncio(AnuncioRequest anuncioNuevo){
        AnuncioDto anuncioDto = null;

        try {
            anuncioDto = webClient.get()
                    .uri("anuncio/{idAnuncio}", anuncioNuevo.getId_anuncio())
                    .retrieve()
                    .bodyToMono(AnuncioDto.class)
                    .block();
        }catch (WebClientResponseException e) {
            throw new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode().value()),
            "Error al obtener el anuncio: " + e.getStatusText());
     } catch(Exception e){
            throw new ResponseStatusException(
                HttpStatus.SERVICE_UNAVAILABLE,
                "Error de conexion con el servicio de anuncio: " + e.getMessage());
            }

        Anuncio anuncio = new Anuncio();
        anuncio.setId_anuncio(anuncioNuevo.getId_anuncio());
        anuncio.setFechaExacta(anuncioNuevo.getFecha_exacta());
        anuncio.setMotivo(anuncioNuevo.getMotivo());
        anuncio.setHora_inicio(anuncioNuevo.getHora_inicio());
        return anuncioRepo.save(anuncio);
        }

        public Anuncio actualizarAnuncio(AnuncioActualizarRequest anuncioEditado) {
           Anuncio anuncioExistente = anuncioRepo.findById(anuncioEditado.getId_anuncio()).orElse(null);
           if (anuncioExistente == null) {
               throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Anuncio no encontrado");
           }
           anuncioExistente.setFechaExacta(anuncioEditado.getFecha_exacta());
           anuncioExistente.setMotivo(anuncioEditado.getMotivo());
           anuncioExistente.setHora_inicio(anuncioEditado.getHora_inicio());

           return anuncioRepo.save(anuncioExistente);
        }

        public String eliminarAnuncio(int idAnuncio) {
            Anuncio anuncioExistente = anuncioRepo.findById(idAnuncio).orElse(null);
            if (anuncioExistente == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Anuncio no encontrado");
            }
            anuncioRepo.delete(anuncioExistente);
            return "Anuncio eliminado correctamente";
        }
    }