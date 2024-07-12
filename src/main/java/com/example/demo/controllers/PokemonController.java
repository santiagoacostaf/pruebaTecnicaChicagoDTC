package com.example.demo.controllers;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Object> getAllPokemons() {
        List<Pokemon> pokemons = pokemonService.getAllPokemons();
		logger.info("pokemons:");
		logger.info(pokemons);
       	return ResponseEntity.status(HttpStatus.OK).body(pokemons);
    }
}
