/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemapokemon.menuprincipal.submenus;
import java.util.Scanner;
import com.espol.modelo.*;


public class AdministrarEntrenador {
    public static void menuAdministrarEntrenador(Scanner scanner, Entrenador entrenador) {
        int opcion = 0;
        do {
            System.out.println("\n--- ADMINISTRAR INFORMACIÓN DE ENTRENADOR ---");
            System.out.println("1. Modificar nombre del entrenador");
            System.out.println("2. Modificar email del entrenador");
            System.out.println("3. Agregar Pokebolas al inventario");
            System.out.println("4. Ver resumen del entrenador");
            System.out.println("5. Regresar");
            System.out.print("Ingrese una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Nombre actual: " + entrenador.getNombre());
                    System.out.print("¿Desea modificarlo? (s/n): ");
                    if (scanner.nextLine().equalsIgnoreCase("s")) {
                        System.out.print("Ingrese nuevo nombre: ");
                        entrenador.setNombre(scanner.nextLine());
                        System.out.println("¡Nombre actualizado!");
                    }
                    break;
                case 2:
                    System.out.println("Email actual: " + entrenador.getEmail());
                    System.out.print("¿Desea modificarlo? (s/n): ");
                    if (scanner.nextLine().equalsIgnoreCase("s")) {
                        System.out.print("Ingrese nuevo email: ");
                        entrenador.setEmail(scanner.nextLine());
                        System.out.println("¡Email actualizado!");
                    }
                    break;
                case 3:
                    System.out.println("Seleccione Tipo (1. POKEBOLA, 2. SUPERBOLA, 3. MASTERBOLA):");
                    int tipoOp = scanner.nextInt();
                    System.out.print("Indique la cantidad a agregar: ");
                    int cant = scanner.nextInt();
                    scanner.nextLine();
                    TipoPokebola tipoEnum = (tipoOp == 2) ? TipoPokebola.SUPERBOLA : (tipoOp == 3) ? TipoPokebola.MASTERBOLA : TipoPokebola.POKEBOLA;
                    for (int i = 0; i < cant; i++) {
                        entrenador.agregarPokebola(new Pokebola(tipoEnum));
                    }
                    System.out.println("¡Pokebolas agregadas exitosamente!");
                    break;
                case 4:
                    entrenador.mostrarPokebolas();
                    break;
                case 5:
                    System.out.println("Regresando...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 5);
    }
}
