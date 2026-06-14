package com.ejemplar.Ejemplar.controller; // Cambiar al paquete de Ejemplar cuando lo copies allá

import org.springframework.beans.factory.annotation.Value; // ¡Faltaba esta importación crítica!
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplar.Ejemplar.Model.request.BaseRequest; 

@RestController
@RequestMapping("/")
public class BaseController {

    // Lee los valores definidos en tu application.properties
    @Value("${spring.application.name:microservicio-biblioteca}")
    private String nombreApp;

    // Puedes definir la versión aquí o dejar una por defecto si no existe en las propiedades
    @Value("${app.version:1.0.0}")
    private String versionApp;

    @GetMapping("")
    public BaseRequest baseController() {
        // Retorna el objeto con el nombre y versión del servicio en AWS
        return new BaseRequest(nombreApp, versionApp);
    }
}