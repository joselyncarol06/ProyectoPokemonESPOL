/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemapokemon.menuprincipal;

import com.espol.modelo.*;
import java.util.ArrayList;
import java.util.Scanner;
import com.espol.modelo.Entrenador;
import com.espol.modelo.Equipo;

public class NuevoPefil {
    public static void crearNuevoPerfil(Scanner scanner, ArrayList<Entrenador> entrenadores, ArrayList<Equipo> equipos) {
        System.out.println("\n--- CREAR NUEVO PERFIL ---");
        System.out.print("Nombre del Entrenador: ");
        String nombre = scanner.nextLine();

        // Validar que el usuario sea único[cite: 2]
        String usuario;
        boolean usuarioExiste;
        do {
            usuarioExiste = false;
            System.out.print("Usuario del Entrenador (único, no modificable): ");
            usuario = scanner.nextLine().trim();
            for (Entrenador e : entrenadores) {
                if (e.getUsuario().equalsIgnoreCase(usuario)) {
                    System.out.println("Error: Ese usuario ya está registrado. Ingrese otro.");
                    usuarioExiste = true;
                    break;
                }
            }
        } while (usuarioExiste || usuario.isEmpty());

        // Listar equipos numerados[cite: 2, 5]
        System.out.println("Equipos a los que se puede unir:");
        for (int i = 0; i < equipos.size(); i++) {
            System.out.println((i + 1) + ". " + equipos.get(i).getNombreEquipo() + " (Color: " + equipos.get(i).getColor() + ")");
        }
        int eqIndex = -1;
        while (eqIndex < 0 || eqIndex >= equipos.size()) {
            System.out.print("Escoja un equipo (número): ");
            if (scanner.hasNextInt()) {
                eqIndex = scanner.nextInt() - 1;
            }
            scanner.nextLine();
        }
        Equipo equipoElegido = equipos.get(eqIndex);

        // Email opcional con formato[cite: 2, 6]
        System.out.print("Email del entrenador (opcional, ej: usuario@dominio.com): ");
        String email = scanner.nextLine().trim();

        // Crear entrenador y asignarle sus 10 pokebolas vacías por defecto
        Entrenador nuevoEntrenador = new Entrenador(nombre, usuario, email, equipoElegido);
        for (int i = 0; i < 10; i++) {
            nuevoEntrenador.agregarPokebola(new Pokebola(TipoPokebola.POKEBOLA));
        }

        entrenadores.add(nuevoEntrenador);
        System.out.println("¡Perfil creado exitosamente con 10 pokebolas en su mochila![cite: 5]");
    }
}
