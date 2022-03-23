package com.upc.curso.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="TP_CLIENTE")
public class Cliente implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8388681951962355877L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO_CLIENTE")
	private Long codigo;
	@Column(unique = true)
	private String dni;
	private String nombre;
	private String email;
	private String telefono;

	@OneToMany(mappedBy="cliente", cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Pedido> pedidos;

	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDni() {
		return dni;
	}
	public List<Pedido> getPedidos() {
		return pedidos;
	}
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
}