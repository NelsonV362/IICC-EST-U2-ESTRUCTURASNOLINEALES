import { Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { TareaComponent } from './components/tarea/tarea.component';

export const routes: Routes = [
{ path: '', redirectTo: '/inicio', pathMatch: 'full' },
{ path: 'inicio', component: HomeComponent },
{ path: 'tarea', component: TareaComponent },

];