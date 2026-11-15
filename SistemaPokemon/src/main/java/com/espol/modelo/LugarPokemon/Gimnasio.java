
package com.espol.modelo.LugarPokemon;
//Herencia de la clase Lugar pokemon 

import com.espol.modelo.LugarPokemon.LugarPokemon;

public class Gimnasio extends LugarPokemon {
    private String lider;//Variable de instancia 
    private String medalla;// Variable de instancia 
    private static int contador = 0; // Variable de instancia que nos ayudar a contar el numero de gimnasio 
    

    public Gimnasio(String lider, String medalla, String nombre, String ciudad) { // constructor de la Clase Gimnasio 
        super(nombre, ciudad, "GYM" + (++contador));// Llamado de las variable instancia de lo 
        this.lider = lider;
        this.medalla = medalla;
    }
     @Override
     public void mostrarInformacion(){
         System.out.println("---GIMNASIO POKEMON---");
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
     
    
    
    
