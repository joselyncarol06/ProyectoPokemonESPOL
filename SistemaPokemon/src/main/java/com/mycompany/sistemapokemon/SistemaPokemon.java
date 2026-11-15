/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistemapokemon;

import com.espol.modelo.Entrenador.Equipo;
import com.espol.modelo.Entrenador.Entrenador;
import com.espol.modelo.pokebola.TipoPokebola;
import com.espol.modelo.pokemon.Pokemon;
import com.espol.modelo.pokebola.Pokebola;
import com.espol.modelo.LugarPokemon.*;
import com.mycompany.sistemapokemon.menuprincipal.MenuPrincipal;
import java.util.ArrayList;
import java.util.Scanner;

public class SistemaPokemon {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        // 1. Cargar contenido inicial obligatorio al iniciar la ejecución:
        // (3 equipos, 1 perfil de entrenador, 1 centro médico, 1 gimnasio, 10 pokebolas y 5 pokemones)[cite: 5]
        ArrayList<Equipo> equipos = new ArrayList<>();
        equipos.add(new Equipo("Valor", "Rojo"));
        equipos.add(new Equipo("Místico", "Azul"));
        equipos.add(new Equipo("Instinto", "Amarillo"));

        ArrayList<Entrenador> entrenadores = new ArrayList<>();
        Entrenador ash = new Entrenador("Ash Ketchum", "ashk", "ash@espol.edu.ec", equipos.get(0));
        
        // Cargar las 10 pokebolas iniciales y 5 pokémones en las pokebolas de Ash[cite: 5]
        for (int i = 0; i < 10; i++) {
            ash.agregarPokebola(new Pokebola(TipoPokebola.POKEBOLA));
        }
        ash.registrarPokemon(new Pokemon("Pikachu", "Ratón", "Eléctrico", 15, 45));
        ash.registrarPokemon(new Pokemon("Charmander", "Lagartija", "Fuego", 12, 39));
        ash.registrarPokemon(new Pokemon("Squirtle", "Tortuga", "Agua", 12, 44));
        ash.registrarPokemon(new Pokemon("Bulbasaur", "Semilla", "Planta", 12, 45));
        ash.registrarPokemon(new Pokemon("Pidgey", "Pájaro", "Volador", 10, 40));
        
        entrenadores.add(ash);

        ArrayList<LugarPokemon> lugares = new ArrayList<>();
        lugares.add(new CentroDeSalud("Centro Pokémon ESPOL", "Guayaquil", "Enfermera Joy"));
        lugares.add(new Gimnasio("Espol", "Guayaquil", "Daniel", "Medalla Psiquico"));

        // 2. Iniciar el Menú Principal
        MenuPrincipal.ejecutarMenuPrincipal(scanner, entrenadores, equipos, lugares);
    }
  }  
