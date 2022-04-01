package com.example.appproductos.repositorio;

import com.example.appproductos.entidades.IReporteProducto;
import com.example.appproductos.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioProducto extends JpaRepository<Producto,Long> {
   @Query("SELECT p.codigo AS codigo, p.descripcion AS descripcion, p.precio AS precio," +
           " p.precio*0.18 as impuesto FROM Producto p")
    List<IReporteProducto> obtenerReporte();

}
