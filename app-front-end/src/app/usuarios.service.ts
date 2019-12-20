import { Injectable } from '@angular/core';
import { Usuario } from './entidades/Usuario';

@Injectable({
  providedIn: 'root'
})
export class UsuariosService {
  listaUsuario: Usuario[];
  constructor() {
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
   } 
   public getTodosUsuarios(): Usuario[] {
    return this.listaUsuario;
   }
}
