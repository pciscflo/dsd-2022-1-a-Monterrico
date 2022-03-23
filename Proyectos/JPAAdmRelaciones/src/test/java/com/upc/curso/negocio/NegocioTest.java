package com.upc.curso.negocio;

import com.upc.curso.entidades.Cliente;
import com.upc.curso.entidades.Pedido;
import com.upc.curso.repositorios.IEstado;
import com.upc.curso.repositorios.IFiltro;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class NegocioTest {

    @Autowired
    private Negocio negocio;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void obtenerCliente() {
    }

    @Test
    public void obtenerCliente1() {
    }

    //@Test
    public void registrarCliente() {
        Cliente cliente = new Cliente();
        cliente.setDni("77777777");
        cliente.setEmail("nueve@gmail.com");
        cliente.setNombre("Carlos");
        cliente.setTelefono("99999999");
        negocio.registrarCliente(cliente);
        assertEquals(cliente, cliente);
    }

    //@Test
    public void obtenerEstados(){
        List<IEstado> estados =  negocio.obtenerEstados();
        for(IEstado p:estados){
            System.out.println(p.getEstado() + "  " + p.getTotal());
        }
        Assert.assertNotNull(estados);
    }

    @Test
    public void obtenerReportePedidosIGV2() {
        List<IFiltro> pedidos = negocio.obtenerReportePedidosIGV2("09888345");
        for (IFiltro p:pedidos){
            System.out.println(p.getCodigo() + " " + p.getDescripcion() + "  " + p.getImpuesto());
        }
        Assert.assertNotNull(pedidos);
    }

    @Test
    public void obtenerPedidosDNI() {
    }

    //@Test
    public void realizarPedido() {
        Cliente cliente = negocio.obtenerCliente("09888345");
        Pedido pedido = new Pedido();
        pedido.setDescripcion("Yogurt");
        pedido.setEstado("process");
        pedido.setPrecio(9);
        pedido.setCliente(cliente);// ojo
        pedido.setCodigoRespuesta("01");
        pedido.setCliente(cliente);
        negocio.realizarPedido2(pedido);
    }

}