package com.upc.banco.appbancorelaciones.repositorio;


import com.upc.banco.appbancorelaciones.entidades.Operacion;
import org.springframework.data.repository.CrudRepository;

public interface OperacionRepositorio extends CrudRepository<Operacion, Long>{

}
