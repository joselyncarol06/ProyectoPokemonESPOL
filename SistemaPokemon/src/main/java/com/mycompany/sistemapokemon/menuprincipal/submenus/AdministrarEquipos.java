/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemapokemon.menuprincipal.submenus;

import com.espol.modelo.Entrenador.Entrenador;
import com.espol.modelo.Entrenador.Equipo;
import java.util.Scanner;
import java.util.ArrayList;

public class AdministrarEquipos {
    public static void menuAdministrarEquipos(Scanner scanner, ArrayList<Equipo> equipos, ArrayList<Entrenador> entrenadores) {
        int opcion = 0;
        do {
            System.out.println("\n--- ADMINISTRAR EQUIPOS ---");
            System.out.println("1. Ver listado de Equipos y entrenadores pertenecientes");
            System.out.println("2. Regresar");
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
                    System.out.println("\n--- EQUIPOS DISPONIBLES ---");
                    for (int i = 0; i < equipos.size(); i++) {
                        Equipo e = equipos.get(i);
                        System.out.println((i + 1) + ". Código: " + e.getCodigo() + " | Equipo: " + e.getNombreEquipo() + " | Color: " + e.getColor());
                        
                        boolean encontrado = false;

                        for (Entrenador entrenador : entrenadores) {
                            if (entrenador.getEquipo().getCodigo().equals(e.getCodigo())) {

                            System.out.println("   Entrenador: " + entrenador.getNombre() + " (" + entrenador.getUsuario() + ")");
                            encontrado = true;
                            }
                        }

                        if (!encontrado) {
                            System.out.println("   Sin entrenadores registrados.");
                        }     
                    }                 
                    break;
                case 2:
                    System.out.println("Regresando...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 2);
    }
}
    
