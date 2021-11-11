import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule} from '@angular/http';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { APP_BASE_HREF } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { MenuComponent } from './semillero/componentes/menu/menu-component';
import { BienvenidaComponent } from './semillero/componentes/home/bienvenida-component';
import { GestionarComicComponent } from './semillero/componentes/gestionarComic/gestionar-comic/gestionar-comic.component';
import { GestionComicActualizarComponent } from './semillero/componentes/gestion-comic-actualizar/gestion-comic-actualizar.component';
import { BuscarComicComponent } from './semillero/componentes/buscar-comic/buscar-comic.component';
import { ComprarComicComponent } from './semillero/componentes/comprar-comic/comprar-comic.component';
//import { GestionarComicComponent } from './semillero/componentes/gestionarComic/gestionar-comic';

// DTOs
//export { ComicDTO } from './semillero/dto/comic.dto';
//export { ResultadoDTO } from './semillero/dto/resultado.dto';

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    BienvenidaComponent,
    GestionarComicComponent,
    GestionComicActualizarComponent,
    BuscarComicComponent,
    ComprarComicComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [
  	{ provide: APP_BASE_HREF, useValue: '/SemilleroHBT' }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { 

}
