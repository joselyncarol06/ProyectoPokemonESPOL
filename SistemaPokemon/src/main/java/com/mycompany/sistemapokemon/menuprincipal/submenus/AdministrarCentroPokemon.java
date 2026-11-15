/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemapokemon.menuprincipal.submenus;
import com.espol.modelo.Entrenador.Entrenador;
import java.util.Scanner;
import com.espol.modelo.LugarPokemon.*;
import java.util.ArrayList;

public class AdministrarCentroPokemon {
    public static void menuAdministrarCentrosPokemon(Scanner scanner, Entrenador entrenador, ArrayList<LugarPokemon> lugares) {
        int opcion = 0;
        do {
            System.out.println("\n--- ADMINISTRAR CENTROS DE SALUD ---");
            System.out.println("1. Listar Centros de Salud");
            System.out.println("2. Registrar nuevo Centro de Salud");
            System.out.println("3. Registrar Visita / Curación de Pokemones");
            System.out.println("4. Regresar");
            System.out.print("Ingrese una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("\n--- CENTROS DE SALUD POKÉMON ---");
                    for (LugarPokemon l : lugares) {
                        if (l instanceof CentroDeSalud) {
                            l.mostrarInformacion();
                        }
                    }
                    break;
                case 2:
                    System.out.print("Nombre del Centro de Salud: ");
                    String nomC = scanner.nextLine();
                    System.out.print("Ciudad / Ubicación: ");
                    String ciuC = scanner.nextLine();
                    System.out.print("Enfermera a cargo: ");
                    String enf = scanner.nextLine();
                    lugares.add(new CentroDeSalud(nomC, ciuC, enf));
                    System.out.println("¡Centro de salud registrado exitosamente!");
                    break;
                case 3:
                    System.out.println("Visita a centro médico y curación de pokemones procesada.");
                    break;
                case 4:
                    System.out.println("Regresando...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 4);
    }
}
