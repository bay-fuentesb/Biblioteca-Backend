package com.multa.Multa.controller;


import org.springframework.beans.factory.annotation.Value; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multa.Multa.Model.request.BaseRequest; 

@RestController
@RequestMapping("/")
public class BaseController {

    @Value("${spring.application.name:microservicio-biblioteca}")
    private String nombreApp;

    @Value("${app.version:1.0.0}")
    private String versionApp;

    @GetMapping("")
    public BaseRequest baseController() {
    
        return new BaseRequest(nombreApp, versionApp);
    }
}