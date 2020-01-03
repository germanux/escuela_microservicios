import { Component, OnInit } from '@angular/core';
import { Usuario } from '../entidades/Usuario';

@Component({
  selector: 'app-registro-usuario',
  templateUrl: './registro-usuario.component.html',
  styleUrls: ['./registro-usuario.component.css']
})
export class RegistroUsuarioComponent implements OnInit {  
  variable = "EMPIEZA POR...";
  usuario: Usuario; //  = new Usuario();
  //
  constructor() {
    //.usuario =  new Usuario();
   }
  ngOnInit() {
    this.usuario = {
      nombre: "Nnnnn",
      password: "1234",
      email: "aaaaa@dfdfdf.com"
    }
  }
  enviarDatos() {
    this.usuario.password = this.password;
    console.log(this.usuario.nombre);
    console.log(this.usuario.email);
  }
  pulsar() {
    console.log(this.variable);
    this.variable = "OTRO VALOR";
  }
}
