package com.ejemplar.Ejemplar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.server.ResponseStatusException;

import com.ejemplar.Ejemplar.Model.dto.EjemplarDto;
import com.ejemplar.Ejemplar.Model.entities.Ejemplar;
import com.ejemplar.Ejemplar.Model.request.EjemplarRequest;
import com.ejemplar.Ejemplar.Model.request.EjemplarActualizarRequest;

import com.ejemplar.Ejemplar.repositories.EjemplarRepository;

@Service
public class EjemplarService {
    
    @Autowired
    private EjemplarRepository ejemplarRepo;

    @Autowired
    private WebClient webClient;    

    public Ejemplar obtenerEjemplarPorId(int id) {
        return ejemplarRepo.findById(id).orElse(null);
    }

    public List<Ejemplar> ObtenerEjemplares() {
        return ejemplarRepo.findAll();
    }

    public Ejemplar AgregarEjemplar(EjemplarRequest ejemplarNuevo) {
        EjemplarDto codigo = null;

        try{
            codigo = webClient.get()
                .uri("ejemplares/codigo", ejemplarNuevo.getCodigo())
                .retrieve()
                .bodyToMono(EjemplarDto.class)
                .block();
        }catch (WebClientResponseException e) {
            throw new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode().value()),
            "Error al obtener la marca: " + e.getStatusText());
        } catch(Exception e){
            throw new ResponseStatusException(
                HttpStatus.SERVICE_UNAVAILABLE,
                "Error de conexion con el servicio de marca: " + e.getMessage());
        }
        Ejemplar ejemplar = new Ejemplar();
        ejemplar.setCodigo_ejemplar(ejemplarNuevo.getCodigo());
        ejemplar.setEstado_fisico(ejemplarNuevo.getEstadoFisico());
        ejemplar.setUbicacion_fisica(ejemplarNuevo.getUbicacionFisica());

        return ejemplarRepo.save(ejemplar);
    }


    public Ejemplar actualizarEjemplar (EjemplarActualizarRequest ejemplarEditado) {
        Ejemplar ejemplarExiste = ejemplarRepo.findById(ejemplarEditado.getId_ejemplar())
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ejemplar no encontrado"));
        if (ejemplarExiste == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vehiculo no encontrado.");
        }
        ejemplarExiste.setCodigo_ejemplar(ejemplarEditado.getCodigo());
        ejemplarExiste.setEstado_fisico(ejemplarEditado.getEstadoFisico());
        ejemplarExiste.setUbicacion_fisica(ejemplarEditado.getUbicacionFisica());

        return ejemplarRepo.save(ejemplarExiste);
    }

    public String eliminarEjemplar(int id_ejemplar) {
        Ejemplar ejemplarExiste = ejemplarRepo.findById(id_ejemplar).orElse(null);
        if (ejemplarExiste == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ejemplar no encontrado.");
        }
        ejemplarRepo.deleteById(id_ejemplar);
        return "Ejemplar eliminado exitosamente.";
    }
    
}
