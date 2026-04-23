package com.ejemplar.Ejemplar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplar.Ejemplar.Model.entities.Ejemplar;
import com.ejemplar.Ejemplar.service.EjemplarService;
import org.springframework.web.bind.annotation.GetMapping;



@RequestMapping("/ejemplares")
@RestController
public class EjemplarController {
    
    @Autowired
    private EjemplarService ejemplarService;
    
    @GetMapping("")
    public List<Ejemplar> getEjemplares() {
        return ejemplarService.ObtenerEjemplares();
    }
    
}
