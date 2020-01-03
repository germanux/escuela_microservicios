import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-registro-usuario',
  templateUrl: './registro-usuario.component.html',
  styleUrls: ['./registro-usuario.component.css']
})
export class RegistroUsuarioComponent implements OnInit {
  variable = "un valor";
  constructor() { }

  ngOnInit() {
  }
  pulsar() {
    this.variable = "OTRO VALOR";
  }
}
