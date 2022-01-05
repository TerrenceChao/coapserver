package com.fih.coapserver;

import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapHandler;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.Utils;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.elements.exception.ConnectorException;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class CoAPClientSubscriber {

    public static void main(String[] args) throws ConnectorException, IOException, URISyntaxException {
        URI uri = null;
        uri = new URI("coap://127.0.0.1:5684/mqtt/mqtt_to_coap?c=client1&u=tom&p=secret");
        CoapClient client = new CoapClient(uri)
            .useCONs()
            .useExecutor()
            ;

        // sync
//        CoapResponse resource = client.get();
//        if (resource != null) {
//            System.out.println(resource.getCode());
//            System.out.println(resource.getOptions());
//            System.out.println(resource.getResponseText());
//            System.out.println("\nAdvanced\n");
//            System.out.println(Utils.prettyPrint(resource));
//        }

        // async
        client.observeAndWait(new CoapHandler() {
            @Override
            public void onLoad(CoapResponse resource) {
                System.out.println("\nAdvanced\n");
                System.out.println(resource.getCode());
                System.out.println(resource.getOptions());
                System.out.println(resource.getResponseText());
//                System.out.println(resource.getOptions());
//                System.out.println(Utils.prettyPrint(resource));
            }

            @Override
            public void onError() {
                System.out.println("didn't receive anything");
            }
        });

//        Request request = new Request(CoAP.Code.PUT)
////                .setObserve()
//                .setOptions(uri)
//                .setPayload("this is what I want to say");
//
//        // async
//        client.observe( request, new CoapHandler() {
//            @Override
//            public void onLoad(CoapResponse resource) {
//                System.out.println("\nAdvanced PUT\n");
//                System.out.println(resource.getCode());
//                System.out.println(resource.getOptions());
//                System.out.println(resource.getResponseText());
//            }
//
//            @Override
//            public void onError() {
//                System.out.println("didn't receive anything");
//            }
//        });
    }
}
