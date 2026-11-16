/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.espol.modelo.LugarPokemon.Registros;

import com.espol.modelo.LugarPokemon.CentroDeSalud;
import com.espol.modelo.pokemon.Pokemon;

import java.time.LocalDate;

import java.util.ArrayList;

public class RegistroSalud {
    private LocalDate fecha;
    private CentroDeSalud centro;
    // Uso de Colecciones (ArrayList) para almacenar múltiples pokémones curados
    private ArrayList<Object> pokemonesAtendidos; 
    
    
    public RegistroSalud(LocalDate fecha, CentroDeSalud centro, ArrayList<Object> pokemonesAtendidos) {
        this.fecha = fecha;
        this.centro = centro;
        this.pokemonesAtendidos = new ArrayList<>(pokemonesAtendidos);
    }
    

    public void imprimirComprobante() {
        System.out.println("=== COMPROBANTE DE CURACIÓN ===");
        System.out.println("Fecha: " + fecha);
        System.out.println("Centro de Salud: " + centro.getNombre() + " (" + centro.getCiudad() + ")");
        System.out.println("Enfermera a cargo: " + centro.getEnfermeraCargo());
        System.out.println("Pokémones atendidos:");

        for (Object objeto : pokemonesAtendidos) {
            Pokemon pokemon = (Pokemon) objeto;
            System.out.println("- " + pokemon.getNombre());
        }

        System.out.println("Total de Pokémones atendidos: " + pokemonesAtendidos.size());
        System.out.println("==============================");
    }
    
}
