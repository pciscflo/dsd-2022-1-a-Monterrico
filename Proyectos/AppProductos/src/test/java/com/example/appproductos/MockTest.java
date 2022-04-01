package com.example.appproductos;

import com.example.appproductos.entidades.Producto;
import com.example.appproductos.negocio.NegocioProducto;
import com.example.appproductos.repositorio.RepositorioProducto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MockTest {
    @Autowired
    private NegocioProducto negocioProducto;
    @MockBean
    private RepositorioProducto repositorioProducto;

    @Test
    public void registrarTest(){
        Producto producto = new Producto();
        producto.setCodigo(1L);
        producto.setDescripcion("Leche");
        producto.setPrecio(5);
        producto.setStock(100);
        when(repositorioProducto.save(producto)).thenReturn(producto);
        Assert.assertEquals(producto, negocioProducto.registrar(producto));
    }


}
