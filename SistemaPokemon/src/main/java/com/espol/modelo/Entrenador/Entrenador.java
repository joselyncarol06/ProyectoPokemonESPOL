/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.espol.modelo.Entrenador;

/**
 *
 * @author josel
 */
import com.espol.modelo.pokebola.Pokebola;
import com.espol.modelo.pokemon.Pokemon;
import java.util.ArrayList;

/**
 * Representa a un entrenador del sistema Pokemon.
 * Permite administrar sus datos y sus Pokebolas.
 */

public class Entrenador {
    // Datos personales del entrenador
    private String nombre;
    private String usuario;
    private String email;
    private Equipo equipo;
    // Lista que almacena las Pokebolas del entrenador
    private ArrayList<Pokebola> mochilaPokebolas;

    /**
     * Constructor para crear un entrenador.
     *
     * @param nombre Nombre del entrenador.
     * @param usuario Usuario unico del entrenador.
     * @param email Correo electronico del entrenador.
     * @param equipo Equipo al que pertenece el entrenador.
     */
    
    public Entrenador(String nombre, String usuario, String email, Equipo equipo) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.email = email;
        this.equipo = equipo;
        // Inicializa la mochila como una lista vacia
        this.mochilaPokebolas = new ArrayList<>();
    }

    //get y set
    public String getUsuario() {
        return usuario;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Pokebola> getMochilaPokebolas() {
        return mochilaPokebolas;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * Agrega una Pokebola a la mochila del entrenador.
     *
     * @param pokebola Pokebola que se desea agregar.
     */
    
    public void agregarPokebola(Pokebola pokebola){
        if (pokebola!=null){
            mochilaPokebolas.add(pokebola);
            System.out.println("Pokebola agregada correctamente");
            
        }
        
    }
    /**
     * Cuenta las Pokebolas que tiene el entrenador.
     *
     * @return Cantidad de Pokebolas en la mochila.
     */
    public int contarPokebolas() {   
        return mochilaPokebolas.size();
    }
    
     /**
     * Muestra los codigos de las Pokebolas del entrenador.
     */
    public void mostrarPokebolas(){
        if (mochilaPokebolas.size()==0){
            System.out.println("No tienes Pokebola");
        }else{
            System.out.println("Pokebolas del entrenador");
            
            for(int i=0; i<mochilaPokebolas.size();i++){
                System.out.println("Codigo: "+ mochilaPokebolas.get(i).getCodigo());
            }
        }
        
    }
    
    /**
     * Elimina una Pokebola de la mochila por su codigo.
     *
     * @param codigo Codigo de la Pokebola que se desea eliminar.
     */
    public void eliminarPokebola(String codigo){
        for(int i=0; i<mochilaPokebolas.size();i++){
            if(mochilaPokebolas.get(i).getCodigo().equals(codigo)){
                mochilaPokebolas.remove(i);
                System.out.println("Pokebola eliminada");
                return;
            }
        }
        System.out.println("Pokebola no encontrada");
    }
    
    /**
     * Busca una Pokebola en la mochila utilizando su codigo.
     *
     * @param codigo Codigo de la Pokebola que se busca.
     * @return Pokebola encontrada o null si no existe.
     */
    public Pokebola buscarPokebola(String codigo){
        for (int i = 0; i < mochilaPokebolas.size(); i++){
            if (mochilaPokebolas.get(i).getCodigo().equals(codigo)) {
                return mochilaPokebolas.get(i);
            }
        }
        return null;
    }
    
public boolean liberarPokemon(String codigo) {
    for (Pokebola p : mochilaPokebolas) {
        // Si la pokebola no está vacía y el Pokémon dentro coincide con el código buscado
        if (!p.estaVacia() && p.getPokemonContenido().getCodigo().equalsIgnoreCase(codigo)) {
            p.liberarPokemon(); // Llama al método que ya tienes en la clase Pokebola
            System.out.println("¡Pokémon liberado con éxito!");
            return true;
        }
    }
    return false; // No se encontró ningún Pokémon con ese código
    
}
    public boolean registrarPokemon(Pokemon pokemon) {
    for (Pokebola p : mochilaPokebolas) {
        if (p.estaVacia()) {
            p.guardarPokemon(pokemon);
            System.out.println("¡" + pokemon.getNombre() + " ha sido registrado en una Pokébola!");
            return true;
        }
    }
    System.out.println("¡No tienes Pokébolas vacías en la mochila!");
    return false;
}
    
    
    
    
}
