package com.example.appproductos.negocio;

import com.example.appproductos.entidades.IReporteProducto;
import com.example.appproductos.entidades.Producto;
import com.example.appproductos.repositorio.RepositorioProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NegocioProducto {
    @Autowired
    private RepositorioProducto repositorioProducto;

    public Producto registrar(Producto producto){
        return repositorioProducto.save(producto);
    }
    public List<Producto> obtenerProductos(){
        return repositorioProducto.findAll();
    }
    public Producto obtenerProducto(Long codigo){
        return repositorioProducto.findById(codigo).get();
    }
    public List<IReporteProducto> obtenerReporte(){
        return repositorioProducto.obtenerReporte();
    }
    public double obtenerIGV(Producto producto){
        return 0.18*producto.getPrecio();
    }
    public double buscarIGV(Producto producto){
          Producto producto1 = obtenerProducto(producto.getCodigo());
          return  obtenerIGV(producto1);
    }

}
