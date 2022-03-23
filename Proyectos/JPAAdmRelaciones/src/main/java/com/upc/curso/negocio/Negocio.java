package com.upc.curso.negocio;

import java.util.List;
import java.util.Optional;

import com.upc.curso.repositorios.IEstado;
import com.upc.curso.repositorios.IFiltro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.curso.entidades.Cliente;
import com.upc.curso.entidades.Pedido;
import com.upc.curso.repositorios.ClienteRepositorio;
import com.upc.curso.repositorios.PedidoRepositorio;

@Service
public class Negocio {

	@Autowired ClienteRepositorio clienteRepositorio;
	@Autowired PedidoRepositorio pedidoRepositorio;
	
	public Cliente obtenerCliente(String dni) {
		return clienteRepositorio.buscarCliente(dni);
	}
	
	public Cliente obtenerCliente(Long numeroPedido){
		Optional<Pedido> pedido = pedidoRepositorio.findById(numeroPedido);
		return pedido.get().getCliente();
	}
	public Cliente registrarCliente(Cliente cliente ) {
		return clienteRepositorio.save(cliente);
	}

	public List<Pedido> obtenerPedidosDNI(String dni){
		Cliente cliente = clienteRepositorio.buscarCliente(dni);
		return cliente.getPedidos();
	}
	public List<IFiltro> obtenerReportePedidosIGV2(String dni){
		Cliente cliente = clienteRepositorio.buscarCliente(dni);
		return pedidoRepositorio.obtenerReporteIGV2();
	}
	public Pedido realizarPedido(String dni, Pedido pedido){
		Cliente cliente = clienteRepositorio.buscarCliente(dni);
		pedido.setCliente(cliente);// ojo
		pedido.setCodigoRespuesta("00");// enviado
		return pedidoRepositorio.save(pedido);
	}
	public Pedido realizarPedido2(Pedido pedido){
		return pedidoRepositorio.save(pedido);
	}

	public List<IEstado> obtenerEstados(){
		return pedidoRepositorio.obtenerEstados();
	}
}

