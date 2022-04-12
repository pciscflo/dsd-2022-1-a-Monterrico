package com.upc.banco.appbancorelaciones.rest;


import com.upc.banco.appbancorelaciones.entidades.Cliente;
import com.upc.banco.appbancorelaciones.entidades.Cuenta;
import com.upc.banco.appbancorelaciones.entidades.Operacion;
import com.upc.banco.appbancorelaciones.negocio.NegocioOperaciones;
import com.upc.banco.appbancorelaciones.repositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BancoRest {

	@Autowired
	private NegocioOperaciones negocioOperaciones;
	@Autowired
	private ClienteRepositorio clienteRepositorio;

	@PostMapping("/cliente")
	public Cliente registrar(@RequestBody Cliente cliente){
		return clienteRepositorio.save(cliente);
	}

	@PostMapping("/deposito")
	public Operacion deposito(@RequestBody Operacion operacion) {
		return negocioOperaciones.deposito(operacion);
	}

	@PostMapping("/transferencia")
	public Operacion transferencia(@RequestBody Operacion operacion) {
		return negocioOperaciones.transferencia(operacion);
	}
	@GetMapping("/cuentas/{dni}")
	public List<Cuenta> obtenerCuentas(@PathVariable(name="dni") String dni){
		List<Cuenta> cuentas = clienteRepositorio.obtenerCliente(dni).getCuentas();
		return cuentas;
	}

}
