package com.multa.Multa.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.multa.Multa.Model.entities.Multas;
import com.multa.Multa.Model.request.MultaActualizadoRequest;
import com.multa.Multa.Model.request.MultaRequest;
import com.multa.Multa.service.MultaService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/multas") 
public class MultasController { 

    @Autowired
    private MultaService multaService;

    @GetMapping("")
    public List<Multas> obtenerTodas() {
        return multaService.obtenerTodasLasMultas();
    }

    @GetMapping("/{id}")
    public Multas obtenerPorId(@PathVariable("id") int id) {
        Multas multa = multaService.obtenerMultasPorId(id);
        if (multa == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Multa no encontrada con ID: " + id);
        }
        return multa;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Multas crearMulta(@Valid @RequestBody MultaRequest multaRequest) {
     
        return multaService.agregarMulta(multaRequest); 
    }

    @PutMapping("")
    public Multas actualizar(@Valid @RequestBody MultaActualizadoRequest multaEditada) {
        return multaService.actualizarMulta(multaEditada);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable("id") int id) {
        return multaService.eliminarMulta(id);
    }
}