package com.upc.curso.entidades;

public class Filtro extends  Pedido{
    private double monto_igv;

    public Filtro(Long codigo, String descripcion, double precio, String estado, double monto_igv) {
        super(codigo, descripcion, precio, estado);
        this.monto_igv = monto_igv;
    }

    public double getMonto_igv() {
        return monto_igv;
    }

    public void setMonto_igv(double monto_igv) {
        this.monto_igv = monto_igv;
    }
}
