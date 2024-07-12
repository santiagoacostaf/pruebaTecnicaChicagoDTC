package com.example.demo.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import com.example.demo.Model.Pokemon;

public class PokemonConvertUtil {
    
    public List<Pokemon> convertToList(LinkedHashMap pokemons) {
        Iterator<HashMap> iterator = ((List<HashMap>) pokemons.get("results")).iterator();
        List<Pokemon> returnList = new ArrayList<>();
        Pokemon currentPokemon = new Pokemon();
        HashMap currentIterator;
        while(iterator.hasNext()) {
            currentIterator = iterator.next();
            currentPokemon.setName((String)currentIterator.get("name"));
            currentPokemon.setUrl((String)currentIterator.get("url"));
            returnList.add(currentPokemon);
        }
        return returnList;
    }

}
