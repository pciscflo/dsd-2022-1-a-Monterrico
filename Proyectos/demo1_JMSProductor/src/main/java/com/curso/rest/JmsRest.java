package com.curso.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.jms.JmsProducer;

@RestController
@RequestMapping("/api")
public class JmsRest {
    @Autowired
    private JmsProducer jmsProducer;
    
    @GetMapping("/enviar/{mensaje}")
    public String enviar(@PathVariable(value="mensaje") String mensaje) {
    	jmsProducer.send(mensaje);
        System.out.println("CLIENTE Envía:"+ mensaje);
    	return "OK!";
    }
	
}