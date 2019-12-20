var texto = "TypeScript es JavaScript";
console.log(texto);
texto = {};
texto["prop"] = "Con sus virtudes y defectos";
console.log(texto.prop);
var MiClase = /** @class */ (function () {
    function MiClase(num, op) {
        this.variableMiembro = num;
        this.otraProp = op;
    }
    MiClase.prototype.metodo = function (argumento) {
        console.log("Valores: " + this.variableMiembro + ", \n                                " + this.otraProp + ",\n                                " + argumento);
    };
    return MiClase;
}());
var elObj = new MiClase("69", "A comer");
elObj.metodo("Pero ya");
