
package com.espol.modelo.LugarPokemon;

import com.espol.modelo.Pokemon;

import java.time.LocalDate;
public class RegistroBatallla {
    private LocalDate fecha;
    private Pokemon pokemon; 
    private Gimnasio gimnasio;
    private String resultado; // "Victoria" o "Derrota"

    public RegistroBatallla(LocalDate fecha, Pokemon pokemon, Gimnasio gimnasio, String resultado) {
        this.fecha = LocalDate.now();
        this.pokemon = pokemon;
        this.gimnasio = gimnasio;
        this.resultado = resultado;
    }
    

    public void mostrarRegistro() {
        System.out.println("=== BITÁCORA DE BATALLA ===");
        System.out.println("Fecha: " + fecha);
        System.out.println("Gimnasio: " + gimnasio.getNombre() + " (" + gimnasio.getCiudad() + ")");
        System.out.println("Resultado: " + resultado);
        System.out.println("---------------------------");
    }
}
    
