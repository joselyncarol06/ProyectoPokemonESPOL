/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemapokemon.menuprincipal.submenus;

import com.espol.modelo.Entrenador.Entrenador;
import java.util.Scanner;
import com.espol.modelo.LugarPokemon.*;
import java.util.ArrayList;

public class AdministrarGimnasio {
    public static void menuAdministrarGimnasios(Scanner scanner, Entrenador entrenador, ArrayList<LugarPokemon> lugares) {
        int opcion = 0;
        do {
            System.out.println("\n--- ADMINISTRAR GIMNASIOS POKEMON ---");
            System.out.println("1. Listar Gimnasios");
            System.out.println("2. Registrar nuevo Gimnasio");
            System.out.println("3. Registrar Bitácora de Batalla / Visita a Gimnasio");
            System.out.println("4. Regresar");
            System.out.print("Ingrese una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("\n--- GIMNASIOS REGISTRADOS ---");
                    for (LugarPokemon l : lugares) {
                        if (l instanceof Gimnasio) {
                            l.mostrarInformacion();
                        }
                    }
                    break;
                case 2:
                    System.out.print("Nombre del Gimnasio: ");
                    String nomG = scanner.nextLine();
                    System.out.print("Ciudad: ");
                    String ciuG = scanner.nextLine();
                    System.out.print("Líder de Gimnasio: ");
                    String lider = scanner.nextLine();
                    System.out.print("Tipo de Medalla: ");
                    String medalla = scanner.nextLine();
                    lugares.add(new Gimnasio(nomG, ciuG, lider, medalla));
                    System.out.println("¡Gimnasio registrado exitosamente!");
                    break;
                case 3:
                    System.out.println("Registro de batalla en gimnasio seleccionado.");
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
