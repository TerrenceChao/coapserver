package com.fih.coapserver;

import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.coap.Request;

import java.net.URI;
import java.util.Date;

public class CoAPClientPublisher {

    public static void main(String[] args) throws Exception {
        //創建一個資源請求資源，注意默認端口爲5683
        URI uri = new URI("coap://127.0.0.1:5684/mqtt/coap_to_mqtt?c=client1&u=tom&p=secret");
        CoapClient client = new CoapClient(uri);
        while (true) {
            String payload = "hello, " + new Date().toString();
            // 設置PUT的內容和內容的類型TEXT_PLAIN
            // CoapResponse response = client.put(payload, TEXT_PLAIN);
            // client.useCONs();
            // 設置PUT的內容和內容的類型APPLICATION_OCTET_STREAM
            // CoapResponse response = client.put(payload, APPLICATION_OCTET_STREAM);
            Request request = Request.newPut();
            request.setPayload("Hello, time: " + new Date().toString());
            CoapResponse response = client.advanced(request);
            System.out.println(response);
            Thread.sleep(2000);
        }

    }
}
