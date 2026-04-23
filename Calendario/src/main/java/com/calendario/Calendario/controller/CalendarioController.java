package com.calendario.Calendario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calendario.Calendario.Model.entities.Calendario;
import com.calendario.Calendario.service.CalendarioService;
import org.springframework.web.bind.annotation.GetMapping;



@RequestMapping("/calendario")
@RestController
public class CalendarioController {
    
    @Autowired
    private CalendarioService calendarioService;

    @GetMapping("")
    public List<Calendario> obtenerCalendario() {
        return calendarioService.obtenerCalendario();
    }
    
}
