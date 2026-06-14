package com.multa.Multa.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.multa.Multa.Model.entities.Multas;
import com.multa.Multa.Model.request.MultaActualizadoRequest;
import com.multa.Multa.Model.request.MultaRequest;
import com.multa.Multa.repositories.MultasRepository;

@Service
public class MultaService {

    @Autowired 
    private MultasRepository multasRepository;


    public List<Multas> obtenerTodasLasMultas() {
        return multasRepository.findAll();
    }

    public Multas obtenerMultasPorId(int id_multa) {
        Multas multa = multasRepository.findById(id_multa).orElse(null);
        if (multa == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Multa no encontrada con ID: " + id_multa);
        }
        return multa;
    }

    public Multas agregarMulta(MultaRequest nuevaMulta) {

        Multas multas = new Multas();
        multas.setIdMulta(nuevaMulta.getIdMulta());
        multas.setIdUsuario(nuevaMulta.getIdUsuario());
        multas.setMotivo(nuevaMulta.getMotivoMulta());
        multas.setMonto(nuevaMulta.getMontoMulta());
        multas.setFechaEmision(nuevaMulta.getFechaEmision());
        multas.setEstado(nuevaMulta.getEstadoMulta());
        
        return multasRepository.save(multas);
    }

    public Multas actualizarMulta(MultaActualizadoRequest multaEditada) {
        Multas multaExiste = multasRepository.findById(multaEditada.getIdMulta()).orElse(null);
        if (multaExiste == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Multa no encontrada con ID: " + multaEditada.getIdMulta());
        }
        
        multaExiste.setMotivo(multaEditada.getMotivoMulta());
        multaExiste.setMonto(multaEditada.getMontoMulta());
        multaExiste.setFechaEmision(multaEditada.getFechaEmision());
        multaExiste.setEstado(multaEditada.getEstadoMulta());
        
        return multasRepository.save(multaExiste);
    }

    public String eliminarMulta(int id_multa) {
        Multas multaExiste = multasRepository.findById(id_multa).orElse(null);
        if (multaExiste == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Multa no encontrada con ID: " + id_multa);
        }
        multasRepository.delete(multaExiste);
        return "Multa eliminada correctamente con ID: " + id_multa;
    }
}