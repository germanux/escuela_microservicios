import { Component } from '@angular/core';

@Component({ 
    selector: 'app-comp-raiz',
    template: '<h2>Aquí estoy</h2>'
})
export /*public*/ class AppComponente {
    contador = 0;

    ngOnInit() {
        this.contador = 7;
    }
    alPulsarBtn() {
        this.contador ++;
        console.log("Contador = " + this.contador);
    }
}