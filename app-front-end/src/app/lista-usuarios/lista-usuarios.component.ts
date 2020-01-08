import { Component, OnInit } from '@angular/core';
import { UsuariosService } from '../usuarios.service';
import { Usuario } from '../entidades/Usuario';
import { UsuariosRestService } from '../usuarios-rest.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-lista-usuarios',
  templateUrl: './lista-usuarios.component.html',
  styleUrls: ['./lista-usuarios.component.css']
})
export class ListaUsuariosComponent implements OnInit {
  listaUsu: Usuario[];
  public srvUsu: UsuariosRestService;

  // Como UsuariosService es @Injectable, Angular lo instancia y lo 
  // pasa como argumento del constructor automáticamente. IoD
  // Inyeccion de Dependencias. Esto es como el @Autowire
  constructor(srvUsu: UsuariosRestService) {
    this.srvUsu = srvUsu;
  }

  // Importa que esté o no el método para capturar el evento,
  // independienmente de la interfaz
  ngOnInit() {
    let observableConDatos: Observable<Usuario[]> = this.srvUsu.getTodos();
    // Le decimos al objeto observable que cuando reciba datos,
    // invoque a esta fun callback:
    observableConDatos.subscribe( datos =>  this.listaUsu = datos  );

    let subscriptor =  function(datos) {
      let textoJSON = JSON.stringify(datos);
      console.log(textoJSON);

    };
    observableConDatos.subscribe( subscriptor );

    // Hasta que no nos suscribimos, no hace petición alguna  
  }
  
  eliminar(id: number) {
    this.srvUsu.eliminar(id).subscribe(() => {
      alert(`Usuario con id ${id} eliminado`);
      this.ngOnInit();
    });
  }
}
