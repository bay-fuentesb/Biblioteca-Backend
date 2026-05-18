package com.reserva.Reserva.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.casosemestral.MultaService;

import org.springframework.web.bind.annotation.GetMapping;

@RequestMapping("/Multas")
@RestController
public class MultasController {
    
    @Autowired
    private MultaService reservaService;

  
}
