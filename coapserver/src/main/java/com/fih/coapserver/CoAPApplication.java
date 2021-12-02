package com.fih.coapserver;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.CoapServer;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.server.resources.CoapExchange;

import java.text.SimpleDateFormat;
import java.util.Date;



public class CoAPApplication {

    public static void main(String[] args) {
        CoapServer server = new CoapServer(5684, 5685, 5686, 5687);
        server.add(new CoapResource("hello") {
            @Override
            public void handleGET(CoapExchange exchange) {
                exchange.respond(CoAP.ResponseCode.CONTENT, "Hello CoAP!!! (Java CoAP Server)");
            }
        });
        server.add(new CoapResource("time") {
            @Override
            public void handleGET(CoapExchange exchange) {
                Date date = new Date();
                exchange.respond(CoAP.ResponseCode.CONTENT, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
            }
        });

        server.start();
        System.out.println("CoAP server start successfully");
    }
}
