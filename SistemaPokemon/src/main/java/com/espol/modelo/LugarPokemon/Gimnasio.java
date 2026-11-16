
package com.espol.modelo.LugarPokemon;
//Herencia de la clase Lugar pokemon 

import com.espol.modelo.pokemon.*;
import com.espol.modelo.LugarPokemon.Registros.RegistroBatallla;
import java.time.LocalDate;


public class Gimnasio extends LugarPokemon {
    private String lider;//Variable de instancia 
    private String medalla;// Variable de instancia 
    private static int contador = 0; // Variable de instancia que nos ayudar a contar el numero de gimnasio 
    

    public Gimnasio(String nombre, String ciudad, String lider, String medalla) { // constructor de la Clase Gimnasio 
        super(nombre, "GYM" + (++contador), ciudad);// Llamado de las variable instancia de lo 
        this.lider = lider;
        this.medalla = medalla;
    }
    
    
    /**
    * Registra una batalla realizada en este gimnasio.
    *
    * @param pokemon Pokemon que participo.
    * @param resultado Victoria o Derrota.
    */
    public void registrarBatalla(Pokemon pokemon, String resultado) {

        RegistroBatallla registro = new RegistroBatallla(LocalDate.now(), pokemon, this, resultado);
        registro.mostrarRegistro();
}
    
    
    
    
    
    
     @Override
     public void mostrarInformacion(){
         System.out.println("---GIMNASIO POKEMON---");
         System.out.println("Código: " + codigo);
         System.out.println("Nombre: " + nombre);
         System.out.println("Ciudad: " + ciudad);
         System.out.println("Líder: " + lider);
         System.out.println("Tipo de Medalla: " + medalla);
         System.out.println("------------------------");
    }

    public String getLider() {
        return lider;
    }

    public String getMedalla() {
        return medalla;
    }
         
     }
     
    
    
    
