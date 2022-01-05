package com.fih.coapserver;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.CoapServer;
import org.eclipse.californium.core.Utils;
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
                System.out.println("[GET] req options: " +exchange.getRequestOptions());
                exchange.respond(CoAP.ResponseCode.CONTENT, "Hello CoAP!!! (Java CoAP Server)");
            }
        });
        server.add(new CoapResource("time") {
            @Override
            public void handleGET(CoapExchange exchange) {
                System.out.println("[GET] req options: " +exchange.getRequestOptions());
                Date date = new Date();
                exchange.respond(CoAP.ResponseCode.CONTENT, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
                System.out.println("[GET] response");
            }
        });

        server.add(new CoapResource("time") {
            @Override
            public void handlePUT(CoapExchange exchange) {
                System.out.println("[PUT] req options: " +exchange.getRequestOptions());
                Date date = new Date();
                try {
                    Thread.sleep(5000);
                    exchange.respond(CoAP.ResponseCode.CONTENT, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
                    System.out.println("[PUT] response");
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        });

        server.start();
        System.out.println("CoAP server start successfully");
    }
}
