package com.example.demo.serviceImpl;

import com.example.demo.repositories.AssetRepository;
import com.example.demo.restservice.Asset;
import com.example.demo.service.AssetService;
import java.time.LocalDate;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component("AssetService")
public class AssetServiceImpl implements AssetService {

    @Autowired
	private AssetRepository assetRepository;

    protected static  Logger parentLogger = LogManager.getLogger(AssetServiceImpl.class);
    
    @Override
    public Optional<Asset> createAsset(String name, String descripcion, String tipo, String serial,
            String numeroInternoInventario, Double peso, Double alto, Double ancho, Double largo, Double valor,
            String fechaDeCompra) {
        //parse the values and create the new asset
		int parsedNumeroInternoInventario = Integer.parseInt(numeroInternoInventario);
		//parse the Local date
		Asset asset = new Asset(name,descripcion,tipo,serial,parsedNumeroInternoInventario,peso,alto,ancho,largo,valor,LocalDate.now());
		try {
			assetRepository.save(asset);
            return Optional.of(asset);
		}catch(Exception e) {
			parentLogger.debug(e.getMessage());
			return Optional.of(null);
		}
    }

	@Override
	public Optional<Asset> updateAsset(Integer assetId, String name, String descripcion, String tipo,  String serial, int numeroInternoInventario,
	Double peso,  Double alto,  Double ancho, Double largo, Double valor,  String fechaDeCompra) throws Exception, Error {
		Asset asset = assetRepository.findById(assetId).get(); 
		asset = new Asset(name,descripcion,tipo,serial,numeroInternoInventario,peso,alto,ancho,largo,valor,LocalDate.now());
		asset.setId(assetId);
		assetRepository.save(asset);
		return Optional.of(asset);
	}

	@Override
	public Integer deleteById(Integer assetId) throws Exception {
		Asset asset = assetRepository.findById(assetId).get();
		assetRepository.deleteById(assetId);
		return assetId;
	}

	@Override
	public Iterable<Asset> getAllAssets() {
		Iterable<Asset> assets = assetRepository.findAll();
		return assets;
	}

}