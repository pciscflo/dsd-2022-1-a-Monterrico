package com.upc.curso.repositorios;
import com.upc.curso.entidades.Filtro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.upc.curso.entidades.Pedido;

import java.util.List;

public interface PedidoRepositorio extends JpaRepository<Pedido, Long> {

    @Query("SELECT new com.upc.curso.entidades.Filtro(p.codigo, p.descripcion, p.precio, p.estado, p.precio*0.18)" +
            " FROM Pedido p")
    List<Filtro> obtenerReporteIGV();

    @Query("SELECT p.codigo as codigo, p.descripcion as descripcion, p.precio as precio, " +
            "p.estado as estado, p.precio*0.18 as impuesto" +
            " FROM Pedido p")
    List<IFiltro> obtenerReporteIGV2();

    @Query("SELECT c.codigo AS codigo, c.estado AS estado, COUNT(c.estado) AS total "
            + "FROM Pedido AS c GROUP BY c.estado ORDER BY c.descripcion")
    List<IEstado> obtenerEstados();
}
