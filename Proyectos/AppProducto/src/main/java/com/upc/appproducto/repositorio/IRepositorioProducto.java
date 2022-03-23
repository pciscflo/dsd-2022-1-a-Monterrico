package com.upc.appproducto.repositorio;

import com.upc.appproducto.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IRepositorioProducto extends JpaRepository<Producto,Long> {
    @Query("SELECT p FROM Producto p WHERE p.precio<=:xprecio")
    public List<Producto> buscarPrecio(@Param("xprecio") double xprecio);
    public Producto findByPrecioAndDesripcion(double precio, String descripcion);
}
