import { ChangeDetectorRef, Component, inject, OnInit, signal } from '@angular/core';
import { LibrosServices } from '../../services/libro-services';
import { FormsModule } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { Libro, Libro2 } from '../../models/Libro';
import { CommonModule } from '@angular/common';
 
@Component({
  selector: 'app-inicio-components',
  imports: [FormsModule, CommonModule, RouterLink],
  templateUrl: './inicio-components.html',
  styleUrls: ['./inicio-components.scss'],
})
export class InicioComponents implements OnInit {
 
  private libroService = inject(LibrosServices);
  private cdr = inject(ChangeDetectorRef);
  private router = inject(Router);
 
  // Campos del formulario
  titulo: string = '';
  isbn: string = '';
  descripcion: string = '';
  anno_publicacion: number = 0;
 
  // Datos cargados desde la API
  libros2: any[] = [];
 
  // Signal para lista reactiva
  librosSignal = signal<Libro[]>([]);
 
  ngOnInit() {
    console.table(this.librosEjemplo);
    this.cargarLibros();
  }
 
  editar(libro: Libro2) {
    console.log('MÉTODO EDITAR ->', libro);
    this.router.navigateByUrl('editar/' + libro.id_libro);
  }
 
  async eliminar(id_libro: number) {
    console.log('MÉTODO ELIMINAR ->', id_libro);
    // this.libroService.eliminarLibro(id_libro);
    await this.cargarLibros();
  }
 
  async crearLibro() {
    const req = await this.libroService.crearLibro({
      titulo: this.titulo,
      isbn: this.isbn,
      descripcion: this.descripcion,
      anno_publicacion: this.anno_publicacion,
    });
    console.log('Libro creado:', req);
    await this.cargarLibros();
  }
 
  async cargarLibros() {
    const req = await this.libroService.obtenerLibros();
    this.libros2 = req;
    console.log('LIBROS PROPIEDAD:', this.libros2);
    this.cdr.detectChanges();
  }
 
  // Datos de ejemplo estáticos
  librosEjemplo: Libro[] = [
    {
      id_libro: 1,
      titulo: 'El Señor de los Anillos',
      isbn: '978-0544003415',
      descripcion: 'Una épica historia de fantasía escrita por J.R.R. Tolkien.',
      anno_publicacion: 1954,
    },
    {
      id_libro: 2,
      titulo: 'Cien Años de Soledad',
      isbn: '978-0307474728',
      descripcion: 'La obra maestra de Gabriel García Márquez.',
      anno_publicacion: 1967,
    },
  ];
}