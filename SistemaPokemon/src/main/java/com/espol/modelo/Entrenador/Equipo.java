/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.espol.modelo.Entrenador;

/**
 *
 * @author josel
 */
public class Equipo {
    // Contador de linea automatica 
    private static int contardor=1;
    // Contador para generar codigos automaticamente
    private static int contador = 1;

    // Atributos del equipo
    private String codigo;
    private String nombreEquipo;
    private String color;

    /**
     * Constructor para crear un equipo.
     *
     * @param nombreEquipo Nombre del equipo.
     * @param color Color distintivo del equipo.
     */
    public Equipo(String nombreEquipo, String color) {
        // Genera un codigo unico para cada equipo
        this.codigo = String.format("EQ-%03d", contador);
        contador++;

        this.nombreEquipo = nombreEquipo;
        this.color = color;
    }

    /**
     * Obtiene el codigo del equipo.
     *
     * @return Codigo del equipo.
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Obtiene el nombre del equipo.
     *
     * @return Nombre del equipo.
     */
    public String getNombreEquipo() {
        return nombreEquipo;
    }

    /**
     * Obtiene el color del equipo.
     *
     * @return Color distintivo del equipo.
     */
    public String getColor() {
        return color;
    }

    /**
     * Muestra la informacion del equipo.
     */
    public void mostrarInformacion() {
        System.out.println("Codigo: " + codigo);
        System.out.println("Equipo: " + nombreEquipo);
        System.out.println("Color: " + color);
    }
}
