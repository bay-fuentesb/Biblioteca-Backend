import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { lastValueFrom } from 'rxjs';
import { environment } from '../../environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class PrestamoServices {
  private http = inject(HttpClient);

  async crearPrestamo(nuevoPrestamo: any) {
    return await lastValueFrom(this.http.post<any>(environment.urlPrestamo, nuevoPrestamo));
  }

  // placeholder for other prestamo methods
}
