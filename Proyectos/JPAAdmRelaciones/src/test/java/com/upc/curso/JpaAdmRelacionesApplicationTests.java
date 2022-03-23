package com.upc.curso;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import com.upc.curso.entidades.Filtro;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import com.upc.curso.entidades.Cliente;
import com.upc.curso.entidades.Pedido;
import com.upc.curso.repositorios.ClienteRepositorio;
import com.upc.curso.repositorios.PedidoRepositorio;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
//@SpringBootTest
public class JpaAdmRelacionesApplicationTests {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private ClienteRepositorio clienteRepositorio;
	@Autowired
	private PedidoRepositorio pedidoRepositorio;

	//@Test
	public void testCrearCliente() {
		Cliente cliente = new Cliente();
		cliente.setDni("09888345");
		cliente.setEmail("cpepe2@gmail.com");
		cliente.setNombre("Pepe2");
		cliente.setTelefono("997208982");
		clienteRepositorio.save(cliente);
		assertEquals(cliente, cliente);
	}
	//@Test
	public void testCrearPedido() {
		Cliente cliente = clienteRepositorio.buscarCliente("09888345");
		Pedido pedido = new Pedido();
		pedido.setDescripcion("Trago");
		pedido.setEstado("process");
		pedido.setPrecio(50);
		pedido.setCliente(cliente);// ojo
		pedido.setCodigoRespuesta("00");// enviado
		pedidoRepositorio.save(pedido);

	}

	@Test
	public void testListarClientes() {
		List<Cliente> clientes = (List<Cliente>) clienteRepositorio.findAll();
		for(Cliente cliente:clientes){
			System.out.println(cliente.getNombre() +"  " + cliente.getDni());
		}
		assertNotNull(clientes);
	}

	//@Test
	public void testPedidosDelClienteDNI(){
		Cliente cliente = clienteRepositorio.buscarCliente("09888345");
		List<Pedido>  pedidos = cliente.getPedidos();
		for(Pedido pedido:pedidos){
			System.out.println(pedido.getCodigo() + "  " + pedido.getDescripcion() +" " + pedido.getPrecio());
		}
	}

    //@Test
	public void testObtenerClientesSQL(){
		Cliente cliente =  clienteRepositorio.obtenereClienteSQL("09888345");
		System.out.println(cliente.getNombre() + "  " + cliente.getEmail());
		assertNotNull(cliente);
	}
	//@Test
	public void testObtenerReporte(){
		List<Filtro> list = pedidoRepositorio.obtenerReporteIGV();
		for (Filtro p:list){
			System.out.println(p.getDescripcion() +"  " + p.getMonto_igv());
		}
	}
}
