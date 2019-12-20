import { Component, OnInit } from '@angular/core';
import { UsuariosService } from '../usuarios.service';
import { Usuario } from '../entidades/Usuario';

@Component({
  selector: 'app-lista-usuarios',
  templateUrl: './lista-usuarios.component.html',
  styleUrls: ['./lista-usuarios.component.css']
})
export class ListaUsuariosComponent implements OnInit {
  listaUsu: Usuario[];
  // Como UsuariosService es @Injectable, Angular lo instancia y lo 
  // pasa como argumento del constructor automáticamente. IoD
  // Inyeccion de Dependencias
  constructor(public srvUsu: UsuariosService) { }

  ngOnInit() {
    this.listaUsu = this.srvUsu.getTodosUsuarios();
  }
}
