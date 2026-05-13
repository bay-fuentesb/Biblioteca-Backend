import { ChangeDetectorRef, Component, inject, OnInit } from '@angular/core';
import { LibrosServices } from '../../services/libro-services';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { Libro } from '../../models/Libro';

@Component({
  selector: 'app-inicio-components',
  imports: [FormsModule],
  templateUrl: './inicio-components.html',
  styleUrls: ['./inicio-components.scss'],
})
export class InicioComponents implements OnInit {

  private libroService = inject(LibrosServices);
  private cdr = inject(ChangeDetectorRef);
  private router = inject(Router);

  titulo: String = '';
  isbn: String = '';
  descripcion: String = '';
  anno_publicacion: number = 0;

  libros2: any[] = [];

  ngOnInit() {
    console.table    
  }

  async crearLibro() {
    const req = await this.libroService.crearLibro({
      titulo: this.titulo,
      isbn: this.isbn,
      descripcion: this.descripcion,
      anno_publicacion: this.anno_publicacion
    });

  }


libro: Libro[] = [
  {
    id_libro: 1,
    titulo: 'El Señor de los Anillos',
    isbn: '978-0544003415',
    descripcion: 'Una épica historia de fantasía escrita por J.R.R. Tolkien.',
    anno_publicacion: 1954
  }
]

}
