package com.anuncio.Anuncio.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.anuncio.Anuncio.Model.entities.Anuncio;
import com.anuncio.Anuncio.Model.request.AnuncioActualizarRequest;
import com.anuncio.Anuncio.Model.request.AnuncioRequest;
import com.anuncio.Anuncio.service.AnuncioService;
import jakarta.validation.Valid;

@CrossOrigin(origins = "*") // Permite peticiones de tu frontend hacia la EC2 sin bloqueos de CORS
@RequestMapping("/calendario")
@RestController
public class AnuncioController extends BaseController<Anuncio, Integer> {
    
    @Autowired
    private AnuncioService anuncioService;

    // Implementamos el método obligatorio del BaseController
    @Override
    protected AnuncioService getService() {
        return this.anuncioService;
    }

    // --- Endpoints Específicos del Dominio de Anuncios ---

    @GetMapping("")
    public List<Anuncio> obtenerCalendario() {
        return anuncioService.obtenerAnuncio();
    }

    @GetMapping("/{idAnuncio}")
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

    @DeleteMapping("/{idCalendario}")
    public String eliminarCalendario(@PathVariable int idCalendario) {
        return anuncioService.eliminaranuncio(idCalendario);
    }
}