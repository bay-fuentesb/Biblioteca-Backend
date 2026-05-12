import { Component, inject, OnInit } from '@angular/core';
import { LibrosServices } from '../../services/libro-services';

@Component({
  selector: 'app-inicio-componets',
  imports: [],
  templateUrl: './inicio-componets.html',
  styleUrl: './inicio-componets.scss',
})
export class InicioComponets implements OnInit {

  private libroService = inject(LibrosServices)
  
  ngOnInit() {
    console.table    
  }
}
