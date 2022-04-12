package com.upc.banco.appbancorelaciones.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="TS_CLIENTE")
public class Cliente implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4726309821781030798L;
	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_CLIENTE")
	private Long idCliente;
	private String nombre;
	@Column(name="DNI", unique=true)
	private String dni;
	private String clave;
	
	@OneToMany(mappedBy="cliente", cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Cuenta> cuentas;
		
	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public List<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

}
