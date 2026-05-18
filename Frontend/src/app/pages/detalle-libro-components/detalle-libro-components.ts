import { Component, inject, OnInit } from '@angular/core';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';
import { LibrosServices } from '../../services/libro-services';
import { Libro2 } from '../../models/Libro';

@Component({
  selector: 'app-detalle-libro-components',
  imports: [CommonModule, RouterLink],
  templateUrl: './detalle-libro-components.html',
  styleUrls: ['./detalle-libro-components.scss'],
})
export class DetalleLibroComponents implements OnInit {
  private route = inject(ActivatedRoute);
  private libroService = inject(LibrosServices);

  libro?: Libro2;
  cargando = true;
  error = '';

  async ngOnInit() {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    if (!id) {
      this.error = 'ID de libro inválido';
      this.cargando = false;
      return;
    }

    try {
      this.libro = await this.libroService.obtenerLibro(id);
    } catch (err) {
      console.error(err);
      this.error = 'No se encontró el libro o el servidor no está disponible.';
    } finally {
      this.cargando = false;
    }
  }
}
