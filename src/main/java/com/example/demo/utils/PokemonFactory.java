package com.example.demo.utils;

import com.example.demo.Model.Pokemon;

public class PokemonFactory {
     public static Pokemon createPokemon(String name, String url) {
        Pokemon pokemon = new Pokemon();
        pokemon.setUrl(url);
        pokemon.setName(name);
        return pokemon;
    }
}
