package com.upc.banco.appbancorelaciones.repositorio;

import com.upc.banco.appbancorelaciones.entidades.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ClienteRepositorio extends CrudRepository<Cliente, Long>{
    @Query("SELECT cli FROM Cliente cli WHERE cli.dni=:dni")
    Cliente obtenerCliente(@Param("dni") String dni);

}
