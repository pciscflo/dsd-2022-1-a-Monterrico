package com.example.appproductos;

import com.example.appproductos.entidades.IReporteProducto;
import com.example.appproductos.entidades.Producto;
import com.example.appproductos.negocio.NegocioProducto;
import com.example.appproductos.repositorio.RepositorioProducto;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class AppProductosApplicationTests {
    @Autowired
    private NegocioProducto negocioProducto;

    @Test
    void contextLoads() {
    }

    @Test
    public void probarRegistrar() {
        Producto producto = new Producto();
        producto.setPrecio(4);
        producto.setDescripcion("Fanta");
        producto.setStock(12);
        Producto r = null;
        r = negocioProducto.registrar(producto);
        Assert.assertNotNull(r);
    }

    @Test
    public void obtenerProductos() {
        List<Producto> lista = null;
        lista = negocioProducto.obtenerProductos();
        for (Producto p : lista) {
            System.out.println(p.toString());
        }
        Assert.assertEquals(2, lista.size());
    }

    @Test
    public void probarBuscqueda() {
        Producto producto = null;
        producto = negocioProducto.obtenerProducto(1L);
        System.out.println(producto.toString());
        Assert.assertNotNull(producto);
    }

    @Test
    public void probarReporte() {
        List<IReporteProducto> reporte = null;
        reporte = negocioProducto.obtenerReporte();
        for (IReporteProducto p : reporte) {
            System.out.println(p.getCodigo() + "  " + p.getDescripcion() + "  " + p.getImpuesto());
        }
        Assert.assertNotNull(reporte);
    }

    @Test
    public void probarBuscarIGV(){
        Producto producto = new Producto();
        producto.setCodigo(2L);
        double igv =  negocioProducto.buscarIGV(producto);
        System.out.println(igv);
    }
}