
package com.espol.modelo.LugarPokemon;


 public abstract class LugarPokemon {
     // encapsulamiento de LugarPokemon
     protected String nombre;
     protected String codigo;
     protected String ciudad;

    public LugarPokemon(String nombre, String codigo, String ciudad) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.ciudad = ciudad;
    }
    public abstract void mostrarInformacion();

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getCiudad() {
        return ciudad;
    }
      
      
    
     
    
}
 