package com.ejemplar.Ejemplar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplar.Ejemplar.Model.entities.Ejemplar;
import com.ejemplar.Ejemplar.Model.request.EjemplarActualizarRequest;
import com.ejemplar.Ejemplar.Model.request.EjemplarRequest;
import com.ejemplar.Ejemplar.service.EjemplarService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/ejemplares")
@RestController
public class EjemplarController {
    
    @Autowired
    private EjemplarService ejemplarService;
    
    @GetMapping("")
    public List<Ejemplar> getEjemplares() {
        return ejemplarService.ObtenerEjemplares();
    }

    @GetMapping("/{id_ejemplar}")
    public Ejemplar getEjemplar(@PathVariable int id_ejemplar) {
        return ejemplarService.obtenerEjemplarPorId(id_ejemplar);
    }
    
    @PostMapping("")
    public Ejemplar agregarEjemplar(@RequestBody EjemplarRequest ejemplarNuevo){
        return ejemplarService.AgregarEjemplar(ejemplarNuevo);
    }
    
    @PutMapping("")
    public Ejemplar actualizarEjemplar(@RequestBody EjemplarActualizarRequest ejemplarActualizar){
        return ejemplarService.actualizarEjemplar(ejemplarActualizar);
    }

    @DeleteMapping("/{id_ejemplar}")
    public String eliminarEjemplar(@PathVariable int id_ejemplar) {
        return ejemplarService.eliminarEjemplar(id_ejemplar);
    }
}
