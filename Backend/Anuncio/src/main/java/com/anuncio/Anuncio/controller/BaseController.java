package com.anuncio.Anuncio.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

// Quitamos el @RestController de aquí porque esta clase es abstracta y no se instancia directamente
public abstract class BaseController<T, ID> {

    // En lugar de inyectar un servicio específico, definiremos un método abstracto
    // para que el controlador hijo provea su propio servicio.
    protected abstract Object getService();

    // Aquí puedes programar los endpoints genéricos que compartirán todos tus controladores
    // Por ejemplo, un validador de salud rápido como el que tenías en la Automotora:
    @GetMapping("/status")
    public String status() {
        return "Microservicio activo y respondiendo correctamente";
    }
}