/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.espol.modelo;

/**
 *
 * @author josel
 */
import java.util.ArrayList;
public class Entrenador {
    private String nombre;
    private String usuario;
    private String email;
    private Equipo equipo;
    private ArrayList<Pokebola> mochilaPokebolas;

    public Entrenador(String nombre, String usuario, String email, Equipo equipo) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.email = email;
        this.equipo = equipo;
        this.mochilaPokebolas = new ArrayList<>();
    }

    public String getUsuario() {
        return usuario;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public String getNombre() {
        return nombre;
    }
    
    

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
    
    
}
