package com.curso.negocio;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.curso.entidades.Producto;
import com.curso.repositorio.ProductoRepositorio;
@Service
public class Negocio {
	   @Autowired
	   public ProductoRepositorio productoRepositorio;

	   
	   public List<Producto>  obtenerProductos(){
		   return (List<Producto>) productoRepositorio.findAll();
	   }

	   public Producto obtenerEntidad(Long codigo) throws Exception{
		return productoRepositorio.findById(codigo).orElseThrow(() -> new Exception("No se encontró entidad"));
	}

	   
	   public Producto crearProducto(Producto producto) {
		   return productoRepositorio.save(producto);
	   }

	   
	   public Producto actualizarProducto(Producto productoDetalle) throws Exception {
		   Producto producto = productoRepositorio.findById(productoDetalle.getCodigo()).orElseThrow(() -> new Exception("No se encontró entidad"));
		   producto.setDescripcion(productoDetalle.getDescripcion());
		   producto.setPrecio(productoDetalle.getPrecio());
		   return productoRepositorio.save(producto);
	   }

	   public Producto borrarProducto(Long codigo) throws Exception{
		   Producto producto = productoRepositorio.findById(codigo).orElseThrow(() -> new Exception("No se encontró entidad"));
		   productoRepositorio.delete(producto);
		   return producto;
	   }   
}
