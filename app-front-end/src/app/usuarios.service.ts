import { Injectable } from '@angular/core';
import { Usuario } from './entidades/Usuario';

@Injectable({
  providedIn: 'root'
})
export class UsuariosService {
  listaUsuario: Usuario[];
  constructor() { }
  
}
