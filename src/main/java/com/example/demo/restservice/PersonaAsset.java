package com.example.demo.restservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PersonaAsset {
	@Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  private Integer id;
	Integer personaId;
	Integer assetId;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public void setPersonaId(Integer personaId) {
		this.personaId = personaId;
	}
	public Integer getPersonaId() {
		return this.personaId;
	}
	public void setAssetId(Integer assetId) {
		this.assetId = assetId;
	}
	
	public Integer getAssetId() {
		return this.assetId;
	}
}
