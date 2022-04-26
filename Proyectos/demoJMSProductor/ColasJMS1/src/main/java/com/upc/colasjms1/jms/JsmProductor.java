package com.upc.colasjms1.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JsmProductor {
    @Autowired
    private JmsTemplate jmsTemplate;
    @Value("${jms.cola.envio}")
    String destino;

    public void send(String mensaje){
        jmsTemplate.convertAndSend(destino,mensaje);
    }
}
