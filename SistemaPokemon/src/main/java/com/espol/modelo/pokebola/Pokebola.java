/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.espol.modelo.pokebola;

import com.espol.modelo.pokemon.Pokemon;



/**
 *
 * @author gerar
 */
public class Pokebola {
    private static int contadorCodigo = 0;
    private Pokemon pokemonContenido;
    private String codigo; //PB-001"
    private TipoPokebola tipo; 
    //constructor
    //codigo se genera solo, como el pk anterior
    //pkbola nueva = null pk
    public Pokebola(TipoPokebola tipo) {
        this.codigo = String.format("PB-%03d", ++contadorCodigo);
        this.pokemonContenido = null;
        this.tipo = tipo;
    }
    //gett y sett

    public Pokemon getPokemonContenido() {
        return pokemonContenido;
    }

    public void setPokemonContenido(Pokemon pokemonContenido) {
        this.pokemonContenido = pokemonContenido;
    }

    public String getCodigo() {
        return codigo;
    }

    public TipoPokebola getTipo() {
        return tipo;
    }

    public void setTipo(TipoPokebola tipo) {
        this.tipo = tipo;
    }
    
    
    
    //metodo
    public boolean estaVacia(){
        return this.pokemonContenido == null;
    }
    
    public boolean guardarPokemon(Pokemon pokemon) {
        if (estaVacia() && pokemon != null) {
            this.pokemonContenido = pokemon;
            return true; // Se guardó con éxito
        }
        return false; // No se pudo guardar porque estaba ocupada o el pokémon era null
    }
//basicamente boto el pokemon de la pkbla 
    public void liberarPokemon(){
        this.pokemonContenido = null;
    }



}
    
   

