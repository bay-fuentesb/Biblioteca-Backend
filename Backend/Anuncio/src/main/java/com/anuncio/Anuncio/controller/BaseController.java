package com.anuncio.Anuncio.controller;


import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;


import com.anuncio.Anuncio.Model.request.BaseRequest;




@RestController
@RequestMapping("/")
public abstract class BaseController {


    @Value("${app.name}")
    private String nombreApp;

    @Value("${app.version}")
    private String versionApp;

    @GetMapping("")
    public BaseRequest baseController() {
        return new BaseRequest(nombreApp, versionApp);
    }
    
}