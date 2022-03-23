package com.upc.appproducto;

import com.upc.appproducto.entidades.Producto;
import com.upc.appproducto.negocio.NegocioProducto;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class AppProductoApplicationTests {
    //inyectando al negocio para probarlo
    @Autowired
    private NegocioProducto negocioProducto;

    @Test
    void contextLoads() {
    }
    @Test
    public void probarRegistro(){
        Producto producto = new Producto();
        producto.setPrecio(2);
        producto.setDescripcion("Sublime");
        producto.setStock(50);
        Producto p;
        p = negocioProducto.registrar(producto);
        Assert.assertNotNull(p);

    }
    @Test
    public void probarListado(){
        List<Producto> listado;
        listado = negocioProducto.obtenerListado();
        for(Producto p: listado){
            System.out.println(p.toString());
        }
        Assert.assertNotNull(listado);
    }
    @Test
    public void probarListaPrecio(){
        List<Producto> lista ;
        lista = negocioProducto.obtenerListaPrecio(2);
        for(Producto p: lista){
            System.out.println(p.toString());
        }
        Assert.assertNotNull(lista);
    }
    @Test
    public void probarActualizar(){
        Producto producto = new Producto(1L,"Leche",5, 50);
        try {
            producto = negocioProducto.actualizarProducto(producto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void probarDescuento(){
        Producto producto = new Producto();
        producto.setCodigo(2L);
        double descuento = negocioProducto.calcularDescuento(producto);
        Assert.assertEquals(0.5, descuento, 0.01);
    }

}
