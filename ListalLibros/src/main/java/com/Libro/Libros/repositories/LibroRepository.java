package com.libro.Libros.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libro.Libros.Model.entities.Libro;

public interface LibroRepository extends JpaRepository<Libro, Integer> {
    
}
