package com.upc.curso.entidades;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="TP_PEDIDO")
public class Pedido {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	private String descripcion;
	private double precio;
	private String estado;
	private String codigoRespuesta;

	public Pedido() {
	}

	public Pedido(Long codigo, String descripcion, double precio, String estado) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precio = precio;
		this.estado = estado;
	}

	@ManyToOne
	@JoinColumn(name="CODIGO_CLIENTE")//no genera
	@JsonIgnore
	private Cliente cliente;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCodigoRespuesta() {
		return codigoRespuesta;
	}
	public void setCodigoRespuesta(String codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
