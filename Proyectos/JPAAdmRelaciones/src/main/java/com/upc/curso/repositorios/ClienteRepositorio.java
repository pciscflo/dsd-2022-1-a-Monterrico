package com.upc.curso.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.upc.curso.entidades.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

	 @Query("SELECT c FROM Cliente  c where c.dni=:dni")
	 Cliente buscarCliente(@Param("dni") String dni);

	 @Query(value = "SELECT  c.codigo_cliente, c.dni, c.nombre, c.email, c.telefono " +
			 "from TP_CLIENTE c where c.dni=:dni", nativeQuery = true)
	 Cliente obtenereClienteSQL(@Param("dni") String dni);

}

