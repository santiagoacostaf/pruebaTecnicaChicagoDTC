package com.example.demo.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import com.example.demo.Model.Pokemon;

public interface PokemonService {
    
    Page<Pokemon> getAllPokemons(Pageable pageable);
}
