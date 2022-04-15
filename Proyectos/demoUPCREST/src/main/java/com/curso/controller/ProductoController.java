package com.curso.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.entidades.Producto;
import com.curso.negocio.Negocio;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
public class ProductoController {
   @Autowired
   public Negocio negocio;
   Logger logger = LoggerFactory.getLogger(ProductoController.class);
   
   @GetMapping("/productos")
   public List<Producto>  obtenerProductos(){
	   return negocio.obtenerProductos();
   }



   @PostMapping("/producto")
   public Producto crearProducto(@Valid @RequestBody Producto producto) {
       Producto p;
       try {
           logger.debug("Creando objeto");
           p = negocio.crearProducto(producto);
       }catch(Exception e){
           logger.error("Error de creación",e);
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se pudo crear, sorry", e);
       }
	   return p;
   }

   @PutMapping("/producto")
   public Producto actualizarProducto(@Valid @RequestBody Producto productoDetalle) {
       Producto producto;
       try {
           logger.debug("Actualizando producto");
           producto = negocio.actualizarProducto(productoDetalle);
           logger.debug("Producto Actualizado");
           return producto;
       } catch (Exception e) {
           logger.error("Error de Actualización ", e);
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se pudo actualizar, sorry");
       }
   }
   
   @DeleteMapping("/producto/{codigo}")
   public Producto borrarProducto(@PathVariable(value = "codigo") Long codigo){
       try {
           logger.debug("Eliminando objeto");
           return negocio.borrarProducto(codigo);
       } catch (Exception e) {
           logger.error("Error de Eliminación ", e);
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se pudo eliminar, sorry");
       }
   }


    @GetMapping("/entidad/{codigo}")
    public Producto obtenerEntidad(@PathVariable(value = "codigo") Long codigo){
        Producto p;
        try {
            logger.debug("Buscando entidad");
            p = negocio.obtenerEntidad(codigo);
        }catch(Exception e){
            logger.error("Error de Obtener Entidad");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Mi mensaje");
        }
        return p;
    }
   
}
