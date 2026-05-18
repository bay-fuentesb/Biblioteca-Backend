import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { PrestamoServices } from '../../services/prestamo-services';

@Component({
  selector: 'app-prestamos-components',
  imports: [CommonModule, FormsModule],
  templateUrl: './prestamos-components.html',
  styleUrls: ['./prestamos-components.scss'],
})
export class PrestamosComponents {
  private router = inject(Router);
  private prestamoService = inject(PrestamoServices);

  // form state
  mostrarFormulario = false;
  id_libro: number | null = null;
  usuario = '';
  fecha_devolucion = '';

  mensaje = '';
  error = '';
  createdPrestamo: any = null;

  toggleFormulario() {
    this.mostrarFormulario = !this.mostrarFormulario;
    this.mensaje = '';
    this.error = '';
  }

  async crearPrestamo() {
    this.mensaje = '';
    this.error = '';
    this.createdPrestamo = null;

    if (!this.id_libro || !this.usuario || !this.fecha_devolucion) {
      this.error = 'Por favor completa todos los campos para crear el préstamo.';
      return;
    }

    try {
      const prestamoCreado = await this.prestamoService.crearPrestamo({
        id_libro: this.id_libro,
        usuario: this.usuario,
        fecha_devolucion: this.fecha_devolucion,
      });

      this.createdPrestamo = prestamoCreado;
      this.mensaje = '¡Préstamo creado correctamente!';
      this.mostrarFormulario = false;
      this.id_libro = null;
      this.usuario = '';
      this.fecha_devolucion = '';
      await this.router.navigateByUrl('/prestamos');
    } catch (err) {
      console.error(err);
      this.error = 'No se pudo crear el préstamo. Revisa el backend y vuelve a intentarlo.';
    }
  }
}
