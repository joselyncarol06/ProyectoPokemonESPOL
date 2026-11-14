package com.espol.modelo.LugarPokemon;

import com.espol.modelo.LugarPokemon.LugarPokemon;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author daniel
 */
public class CentroDeSalud extends LugarPokemon{
    private String enfermeraCargo;
    private static int contador = 0;
    
    //constructor 

    public CentroDeSalud(String enfermeraCargo, String nombre, String ciudad) {
        super(nombre, ciudad, "CentS-" + (++contador));
        this.enfermeraCargo = enfermeraCargo;
    }
    


    // POLIMORFISMO: Sobrescritura del método abstracto
    @Override
    public void mostrarInformacion() {
        System.out.println("--- CENTRO DE SALUD POKÉMON ---");
        System.out.println("Código: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Ciudad/Ubicación: " + ciudad);
        System.out.println("Enfermera a cargo: " + enfermeraCargo);
        System.out.println("-------------------------------");
    }

    public String getEnfermeraCargo() { 
        return enfermeraCargo; 
    }
}

