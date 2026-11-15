/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemapokemon.menuprincipal.submenus;
import java.util.Scanner;
import com.espol.modelo.*;

public class AdministrarPokemones {
    public static void menuAdministrarPokemones(Scanner scanner, Entrenador entrenador) {
        int opcion = 0;
        do {
            System.out.println("\n--- ADMINISTRAR POKEMONES ---");
            System.out.println("1. Registrar nuevo Pokemon en Pokebola vacía");
            System.out.println("2. Listar mis Pokemones[cite: 4]");
            System.out.println("3. Liberar Pokemon (Eliminar de la Pokebola)");
            System.out.println("4. Regresar");
            System.out.print("Ingrese una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del Pokémon: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Especie: ");
                    String especie = scanner.nextLine();
                    System.out.print("Tipo principal (Fuego, Agua, Planta, etc.): ");
                    String tipo = scanner.nextLine();
                    System.out.print("Nivel: ");
                    int nivel = scanner.nextInt();
                    System.out.print("Puntos de Salud (PS): ");
                    int ps = scanner.nextInt();
                    scanner.nextLine();

                    Pokemon nuevoPoke = new Pokemon(nombre, especie, tipo, nivel, ps);
                    if (entrenador.registrarPokemon(nuevoPoke)) {
                        System.out.println("¡Pokémon guardado en una pokebola vacía con éxito!");
                    } else {
                        System.out.println("Error: No hay pokebolas vacías disponibles en la mochila.");
                    }
                    break;
                case 2:
                    System.out.println("\n--- MIS POKÉMONES ---");
                    for (Pokebola p : entrenador.getMochilaPokebolas()) {
                        if (!p.estaVacia()) {
                            System.out.println("Pokebola [" + p.getCodigo() + "] -> " + p.getPokemonContenido());
                        }
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el código de la Pokebola del Pokémon a liberar: ");
                    String cod = scanner.nextLine();
                    if (entrenador.liberarPokemon(cod)) {
                        System.out.println("¡Pokémon liberado! La pokebola vuelve a estar libre.");
                    } else {
                        System.out.println("No se encontró una pokebola ocupada con ese código.");
                    }
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
