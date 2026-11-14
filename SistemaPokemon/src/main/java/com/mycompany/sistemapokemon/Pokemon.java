/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemapokemon;

/**
 *
 * @author gerar
 */
public class Pokemon {
    private String codigo;
    private String nombre;
    private String tipoPrincipal;
    private String especie; 
    private int nivel; 
    private int puntosSalud; 
    private int puntosSaludMaximos;
    private static int contadorCodigo =0;
    //constrcutor

    public Pokemon(String nombre,String especie, String tipoPrincipal, int nivel, int puntosSalud) {
        this.codigo = String.format("PK-%03d", ++contadorCodigo);
        //String.format; metodo para amarmarun string de palabras fijas con variables
        //PK- constante  // %03d  es un entero ocupa 3 espacios y rellena con 0 a la izquierda espacios vacios
        this.nombre = nombre;
        this.tipoPrincipal = tipoPrincipal;
        this.especie = especie;
        this.nivel = nivel;
        this.puntosSalud = puntosSalud;
        this.puntosSaludMaximos = puntosSalud;
    }
    
    //getter y setters

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoPrincipal() {
        return tipoPrincipal;
    }

    public void setTipoPrincipal(String tipoPrincipal) {
        this.tipoPrincipal = tipoPrincipal;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getPuntosSalud() {
        return puntosSalud;
    }

    public void setPuntosSalud(int puntosSalud) {
        this.puntosSalud = puntosSalud;
    }

    public int getPuntosSaludMaximos() {
        return puntosSaludMaximos;
    }

    public void setPuntosSaludMaximos(int puntosSaludMaximos) {
        this.puntosSaludMaximos = puntosSaludMaximos;
    }
    
    
    //metodos
    //Restaura los puntos de salud actuales del Pokémon al máximo
    public void curar(){
     this.puntosSalud = this.puntosSaludMaximos;
    }
    @Override
    public String toString() {
        return String.format("[%s] %s (%s) | Tipo: %s | Nivel: %d | PS: %d/%d",
                codigo, nombre, especie, tipoPrincipal, nivel, puntosSalud, puntosSaludMaximos);
    }
    
    public void mostrarInformacion(){
        System.out.println(this.toString());    }
}