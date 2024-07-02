package com.example.demo.repositories;

import java.time.LocalDate;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.restservice.*;

public interface AssetRepository  extends CrudRepository<Asset, Integer>{

	Iterable<Asset> findByTipo(String tipoCompra);

	Iterable<Asset> findByFechaDeCompra(LocalDate datetime);

	Iterable<Asset> findBySerial(String serial);

}
