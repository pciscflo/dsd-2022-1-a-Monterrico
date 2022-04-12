package com.upc.banco.appbancorelaciones.entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TP_OPERACION")
public class Operacion implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4179932126699651004L;
	public Operacion() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_OPERACION")
	private Long idOperacion;
	
	@ManyToOne
	@JoinColumn(name="ID_CLIENTE")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="TIPO", nullable=false)
	private TipoOperacion tipoOperacion;
	

	private Double monto;
	private Long numeroCuentaDeposito;
	private Long numeroCuentaRetiro;
	private String respuesta;
	

	public Long getIdOperacion() {
		return idOperacion;
	}

	public void setIdOperacion(Long idOperacion) {
		this.idOperacion = idOperacion;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public TipoOperacion getTipoOperacion() {
		return tipoOperacion;
	}

	public void setTipoOperacion(TipoOperacion tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Long getNumeroCuentaDeposito() {
		return numeroCuentaDeposito;
	}

	public void setNumeroCuentaDeposito(Long numeroCuentaDeposito) {
		this.numeroCuentaDeposito = numeroCuentaDeposito;
	}

	public Long getNumeroCuentaRetiro() {
		return numeroCuentaRetiro;
	}

	public void setNumeroCuentaRetiro(Long numeroCuentaRetiro) {
		this.numeroCuentaRetiro = numeroCuentaRetiro;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	
}
