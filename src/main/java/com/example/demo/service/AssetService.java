package com.example.demo.service;

import java.util.Optional;

import com.example.demo.restservice.Asset;

public interface AssetService {
    
    Optional<Asset> createAsset(String name, String descripcion, String tipo,  String serial, String numeroInternoInventario,
        Double peso,  Double alto,  Double ancho, Double largo, Double valor,  String fechaDeCompra); 
    
    Optional<Asset> updateAsset(Integer assetId, String name, String descripcion, String tipo,  String serial, int numeroInternoInventario,
        Double peso,  Double alto,  Double ancho, Double largo, Double valor,  String fechaDeCompra) throws Exception, Error;
    
    Integer deleteById(Integer assetId) throws Exception;

    Iterable<Asset> getAllAssets();

    Asset getById(Integer id) throws Exception;

    Iterable<Asset> findByTipoCompra(String tipoCompra) throws Exception;

    Iterable<Asset> findByFechaCompra(String fechaCompra) throws Exception;
    
    Iterable<Asset> findBySerial(String Serial) throws Exception;
    
}
