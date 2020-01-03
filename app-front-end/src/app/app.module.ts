import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule }   from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListaUsuariosComponent } from './lista-usuarios/lista-usuarios.component';
import { RegistroUsuarioComponent } from './registro-usuario/registro-usuario.component';

@NgModule({
  declarations: [
    AppComponent,
    ListaUsuariosComponent,
    RegistroUsuarioComponent  // Los servicios por defecto
                            // son singleton
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,  // Para poder usar HTTP en toda la app
    FormsModule // Para poder usar el sistema de formularios
              // (Por ejemplo double-data-binding [(ngModel)]
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
