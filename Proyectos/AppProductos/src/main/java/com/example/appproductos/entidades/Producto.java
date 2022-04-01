package com.example.appproductos.entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TBL_PRODUCTO")
public class Producto implements Serializable { //Clusterizable
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long codigo;
    private String descripcion;
    private double precio;
    private int stock;

    public Producto() {
    }

    public Producto(Long codigo, String descripcion, double precio, int stock) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }

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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo=" + codigo +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                '}';
    }
}
