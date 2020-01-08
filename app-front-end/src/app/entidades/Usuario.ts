export class Usuario {
    public id: number;
    public nombre: string;
    public email: string;
    public password: string;
    public idTemaPreferido: number;

    public constructor(usu?: Usuario) {
        if (arguments.length == 1) {
            this.id = usu.id;
            this.nombre = usu.nombre;
            
        } 
    }
}
