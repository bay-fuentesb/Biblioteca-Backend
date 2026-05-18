import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-prestamos-components',
  imports: [CommonModule, RouterLink],
  templateUrl: './prestamos-components.html',
  styleUrls: ['./prestamos-components.scss'],
})
export class PrestamosComponents {}
