package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.restservice.Area;
@Repository
public interface AreaRepository extends CrudRepository<Area, Integer>{

}
