import { Component, inject, OnInit } from '@angular/core';
import { LibrosServices } from '../../services/libro-services';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-inicio-components',
  imports: [FormsModule],
  templateUrl: './inicio-components.html',
  styleUrl: './inicio-components.scss',
})
export class InicioComponents implements OnInit {

  private libroService = inject(LibrosServices)
  
  ngOnInit() {
    console.table    
  }
}
