package com.upc.curso.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upc.curso.entidades.Cliente;
import com.upc.curso.entidades.Pedido;
import com.upc.curso.negocio.Negocio;


@RestController
@RequestMapping("/api")
public class TiendaRest {
	@Autowired
	private Negocio negocio;
	
	@PostMapping("/cliente")
	public Cliente registrar(@RequestBody Cliente cliente) {
		return negocio.registrarCliente(cliente);
	}
	
	@GetMapping("/cliente/{dni}")
	public Cliente	obtenerCliente(@PathVariable(value="dni") String dni) {
		return negocio.obtenerCliente(dni);
	}
	@GetMapping("/cliente/pedido/{numeroPedido}")
	public Cliente obtenerCliente(@PathVariable(value="numeroPedido") Long numeroPedido) {
		return negocio.obtenerCliente(numeroPedido);
	}
	@GetMapping("/pedidos/cliente/{dni}")
	public List<Pedido> obtenerPedidos(@PathVariable(value = "dni") String dni){
		return negocio.obtenerPedidosDNI(dni);
	}
	@PostMapping("/hacerPedido/{dni}")
	public Pedido realizarPedido(@PathVariable(value = "dni") String dni, @RequestBody Pedido pedido){
       return negocio.realizarPedido(dni, pedido);
	}

}