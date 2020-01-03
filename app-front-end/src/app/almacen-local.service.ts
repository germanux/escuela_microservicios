import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AlmacenLocalService {

  constructor() { }

  public guardar(nombre: string, objDatos: any): void {

    var textoJsonUsus = JSON.stringify(objDatos);
    window.localStorage.setItem(nombre, textoJsonUsus);
  }
  public leer(nombre: string): any {

    let ususGuardados = window.localStorage.getItem(nombre);
    if (ususGuardados != null) {
      let objDatos = JSON.parse(ususGuardados);
      return objDatos;
    }
  }
}
