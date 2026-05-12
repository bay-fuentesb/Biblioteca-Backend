import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { lastValueFrom } from 'rxjs';
import { Libro2 } from '../models/Libro';
import { environment } from '../../environments/environment.development';

@Injectable({
  providedIn: 'root',
})
export class LibrosServices {
  private http = inject(HttpClient)
  
  async obtenerLibros(){
    return await lastValueFrom(this.http.get<Libro2>(environment.urlLibro));
  }
}
