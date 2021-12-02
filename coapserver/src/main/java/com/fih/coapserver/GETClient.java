package com.fih.coapserver;

import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.Utils;
import org.eclipse.californium.elements.exception.ConnectorException;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class GETClient {

    public static void main(String[] args) throws ConnectorException, IOException, URISyntaxException {
        URI uri = null;
        uri = new URI("localhost:5683/hello");
        CoapClient client = new CoapClient(uri);
        CoapResponse resource = client.get();
        if (resource != null) {
            System.out.println(resource.getCode());
            System.out.println(resource.getOptions());
            System.out.println(resource.getResponseText());
            System.out.println("\nAdvanced\n");
            System.out.println(Utils.prettyPrint(resource));
        }
    }
}
