package com.example.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.repositories.AssetRepository;
import com.example.demo.restservice.Asset;
import com.example.demo.serviceImpl.AssetServiceImpl;

@SpringBootTest(classes=AssetServiceImpl.class)
public class AssetServiceImpTests {
    @MockBean
	private AssetRepository assetRepository;

    @Autowired
	private AssetServiceImpl assetServiceImpl;
    
	@Test
	void createAsset() throws Exception {
        Asset exampleAsset = new Asset();
		when(assetRepository.save(any())).thenReturn(exampleAsset);
		Optional<Asset> result = assetServiceImpl.createAsset(null, null, null, null,
         "5", null, null, null, null, null, null);
        assertSame(exampleAsset, result.get());
	}

    @Test
	void updateAsset() throws Exception {
        Asset exampleAsset = new Asset();
        when(assetRepository.findById(any())).thenReturn(Optional.of(exampleAsset));
		when(assetRepository.save(any())).thenReturn(exampleAsset);
		Optional<Asset> result = assetServiceImpl.updateAsset(1, "name", "desc", "tipo", "serial", 5, null, null, null, null, null, null);
        assertSame(exampleAsset, result.get());
	}
}
