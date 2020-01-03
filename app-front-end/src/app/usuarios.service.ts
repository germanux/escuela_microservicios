import { Injectable } from '@angular/core';
import { Usuario } from './entidades/Usuario';
import { AlmacenLocalService } from './almacen-local.service';

@Injectable({
  providedIn: 'root'
})
export class UsuariosService {

  listaUsuario: Usuario[];

  constructor(public almSrv: AlmacenLocalService) {
    this.listaUsuario = [{
      id: 1, 
      nombre: "Pako", 
      email: "pak@em.com", 
      password: "123",
      idTemaPreferido: 1
    } ,  {
      id: 2, 
      nombre: "Choni", 
      email: "choni@em.com", 
      password: "1234",
      idTemaPreferido: 2
    }];

    this.listaUsuario = almSrv.leer("usuarios");
   } 
   public getTodosUsuarios(): Usuario[] {
     this.listaUsuario.push({
      id: this.listaUsuario.length, 
      nombre: "Pako Add " + this.listaUsuario.length, 
      email: "pak@em.com", 
      password: "123",
      idTemaPreferido: 1
    });
    //var textoJsonUsus = JSON.stringify(this.listaUsuario);
    //window.sessionStorage.setItem("usuarios", textoJsonUsus);
    this.almSrv.guardar("usuarios", this.listaUsuario);

    return this.listaUsuario;
   }
}
