FROM maven:3.8.4-openjdk-8

COPY target/coapserver-1.0-SNAPSHOT.jar /usr/src/coapserver/coapserver-1.0-SNAPSHOT.jar
COPY target/lib /usr/src/coapserver/lib

WORKDIR /usr/src/coapserver

EXPOSE 5684-5687/udp

CMD java -jar coapserver-1.0-SNAPSHOT.jar