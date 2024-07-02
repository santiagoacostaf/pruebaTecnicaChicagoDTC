package com.example.demo.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repositories.AssetRepository;
import com.example.demo.restservice.Asset;



@RestController
@RequestMapping(path="/demo")
public class AssetController {
	
	@Autowired
	private AssetRepository assetRepository;
	/**
	 * Funciton for creating a new asset with it's mandatory attributes
	 * @param name
	 * @param descripcion
	 * @param tipo
	 * @param serial
	 * @param numeroInternoInventario
	 * @param peso
	 * @param alto
	 * @param ancho
	 * @param largo
	 * @param valor
	 * @param fechaDeCompra
	 * @return
	 */
	@PostMapping("/new")
	public ResponseEntity<Object> greeting(@RequestParam(value = "name") String name,@RequestParam(value = "descripcion") String descripcion,@RequestParam(value = "tipo") String tipo,
			@RequestParam(value = "serial") String serial,@RequestParam(value = "numeroInternoInventario") String numeroInternoInventario,@RequestParam(value = "peso") Double peso,
			@RequestParam(value = "alto") Double alto,@RequestParam(value = "ancho") Double ancho,@RequestParam(value = "largo") Double largo,
			@RequestParam(value = "valor") Double valor,@RequestParam(value = "fechaDeCompra") String fechaDeCompra) {
		System.out.println("greetings ");
		System.out.println(name);
		System.out.println(descripcion);
		System.out.println(tipo);
		System.out.println(serial);
		System.out.println(numeroInternoInventario);
		System.out.println(peso);
		System.out.println(alto);
		System.out.print("Ancho: ");
		System.out.println(ancho);
		System.out.println(valor);
		System.out.println(fechaDeCompra);
		//parse the values and create the new asset
		int parsedNumeroInternoInventario = Integer.parseInt(numeroInternoInventario);
		//parse the Local date
		
		
		Asset asset = new Asset(name,descripcion,tipo,serial,parsedNumeroInternoInventario,peso,alto,ancho,largo,valor,LocalDate.now());
		try {
			return ResponseEntity.status(HttpStatus.OK).body(assetRepository.save(asset));
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	@PostMapping("/update")
	public ResponseEntity<Object> updateAsset(@RequestParam(value = "assetId") Integer assetId, @RequestParam(value = "name") String name,@RequestParam(value = "descripcion") String descripcion,@RequestParam(value = "tipo") String tipo,
			@RequestParam(value = "serial") String serial,@RequestParam(value = "numeroInternoInventario") int numeroInternoInventario,@RequestParam(value = "peso") Double peso,
			@RequestParam(value = "alto") Double alto,@RequestParam(value = "ancho") Double ancho,@RequestParam(value = "largo") Double largo,
			@RequestParam(value = "valor") Double valor,@RequestParam(value = "fechaDeCompra") String fechaDeCompra) {
		
		 
		try {
			Asset asset = assetRepository.findById(assetId).get(); 
			asset = new Asset(name,descripcion,tipo,serial,numeroInternoInventario,peso,alto,ancho,largo,valor,LocalDate.now());
			asset.setId(assetId);
			return ResponseEntity.status(HttpStatus.OK).body(assetRepository.save(asset));
		}catch(Exception e) {
			System.out.println(e.getMessage());
			if(e.getMessage()== "No value present") {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El activo con id:" + assetId  +" no se encontró");
			}
			else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al actualizar el activo, tiene parametros nulos");
			}
			
		}catch(Error e) {
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Error al actualizar el activo");
		}
	}
	/**
	 * Function for deleting an asset receiving as parameter an asset's id
	 * @param assetId
	 * @return
	 */
	@DeleteMapping("/delete")
	public ResponseEntity<Object> delete(@RequestParam Integer assetId){
		
		try {
			Asset asset = assetRepository.findById(assetId).get();
			assetRepository.deleteById(assetId);
			return ResponseEntity.status(HttpStatus.OK).body("Se eliminó el activo: " + assetId);
						
		}catch (Exception e) {
			
			if(e.getMessage() == "No value present") {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El activo a borrar no se encontró");
			}
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Error al borrar el activo");
		}		
	}
	/**
	 * Function to list a set of assets
	 * @return the list of all assets with an http ok status
	 */
	@GetMapping("/all")
	public ResponseEntity<Object> getAllAssets(){
		Iterable<Asset> assets = assetRepository.findAll();
		return  ResponseEntity.status(HttpStatus.OK).body(assets);//(assets) ;
	}
	/**
	 * Function that gets an specific asset
	 * @param assetId
	 * @return the asset with the correct status
	 */
	@GetMapping("/get")
	public  ResponseEntity<Object> getById(@RequestParam Integer assetId) {
		try {
			Asset asset = assetRepository.findById(assetId).get();
			return ResponseEntity.status(HttpStatus.OK).body(asset);
		}catch(Exception e) {
			if(e.getMessage()== "No value present") {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El activo con id:" + assetId  +" no se encontró");
			}
			else {
				return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Error al consultar el activo");
			}
		}
	}
	
	@GetMapping("/findByTipoDeCompra")
	public  ResponseEntity<Object> getByTipo(@RequestParam String tipoCompra) {
		try {
			Iterable<Asset> assets = assetRepository.findByTipo(tipoCompra);//Id(assetId).get();
			return ResponseEntity.status(HttpStatus.OK).body(assets);
		}catch(Exception e) {
			if(e.getMessage()== "No value present") {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existen activos de tipo:" + tipoCompra );
			}
			else {
				return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Error al consultar el activo con tipo de compra: " + tipoCompra );
			}
		}
	}
	
	@GetMapping("/findByFechaCompra")
	public  ResponseEntity<Object> getByFecha(@RequestParam String fechaCompra) {
		try {
			//parse string to LocalDate
			
			LocalDate datetime = LocalDate.parse(fechaCompra);
			Iterable<Asset> assets = assetRepository.findByFechaDeCompra(datetime);
			return ResponseEntity.status(HttpStatus.OK).body(assets);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			if(e.getMessage()== "No value present") {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existen activos con fecha:" + fechaCompra );
			}
			else {
				return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Error al consultar el activo con fecha" + fechaCompra);
			}
		}
	}
	
	@GetMapping("/findBySerial")
	public  ResponseEntity<Object> getBySerial(@RequestParam String serial) {
		try {
			Iterable<Asset> assets = assetRepository.findBySerial(serial);//Id(assetId).get();
			return ResponseEntity.status(HttpStatus.OK).body(assets);
		}catch(Exception e) {
			if(e.getMessage()== "No value present") {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existen activos de serial:" + serial );
			}
			else {
				return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Error al consultar el activo");
			}
		}
	}
}
