package com.Libro.Libros.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.Libro.Libros.Model.entities.Libro;
import com.Libro.Libros.Model.request.LibroActualizarRequest;
import com.Libro.Libros.Model.request.LibroRequest;
import com.Libro.Libros.repositories.LibroRepository;

@Service
public class LibroService {
    
    @Autowired
    private LibroRepository libroRepo;

    /**
     * Obtener todos los libros
     */
    public List<Libro> obtenerTodosLibros() {
        return libroRepo.findAll();
    }

    /**
     * Obtener un libro por ID
     */
    public Libro obtenerLibroPorId(int idLibro) {
        return libroRepo.findById(idLibro)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, 
                "Libro no encontrado con ID: " + idLibro));
    }

    /**
     * Crear un nuevo libro
     */
    public Libro crearLibro(LibroRequest libroRequest) {
        validarIsbnUnico(null, libroRequest.getIsbn());
        
        Libro libro = new Libro();
        libro.setTitulo(libroRequest.getTitulo());
        libro.setIsbn(libroRequest.getIsbn());
        libro.setAnno_publicacion(libroRequest.getAnno_publicacion());
        libro.setDescripcion(libroRequest.getDescripcion());
        
        return libroRepo.save(libro);
    }

    /**
     * Actualizar un libro existente
     */
    public Libro actualizarLibro(LibroActualizarRequest libroActualizarRequest) {
        Libro libroExistente = libroRepo.findById(libroActualizarRequest.getId_libro())
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, 
                "Libro no encontrado con ID: " + libroActualizarRequest.getId_libro()));

        // Validar que el ISBN sea único si cambió
        if (!libroExistente.getIsbn().equals(libroActualizarRequest.getIsbn())) {
            validarIsbnUnico(libroActualizarRequest.getId_libro(), libroActualizarRequest.getIsbn());
        }

        libroExistente.setTitulo(libroActualizarRequest.getTitulo());
        libroExistente.setIsbn(libroActualizarRequest.getIsbn());
        libroExistente.setAnno_publicacion(libroActualizarRequest.getAnno_publicacion());
        libroExistente.setDescripcion(libroActualizarRequest.getDescripcion());
        
        return libroRepo.save(libroExistente);
    }

    /**
     * Eliminar un libro
     */
    public String eliminarLibro(int idLibro) {
        Libro libroExistente = libroRepo.findById(idLibro).orElse(null);
        if (libroExistente == null) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, 
                "Libro no encontrado con ID: " + idLibro);
        }

        libroRepo.delete(libroExistente);
        return "Libro con ID " + idLibro + " eliminado exitosamente.";
    }

    /**
     * Validar que el ISBN sea único
     */
    private void validarIsbnUnico(Integer idLibroExcluir, String isbn) {
        // Si implementas un método findByIsbn en el repositorio
        // puedes verificar aquí que no exista otro libro con el mismo ISBN
        // Por ahora es un placeholder
    }
}