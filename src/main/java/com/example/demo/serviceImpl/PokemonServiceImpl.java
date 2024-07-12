package com.example.demo.serviceImpl;

import com.example.demo.Model.Pokemon;
import com.example.demo.service.PokemonService;
import com.example.demo.utils.PokemonConvertUtil;
import java.util.LinkedHashMap;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.data.domain.Pageable;

@Component("PokemonService")
public class PokemonServiceImpl implements PokemonService {

    private final String apiUrl = "https://pokeapi.co/api/v2/pokemon";

    PokemonConvertUtil pokemonConvertUtil = new PokemonConvertUtil();

    @Override
    public Page<Pokemon> getAllPokemons(Pageable pageable) {
        RestTemplate restTemplate = new RestTemplate();
        String url = apiUrl ;
        LinkedHashMap retrivedInformation = restTemplate.getForObject(url, LinkedHashMap.class);
        List<Pokemon> pokemons = pokemonConvertUtil.convertToList(retrivedInformation);
        Page<Pokemon> pagePokemons = pokemonConvertUtil.getPage(pageable, pokemons);
        return pagePokemons;

    }
}