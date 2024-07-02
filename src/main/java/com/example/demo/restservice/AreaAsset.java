package com.example.demo.restservice;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AreaAsset {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	Integer areaId;
	Integer assetId;
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	public Integer getArea() {
		return this.areaId;
	}
	public void setAssetId(Integer assetId) {
		this.assetId = assetId;
	}
	public Integer getAsset() {
		return this.assetId;
	}
}
