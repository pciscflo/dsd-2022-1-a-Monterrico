package com.upc.colasjms1.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.upc.colasjms1.entidades.Auto;
import com.upc.colasjms1.jms.JsmProductor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
public class AutosRest {
    @Autowired
    private JsmProductor jsmProductor;

    @PostMapping("/auto")
    public Auto enviar(@RequestBody Auto auto){
        ObjectMapper mapper = new ObjectMapper();
        //Convierte Objeto Auto a String Json
        String jsonAuto;
        try {
            jsonAuto = mapper.writeValueAsString(auto);
            jsmProductor.send(jsonAuto);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Lo siento");
        }
        return auto;
    }
}
