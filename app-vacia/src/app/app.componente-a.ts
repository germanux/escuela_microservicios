import { Component } from '@angular/core';

@Component({ 
    selector: 'app-comp-a',
    template: '<h2>Aquí estoy A</h2>'
})
export /*public*/ class AppComponenteA {
    contador = 0;

    ngOnInit() {
        this.contador = 7;
    }
    alPulsarBtn() {
        this.contador ++;
        console.log("Contador = " + this.contador);
    }
}