package com.upc.jms.prueba;

import org.springframework.jms.annotation.JmsListener;

public class JmsOyente {
    @JmsListener(destination="${jms.cola.destino}")
    public void miMensaje(String mensaje) {
        System.out.println("SUNAT: Recibido:" + mensaje);

    }
}
