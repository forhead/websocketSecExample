package com.aws.secworkshop.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.glassfish.tyrus.server.Server;

public class webSocketServer {
	
	public static void main (String[] args) throws IOException {
		runServer();
	}
	public static void runServer() {
        Server server = new Server("localhost", 8080, "/sec", sampleServerEndpoint.class);

        try {
            server.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Please press a key to stop the server.");
            reader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            server.stop();
        }
    }

}
