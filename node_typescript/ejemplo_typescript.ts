var texto = "TypeScript es JavaScript";
console.log(texto);
texto = {};
texto["prop"] = "Con sus virtudes y defectos";
console.log(texto.prop);
class MiClase {
    private variableMiembro: number;
    public otraProp: string;

    constructor(num: number, op: string) {
        this.variableMiembro = num;
        this.otraProp = op;
    }
    metodo(argumento: any): void {  // Tiene el tipo any (cualquier cosa)
        console.log(`Valores: ${this.variableMiembro}, 
                                ${this.otraProp},
                                ${argumento}`);
    }
}
let elObj: MiClase = new MiClase("69", "A comer");
elObj.metodo("Pero ya");