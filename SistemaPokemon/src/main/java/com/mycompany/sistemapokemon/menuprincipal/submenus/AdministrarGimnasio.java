/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemapokemon.menuprincipal.submenus;

import com.espol.modelo.pokemon.Pokemon;
import com.espol.modelo.pokebola.Pokebola;
import com.espol.modelo.LugarPokemon.Registros.RegistroBatallla;
import com.espol.modelo.Entrenador.Entrenador;
import java.util.Scanner;
import com.espol.modelo.LugarPokemon.*;
import java.util.ArrayList;
import java.time.LocalDate;

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
                    registrarVisitaGimnasio(scanner, entrenador, lugares);
                    break;
                case 4:
                    System.out.println("Regresando...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 4);
    }
    
    
    /**
   * Permite registrar una visita a un gimnasio Pokemon.
   */
    public static void registrarVisitaGimnasio(Scanner scanner, Entrenador entrenador, ArrayList<LugarPokemon> lugares) {

        ArrayList<Gimnasio> gimnasios = new ArrayList<>();

        // Buscar gimnasios registrados
        for (LugarPokemon lugar : lugares) {
            if (lugar instanceof Gimnasio) {
                gimnasios.add((Gimnasio) lugar);
            }
        }

        if (gimnasios.isEmpty()) {
            System.out.println("No hay gimnasios registrados.");
            return;
        }

        // Mostrar gimnasios
        for (int i = 0; i < gimnasios.size(); i++) {
            System.out.println((i + 1) + ". " + gimnasios.get(i).getNombre());
        }

        System.out.print("Seleccione gimnasio: ");
        int opcionG = leerNumero(scanner);

        if (opcionG < 1 || opcionG > gimnasios.size()) {
            System.out.println("Gimnasio invalido.");
            return;
        }
 
        Gimnasio gimnasio = gimnasios.get(opcionG - 1);

        // Obtener Pokemon del entrenador
        ArrayList<Pokemon> pokemones = new ArrayList<>();

        for (Pokebola pokebola : entrenador.getMochilaPokebolas()) {
            if (!pokebola.estaVacia()) {
            pokemones.add(pokebola.getPokemonContenido());
            }
        }

        if (pokemones.isEmpty()) {
            System.out.println("No tienes Pokemon disponibles.");
            return;
        }

        // Mostrar Pokemon
        for (int i = 0; i < pokemones.size(); i++) {
            System.out.println((i + 1) + ". " + pokemones.get(i).getNombre());
        }

        System.out.print("Seleccione Pokemon: ");
        int opcionP = leerNumero(scanner);

        if (opcionP < 1 || opcionP > pokemones.size()) {
            System.out.println("Pokemon invalido.");
            return;
        }

        Pokemon pokemon = pokemones.get(opcionP - 1);

        // Seleccionar resultado
        System.out.println("1. Victoria");
        System.out.println("2. Derrota");
        System.out.print("Resultado: ");

        int opcionR = leerNumero(scanner);

        if (opcionR != 1 && opcionR != 2) {
            System.out.println("Resultado invalido.");
            return;
        }

        String resultado = opcionR == 1 ? "Victoria" : "Derrota";

        // Llamar al metodo de la clase Gimnasio
        gimnasio.registrarBatalla(pokemon, resultado);
    }

    /**
    * Lee un numero evitando errores si el usuario ingresa letras.
    */
    private static int leerNumero(Scanner scanner) {

        if (!scanner.hasNextInt()) {
        scanner.nextLine();
        return -1;
        }

        int numero = scanner.nextInt();
        scanner.nextLine();

        return numero;
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
