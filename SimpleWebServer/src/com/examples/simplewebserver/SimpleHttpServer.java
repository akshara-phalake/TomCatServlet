package com.examples.simplewebserver;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;

public class SimpleHttpServer {
    public static int DEFAULT_PORT = 8663;
    public static int port;
    private HttpServer httpServer;

    public static void main(String[] args) {
        SimpleHttpServer webServer = new SimpleHttpServer();
        webServer.start(DEFAULT_PORT);
    }

    private void start(int port) {
        this.port = port;
        try {
            httpServer =HttpServer.create(new InetSocketAddress(port) , 0);
            System.out.println("Server Started at port " + port);
            httpServer.createContext("/" , new Handlers.RootHandler());
            httpServer.setExecutor(null);
            httpServer.start();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}