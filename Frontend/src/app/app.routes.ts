import { Routes } from '@angular/router';
import { InicioComponents } from './pages/inicio-components/inicio-components';
import { CatalogoComponents } from './pages/catalogo-components/catalogo-components';
import { DetalleLibroComponents } from './pages/detalle-libro-components/detalle-libro-components';
import { NuevoLibroComponents } from './pages/nuevo-libro-components/nuevo-libro-components';
import { AutoresComponents } from './pages/autores-components/autores-components';
import { PrestamosComponents } from './pages/prestamos-components/prestamos-components';
import { ReportesComponents } from './pages/reportes-components/reportes-components';
import { LoginComponent } from './pages/login-component/login-component';
import { NotFoundComponents } from './pages/not-found-components/not-found-components';

export const routes: Routes = [
  {
    path: '',
    component: InicioComponents,
  },
  {
    path: 'libros',
    component: CatalogoComponents,
  },
  {
    path: 'libros/nuevo',
    component: NuevoLibroComponents,
  },
  {
    path: 'libros/:id',
    component: DetalleLibroComponents,
  },
  {
    path: 'autores',
    component: AutoresComponents,
  },
  {
    path: 'prestamos',
    component: PrestamosComponents,
  },
  {
    path: 'reportes',
    component: ReportesComponents,
  },
  {
    path: 'login',
    component: LoginComponent,
  },
  {
    path: 'catalogo',
    component: CatalogoComponents,
  },
  {
    path: '404',
    component: NotFoundComponents,
  },
  {
    path: '**',
    redirectTo: '404',
  },
];
