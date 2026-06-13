package com.anuncio.Anuncio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anuncio.Anuncio.Model.entities.Anuncio;
import com.anuncio.Anuncio.Model.request.AnuncioActualizarRequest;
import com.anuncio.Anuncio.Model.request.AnuncioRequest;
import com.anuncio.Anuncio.service.AnuncioService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;






@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/calendario")
@RestController
public class AnuncioController {
    
    @Autowired
    private AnuncioService anuncioService;

    @GetMapping("")
    public List<Anuncio> obtenerCalendario() {
        return anuncioService.obtenerAnuncio();
    }

    @GetMapping("/{idanuncio}")
    public Anuncio obtenerAnuncioporId(@PathVariable int idAnuncio) {
        return anuncioService.obtenerAnuncioporId(idAnuncio);
    }
    

    @PostMapping("")
    public Anuncio AgregarCalendario(@Valid @RequestBody AnuncioRequest anuncioRequest) {
        return anuncioService.AgregarAnuncio(anuncioRequest);
    }    

    @PutMapping("")
    public Anuncio actualizarCalendario(@Valid @RequestBody AnuncioActualizarRequest anuncioActualizarRequest) {
        return anuncioService.actualizaranuncio(anuncioActualizarRequest);
    }
    @DeleteMapping("/{idcalendario}")
    public String eliminarCalendario(@PathVariable int idCalendario) {
        return anuncioService.eliminaranuncio(idCalendario);
    }
}
