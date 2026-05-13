import { Routes } from '@angular/router';
import { InicioComponents } from './pages/inicio-components/inicio-components';
import { CatalogoComponents } from './pages/catalogo-components/catalogo-components';
import { NotFoundComponents } from './pages/not-found-components/not-found-components';

export const routes: Routes = [

    {
        path: '',
        component: InicioComponents,
    },
    {
        path: 'catalogo',
        component: CatalogoComponents,
    },

    {
        path: '404',
        component: NotFoundComponents,
    }
];
