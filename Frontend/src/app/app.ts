import { Component, signal } from '@angular/core';
import { RouterOutlet, RouterLink } from '@angular/router';
import { FooterComponents } from './pages/footer-components/footer-components';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, RouterLink, FooterComponents],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App {
  protected readonly title = signal('All For Read');
}
