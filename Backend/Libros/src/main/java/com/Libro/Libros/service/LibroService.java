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



    public Libro obtenerLibroPorId(int idLibro) {
        return libroRepo.findById(idLibro).orElse(null);
    }

    public List<Libro> obtenerTodosLibros() {
        return libroRepo.findAll();
    }

    public Libro AgregarLibro(LibroRequest libroNuevo) {
       
        Libro libro = new Libro();
        libro.setTitulo(libroNuevo.getTitulo());
        libro.setIsbn(libroNuevo.getIsbn());
        libro.setAnno_publicacion(libroNuevo.getAnno_publicacion());
        libro.setDescripcion(libroNuevo.getDescripcion());
        
        return libroRepo.save(libro);
    }

    public Libro actualizaLibro(LibroActualizarRequest libroEditado){
        Libro libroExiste = libroRepo.findById(libroEditado.getId_libro()).orElse(null);
        if (libroExiste == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Libro no encontrado con ID: " + libroEditado.getId_libro());
        }
        libroExiste.setTitulo(libroEditado.getTitulo());
        libroExiste.setIsbn(libroEditado.getIsbn());
        libroExiste.setAnno_publicacion(libroEditado.getAnno_publicacion());
        libroExiste.setDescripcion(libroEditado.getDescripcion());
        return libroRepo.save(libroExiste);
    }

    public String eliminarLibro(int idLibro) {
        Libro libroExiste = libroRepo.findById(idLibro).orElse(null);
        if (libroExiste == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Libro no encontrado con ID: " + idLibro);
        }
        libroRepo.deleteById(idLibro);
        return "Libro eliminado con éxito";
    }
}