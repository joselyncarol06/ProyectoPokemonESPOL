/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemapokemon.menuprincipal;

import com.espol.modelo.Entrenador.Equipo;
import com.espol.modelo.Entrenador.Entrenador;
import com.espol.modelo.LugarPokemon.*;
import java.util.ArrayList;
import java.util.Scanner;
import com.mycompany.sistemapokemon.menuprincipal.submenus.*;

public class EjecutarMenuPerfil {
    public static void ejecutarMenuPerfil(Scanner scanner, Entrenador entrenador, ArrayList<Equipo> equipos, ArrayList<LugarPokemon> lugares, ArrayList<Entrenador> entrenadores) {
        int opcion = 0;
        do {
            System.out.println("\n==================================================");
            System.out.println("Perfil Seleccionado: " + entrenador.getNombre() + " (" + entrenador.getUsuario() + ")");
            System.out.println("Equipo: " + entrenador.getEquipo().getNombreEquipo() + " | Pokebolas en mochila: " + entrenador.getMochilaPokebolas().size());
            System.out.println("==================================================");
            System.out.println("1. Administrar Información del Entrenador[cite: 3]");
            System.out.println("2. Administrar Pokémones[cite: 4]");
            System.out.println("3. Administrar Gimnasios[cite: 4, 5]");
            System.out.println("4. Administrar Centros de Salud Pokémon[cite: 5, 12]");
            System.out.println("5. Administrar Equipos[cite: 5]");
            System.out.println("6. Regresar a Selección de Perfil[cite: 6]");
            System.out.print("Ingrese una opción: ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Opción inválida. Ingrese un número.");
                scanner.nextLine();
                continue;
        }

            switch (opcion) {
                case 1:
                   AdministrarEntrenador.menuAdministrarEntrenador(scanner, entrenador);
                    break;
                case 2:
                   AdministrarPokemones.menuAdministrarPokemones(scanner, entrenador);
                    break;
                case 3:
                   AdministrarGimnasio.menuAdministrarGimnasios(scanner, entrenador, lugares);
                    break;
                case 4:
                    AdministrarCentroPokemon.menuAdministrarCentrosPokemon(scanner, entrenador, lugares);
                    break;
                case 5:
                    AdministrarEquipos.menuAdministrarEquipos(scanner, equipos, entrenadores);
                    break;
                case 6:
                    System.out.println("Regresando a selección de perfil...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
    }
}
