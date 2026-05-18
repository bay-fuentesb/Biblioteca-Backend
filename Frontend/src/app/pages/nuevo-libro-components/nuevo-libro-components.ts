import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { LibrosServices } from '../../services/libro-services';

@Component({
  selector: 'app-nuevo-libro-components',
  imports: [CommonModule, FormsModule, RouterLink],
  templateUrl: './nuevo-libro-components.html',
  styleUrls: ['./nuevo-libro-components.scss'],
})
export class NuevoLibroComponents {
  private router = inject(Router);
  private libroService = inject(LibrosServices);

  titulo = '';
  isbn = '';
  descripcion = '';
  anno_publicacion = 0;
  mensaje = '';
  error = '';

  async crearLibro() {
    this.mensaje = '';
    this.error = '';

    if (!this.titulo || !this.isbn || !this.descripcion || !this.anno_publicacion) {
      this.error = 'Por favor completa todos los campos antes de guardar.';
      return;
    }

    try {
      await this.libroService.crearLibro({
        titulo: this.titulo,
        isbn: this.isbn,
        descripcion: this.descripcion,
        anno_publicacion: this.anno_publicacion,
      });
      this.mensaje = 'Libro creado correctamente.';
      await this.router.navigateByUrl('/libros');
    } catch (err) {
      console.error(err);
      this.error = 'Ocurrió un error al crear el libro. Revisa el backend.';
    }
  }
}
