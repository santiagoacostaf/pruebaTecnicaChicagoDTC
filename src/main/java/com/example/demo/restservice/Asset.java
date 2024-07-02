package com.example.demo.restservice;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Asset {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	String nombre;
	String descripcion;
	String tipo;
	String serial;
	int numeroInternoInventario;
	Double peso;
	Double alto;
	Double ancho;
	Double largo;
	Double valor;
	LocalDate fechaDeCompra;
	
	public Asset() {
		
	}
	/**
	 * Constructor of the Asset domain class
	 * @return
	 */
	public Asset(String nombre, String descripcion,String tipo,String serial,int numeroInternoInventario,Double peso,Double alto,Double ancho,Double largo, Double valor,LocalDate fechaDeCompra){
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.serial = serial;
		this.numeroInternoInventario = numeroInternoInventario;
		this.peso = peso;
		this.alto = alto;
		this.ancho= ancho;
		this.largo = largo;
		this.valor = valor;
		this.fechaDeCompra = fechaDeCompra;
	}
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		System.out.println("get nombre of asset!!");
		return this.nombre;
	}
	public String getDescripcion() {
		return this.descripcion;
	}
	public String getTipo() {
		return this.tipo;
	}
	public String getSerial() {
		return this.serial;
	}
	public int getNumeroInternoInventario() {
		return this.numeroInternoInventario;
	}
	public Double getPeso() {
		return this.peso;
	}
	public Double getAlto() {
		return this.alto;
	}
	public Double getAncho() {
		return this.ancho;
	}
	public Double getValor() {
		return this.valor;
	}
	public LocalDate getFechaDeCompra() {
		return this.fechaDeCompra;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public void setSerial(String serial) {
		this.serial = serial;
	}
	
	public void setNumeroInternoIntervalo(int numeroInternoInventario) {
		this.numeroInternoInventario = numeroInternoInventario;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public void setAlto(Double alto) {
		this.alto = alto;
	}
	public void setAncho(Double ancho) {
		this.ancho = ancho;
	}
	public void setLargo(Double largo) {
		this.largo = largo;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public void setFecha(LocalDate fechaDeCompra) {
		this.fechaDeCompra = fechaDeCompra;
	}
	
}
