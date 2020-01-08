import { Component, OnInit } from '@angular/core';
import { Usuario } from '../entidades/Usuario';
import { UsuariosRestService } from '../usuarios-rest.service';

@Component({
  selector: 'app-registro-usuario',
  templateUrl: './registro-usuario.component.html',
  styleUrls: ['./registro-usuario.component.css']
})
export class RegistroUsuarioComponent implements OnInit {  
  variable = "EMPIEZA POR...";
  usuario: Usuario; //  = new Usuario();
  password: string = "123";
  estaRegistrado: boolean = false;

  // Otra vez IoD
  constructor(private usuSrv: UsuariosRestService) {
    this.usuario =  new Usuario();
   }
  ngOnInit() {
    /*this.usuario = {
		id: null,
      nombre: "Nnnnn",
      password: "1234",
      email: "aaaaa@dfdfdf.com",
    }*/
  }
  enviarDatos() {
    this.usuario.password = this.password;

    this.usuSrv.registro(this.usuario).subscribe((usuRecibido) => { 
      this.usuario = usuRecibido;      
      this.estaRegistrado = ( typeof this.usuario.id !== 'undefined');
     });

    console.log(this.usuario.nombre);
    console.log(this.usuario.email);
  }
  pulsar() {
    console.log(this.variable);
    this.variable = "OTRO VALOR";
  }
}
