package com.example.demo.restservice;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Area {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "ciudad_id")
	Ciudad ciudad;
	String nombre;
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	Ciudad getCiudad() {
		return this.getCiudad();
	}
	void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	String getNombre() {
		return this.nombre;
	}
	void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
