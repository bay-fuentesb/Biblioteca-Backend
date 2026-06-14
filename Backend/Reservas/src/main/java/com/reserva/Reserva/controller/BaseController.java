package com.reserva.Reserva.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.reserva.Reserva.Model.request.BaseRequest; 

@RestController
@RequestMapping("/")
public class BaseController {

    @Value("${spring.application.name:reservas}")
    private String nombreApp;

    @Value("${app.version:0.0.1-SNAPSHOT}")
    private String versionApp;

    @GetMapping("")
    public BaseRequest baseController() {
        return new BaseRequest(nombreApp, versionApp);
    }

    
}
