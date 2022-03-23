package com.upc.appproducto.negocio;

import com.upc.appproducto.entidades.Producto;
import com.upc.appproducto.repositorio.IRepositorioProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NegocioProducto {
    @Autowired //inyectamos al repositorio
    private IRepositorioProducto iRepositorioProducto;

    public Producto registrar(Producto producto){
        return iRepositorioProducto.save(producto);
    }
    public List<Producto> obtenerListado(){
        return iRepositorioProducto.findAll();
    }
    public List<Producto> obtenerListaPrecio(double precio){
        return iRepositorioProducto.buscarPrecio(precio);
    }
    public Producto actualizarProducto(Producto producto) throws Exception{
        Producto p = iRepositorioProducto.findById(
                producto.getCodigo()).orElseThrow(() -> new Exception("No se encontró entidad"));
        p = producto;
        return iRepositorioProducto.save(p);
    }
    public double calcularDescuento(Producto producto){//recibe el códigodel producto a buscar
        double descuento=0;
        Producto p;
        //busca al producto a descontar
        p = iRepositorioProducto.findById(producto.getCodigo()).get();
        //aplica la regla de descuento
        if(p.getPrecio()<10){
            descuento = 0.10*p.getPrecio();
        }
        return descuento;
    }
}
