package com.upc.banco.appbancorelaciones.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "TS_TIPO_OPERACION")
public class TipoOperacion implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1399570899297676428L;
	public TipoOperacion() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@Column(name="ID_TIPO")
	private Long IdTipo;	
	private String descripcion;

	
	public Long getIdTipo() {
		return IdTipo;
	}

	public void setIdTipo(Long idTipo) {
		IdTipo = idTipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	

}
