import { Component, inject, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { LibrosServices } from '../../services/libro-services';
import { Libro2 } from '../../models/Libro';

@Component({
  selector: 'app-catalogo-components',
  imports: [CommonModule, RouterLink],
  templateUrl: './catalogo-components.html',
  styleUrls: ['./catalogo-components.scss'],
})
export class CatalogoComponents implements OnInit {
  private libroService = inject(LibrosServices);

  libros: Libro2[] = [];
  cargando = true;
  error = '';

  async ngOnInit() {
    await this.cargarLibros();
  }

  async cargarLibros() {
    try {
      this.libros = await this.libroService.obtenerLibros();
    } catch (err) {
      console.error(err);
      this.error = 'No se pudo cargar el catálogo de libros. Verifica el backend.';
    } finally {
      this.cargando = false;
    }
  }
}
