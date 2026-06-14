import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { lastValueFrom } from 'rxjs';
import { Libro2 } from '../models/Libro';
import { environment } from '../../environments/environment.development';

@Injectable({
  providedIn: 'root',
})
export class LibrosServices {
  private http = inject(HttpClient);
  
  // 1. Obtener todos los libros
  async obtenerLibros(){
    return await lastValueFrom(this.http.get<Libro2[]>(environment.urlLibro));
  }

  // 2. Crear un libro nuevo
  async crearLibro(libroNuevo: bodyAgregarLibro){
    return await lastValueFrom(this.http.post<Libro2>(environment.urlLibro, libroNuevo));
  }

  // 3. Obtener un solo libro por ID
  async obtenerLibro(id_libro: number){
    return await lastValueFrom(this.http.get<Libro2>(`${environment.urlLibro}/${id_libro}`));
  }

  // 4. NUEVO: Actualizar un libro existente (Se conecta con el @PutMapping de Spring Boot)
  async actualizarLibro(libroEditado: any){
    return await lastValueFrom(this.http.put<Libro2>(environment.urlLibro, libroEditado));
  }

  // 5. NUEVO: Eliminar un libro (Se conecta con el @DeleteMapping("/{id}") de Spring Boot)
  async eliminarLibro(id_libro: number){
    return await lastValueFrom(this.http.delete<string>(`${environment.urlLibro}/${id_libro}`));
  }
}

interface bodyAgregarLibro {
  "titulo": String;
  "isbn": String;
  "descripcion": String;
  "anno_publicacion": number; // <-- Recuerda verificar que en Java se llame exactamente igual
}