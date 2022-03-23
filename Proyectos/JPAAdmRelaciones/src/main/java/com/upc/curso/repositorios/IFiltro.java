package com.upc.curso.repositorios;

import com.upc.curso.entidades.Pedido;

public interface IFiltro {
    Long getCodigo();
    String getDescripcion();
    double getPrecio();
    String getEstado();
    Double getImpuesto();
}
