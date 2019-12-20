console.log("Mostrar mensaje");

// window.alert("No va a funcionar");

console.log(process.pid);
console.log("Ruta: " + process.cwd());
var unObjeto = new Object();
unObjeto.propiedadA = 'Valor A';
unObjeto["propiedadB"] = "Valor B";
unObjeto.metodo =  function() { return "unObjeto 1: " + this.propiedadA; };
var unObj2 = {
    "propiedadA": "Valor A",    // Formato JSON (JavaScript Object Notation)
    propiedadB: "Valor B",      // Sólo en JS permite sin comillas o ' simples
    'propiedadC': "Valor C",
    "metodo": function() { return "unObj2 : " + this.propiedadA; },
    "array": [2, "x", true]     // Un array en JS en como un ArrayList<Object> de Java
}
var ConstructorObj3 = function(argA, argB) {
    this.propiedadA = argA;
    this.propiedadB = argB;
    this.metodo = function() { return  'un Obj 3: ' + this.propiedadA};
}
var unObj3 = new ConstructorObj3("Valor A", "valor B");
console.log(unObjeto.metodo());
console.log(unObj2.metodo());
console.log(unObj3.metodo());

// Desde EcmaScript 6, ES2015
console.log(`Valor de A: ${unObjeto['propiedadA']}, 
             Valor de B:
             ${unObjeto.propiedadB}`);
// Funciones en JS son objetos
function fun1(parA, parB) {
    return "Resultado fun1: " + parA + ", " + parB;
}
// el ambito de var es a nivel de función. 
// El ámbito de let es anivel de bloque de { } (como en Java) 
let fun2 = function(parA, parB) {
    return `Resultado fun2: ${parA}, ${parB}`;
}
var fun3 = new Function("parA", "parB", "return `Resultado fun3: ${parA}, ${parB}`");
// Desde EcmaScript 6, ES2015. Funciones flecha, lambda, anónimas...
var fun4 = (parA, parB)  =>  { return "Resultado fun5: " + parA + ", " + parB};
var fun5 = (parA, parB) => `Resultado fun4: ${parA}, ${parB}`;
fun1.prop = "lo que sea";

console.log(fun1 ("argumento A" , "argumento B"));
console.log(fun2 ("argumento A" , "argumento B"));
console.log(fun3 ("argumento A" , "argumento B"));
console.log(fun4 ("argumento A" , "argumento B"));
console.log(fun5 ("argumento A" , "argumento B"));

function letVar() {
    if (true) {
        var variableVar = 10;
        let variableLet = 20;
    }
    console.log("variableVar = " + variableVar);
    console.log("variableLet = " + variableLet);
}
letVar();
