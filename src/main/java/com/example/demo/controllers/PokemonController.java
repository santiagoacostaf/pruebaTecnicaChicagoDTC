package com.example.demo.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Pokemon;
import com.example.demo.service.PokemonService;

@RestController
@RequestMapping(path="/pokemon")
public class PokemonController {
    
	@Autowired
	PokemonService pokemonService;

	private static  Logger logger = LogManager.getLogger(PokemonController.class);

    @GetMapping("/all")
	public Page<Pokemon> getAllPokemons(Pageable pageable) {
        Page<Pokemon> pokemons = pokemonService.getAllPokemons(pageable);
		logger.info("pokemons:");
		logger.info(pokemons);
       	return pokemons;
    }
}
