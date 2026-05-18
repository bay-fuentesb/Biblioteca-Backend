package com.calendario.Calendario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calendario.Calendario.Model.entities.Calendario;
import com.calendario.Calendario.Model.request.CalendarioActualizarRequest;
import com.calendario.Calendario.Model.request.CalendarioRequest;
import com.calendario.Calendario.service.CalendarioService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;





@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/calendario")
@RestController
public class CalendarioController {
    
    @Autowired
    private CalendarioService calendarioService;

    @GetMapping("")
    public List<Calendario> obtenerCalendario() {
        return calendarioService.obtenerCalendario();
    }

    @GetMapping("/{idcalendario}")
    public Calendario obteneCalendarioporId(@PathVariable int idCalendario) {
        return calendarioService.obteneCalendarioporId(idCalendario);
    }
    

    @PostMapping("")
    public Calendario AgregarCalendario(@Valid @RequestBody CalendarioRequest calendarioRequest) {
        return calendarioService.AgregarCalendario(calendarioRequest);
    }    

    @PutMapping("")
    public Calendario actualizarCalendario(@Valid @RequestBody CalendarioActualizarRequest calendarioActualizarRequest) {
        return calendarioService.actualizarCalendario(calendarioActualizarRequest);
    }
    @DeleteMapping("/{idcalendario}")
    public String eliminarCalendario(@PathVariable int idCalendario) {
        return calendarioService.eliminarCalendario(idCalendario);
    }
}
