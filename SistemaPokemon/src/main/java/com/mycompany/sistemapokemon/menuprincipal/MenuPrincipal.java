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



public class MenuPrincipal {
    public static void ejecutarMenuPrincipal(Scanner scanner, ArrayList<Entrenador> entrenadores, ArrayList<Equipo> equipos, ArrayList<LugarPokemon> lugares) {
        int opcion = 0;
        do {
            System.out.println("=========================================");
            System.out.println("   BITÁCORA DEL ENTRENADOR POKÉMON       ");
            System.out.println("=========================================");
            System.out.println("Perfiles Registrados:");
            for (int i = 0; i < entrenadores.size(); i++) {
                System.out.println((i + 1) + ". " + entrenadores.get(i).getNombre() + 
                                   " (Usuario: " + entrenadores.get(i).getUsuario() + 
                                   " - Equipo: " + entrenadores.get(i).getEquipo().getNombreEquipo() + ")");
            }
            System.out.println("\nOpciones:");
            System.out.println("[1] Seleccionar Perfil");
            System.out.println("[2] Crear Nuevo Perfil");
            System.out.println("[3] Salir");
            System.out.print("Ingrese una opción: ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer

                switch (opcion) {
                    case 1:
                        if (entrenadores.isEmpty()) {
                            System.out.println("¡No hay perfiles registrados!");
                            break;
                        }
                        System.out.print("Ingrese el número del perfil a seleccionar: ");
                        if (!scanner.hasNextInt()) {
                            System.out.println("Ingrese un número válido.");
                            scanner.nextLine();
                            break;
                        }

                        int index = scanner.nextInt() - 1;
                        scanner.nextLine();
                        if (index >= 0 && index < entrenadores.size()) {
                            EjecutarMenuPerfil.ejecutarMenuPerfil(scanner,entrenadores.get(index),equipos,lugares,entrenadores);
                        } else {
                            System.out.println("¡Índice de perfil inválido!");
                        }
                        break;
                    case 2:
                        NuevoPefil.crearNuevoPerfil(scanner, entrenadores, equipos);
                        break;
                    case 3:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }
            } else {
                scanner.nextLine();
                opcion = 0;
            }
        } while (opcion != 3);
    }
}
