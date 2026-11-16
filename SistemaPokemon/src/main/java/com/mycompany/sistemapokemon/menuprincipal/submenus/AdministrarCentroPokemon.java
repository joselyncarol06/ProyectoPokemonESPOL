/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemapokemon.menuprincipal.submenus;
import com.espol.modelo.Entrenador.Entrenador;
import java.util.Scanner;
import com.espol.modelo.LugarPokemon.*;
import java.util.ArrayList;
import java.time.LocalDate;
import com.espol.modelo.LugarPokemon.Registros.RegistroSalud;
import com.espol.modelo.pokebola.Pokebola;
import com.espol.modelo.pokemon.Pokemon;

public class AdministrarCentroPokemon {
    
    
    /**
    * Registra una visita para curar uno o todos los Pokemon.
    */
    public static void registrarVisita(Scanner scanner, Entrenador entrenador, ArrayList<LugarPokemon> lugares) {

        // Buscar centros de salud
        ArrayList<CentroDeSalud> centros = new ArrayList<>();

        for (LugarPokemon lugar : lugares) {
            if (lugar instanceof CentroDeSalud) {
            centros.add((CentroDeSalud) lugar);
        
            }
        }
            
    

        if (centros.isEmpty()) {
        System.out.println("No hay centros registrados.");
        return;
        }

        // Seleccionar centro
         for (int i = 0; i < centros.size(); i++) {
            System.out.println((i + 1) + ". " + centros.get(i).getNombre());
    
        }

        System.out.print("Seleccione un centro: ");
        int numero = leerNumero(scanner);

        if (numero < 1 || numero > centros.size()) {
            System.out.println("Centro invalido.");
            return;
        }

        CentroDeSalud centro = centros.get(numero - 1);

        System.out.println("1. Curar un Pokemon");
        System.out.println("2. Curar todos los Pokemon");
        System.out.print("Opcion: ");

        int opcion = leerNumero(scanner);

        ArrayList<Object> atendidos = new ArrayList<>();

        if (opcion == 1) {

            System.out.print("Codigo de Pokebola: ");
            String codigo = scanner.nextLine();

            Pokebola pokebola = entrenador.buscarPokebola(codigo);

            if (pokebola == null || pokebola.estaVacia()) {
            System.out.println("Pokebola no encontrada o vacia.");
            return;
            }

            Pokemon pokemon = pokebola.getPokemonContenido();
            centro.curarPokemon(pokemon);
            atendidos.add(pokemon);

        } else if (opcion == 2) {

            for (Pokebola pokebola :
                entrenador.getMochilaPokebolas()) {

                if (!pokebola.estaVacia()) {
                   Pokemon pokemon = pokebola.getPokemonContenido();
                   centro.curarPokemon(pokemon);
                   atendidos.add(pokemon);
                }
            }

        } else {
            System.out.println("Opcion invalida.");
            return;
        }

        if (atendidos.isEmpty()) {
        System.out.println("No hay Pokemon para curar.");
        return;
        }

        // Generar comprobante
        RegistroSalud registro = new RegistroSalud(
        LocalDate.now(), centro, atendidos);

        registro.imprimirComprobante();
    }

    /**
    * Lee un numero y evita errores al ingresar letras.
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
    
   
    
    
    
    
    public static void menuAdministrarCentrosPokemon(Scanner scanner, Entrenador entrenador, ArrayList<LugarPokemon> lugares) {
        int opcion = 0;
        do {
            System.out.println("\n--- ADMINISTRAR CENTROS DE SALUD ---");
            System.out.println("1. Listar Centros de Salud");
            System.out.println("2. Registrar nuevo Centro de Salud");
            System.out.println("3. Registrar Visita / Curación de Pokemones");
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
                    lugares.add(new CentroDeSalud(enf, nomC, ciuC));
                    System.out.println("¡Centro de salud registrado exitosamente!");
                    break;
                case 3:
                    registrarVisita(scanner, entrenador, lugares);
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
