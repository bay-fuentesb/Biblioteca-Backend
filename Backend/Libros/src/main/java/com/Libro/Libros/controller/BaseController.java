package com.Libro.Libros.controller; // Cambiar al paquete de Ejemplar cuando lo copies allá

import org.springframework.beans.factory.annotation.Value; // ¡Faltaba esta importación crítica!
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Libro.Libros.Model.request.BaseRequest; 

@RestController
@RequestMapping("/")
public class BaseController {

    @Value("${app.nombre:Mi Aplicación}")
    private String nombreApp;

  
    @Value("${app.version:1.0.0}")
    private String versionApp;

    @GetMapping("")
    public BaseRequest baseController() {
 
        return new BaseRequest(nombreApp, versionApp);
    }
}