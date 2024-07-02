package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.restservice.Persona;

public interface PersonaRepository extends CrudRepository<Persona, Integer>{

}
