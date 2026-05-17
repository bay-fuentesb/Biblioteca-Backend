package com.Libro.Libros.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Libro.Libros.Model.entities.Libro;

public interface LibroRepository extends JpaRepository<Libro, Integer> {
    
    List<Libro> findByIsbn(String isbn);
    
}
