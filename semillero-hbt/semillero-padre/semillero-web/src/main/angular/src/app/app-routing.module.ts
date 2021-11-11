import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { GestionarComicComponent } from './semillero/componentes/gestionarComic/gestionar-comic/gestionar-comic.component';
import { BienvenidaComponent } from './semillero/componentes/home/bienvenida-component';
import { GestionComicActualizarComponent } from './semillero/componentes/gestion-comic-actualizar/gestion-comic-actualizar.component'
import { BuscarComicComponent } from './semillero/componentes/buscar-comic/buscar-comic.component';
import { ComprarComicComponent } from './semillero/componentes/comprar-comic/comprar-comic.component';
const routes: Routes = [
  { path: 'bienvenida', component: BienvenidaComponent, data : null },
  { path: 'gestionar-comic', component: GestionarComicComponent,data:null },
  { path: 'gestion-comic-actualizar', component: GestionComicActualizarComponent, data: null},
  {path: 'buscar-comic', component: BuscarComicComponent},
  {path: 'comprar-comic', component:ComprarComicComponent, data: null}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
