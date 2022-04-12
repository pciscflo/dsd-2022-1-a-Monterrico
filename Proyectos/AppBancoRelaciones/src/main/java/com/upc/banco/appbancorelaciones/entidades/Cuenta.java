package com.upc.banco.appbancorelaciones.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TS_CUENTA")
public class Cuenta implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6606788307404586851L;
	public Cuenta() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_CUENTA")
	private Long idCuenta;
	
	@Column(name="NUMERO_CUENTA",unique=true)
	private Long numeroCuenta;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="ID_CLIENTE", nullable=false)//no genera
	@JsonIgnore
	private Cliente cliente;
	
	private Double saldo;
    
	public Long getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(Long idCuenta) {
		this.idCuenta = idCuenta;
	}

	public Long getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(Long numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
