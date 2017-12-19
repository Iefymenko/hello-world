package com.efimenko.clientserver;

import java.net.*;
import java.io.*;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Server {
    static Logger logger = Logger.getLogger(Server.class.getName());

    public static void main(String[] args) {
        ServerSocket s = null;
        try {
            s = new ServerSocket(5432);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            try (Socket socket = s.accept();
                 ObjectInputStream input = new ObjectInputStream(socket.getInputStream());) {
                logger.info(String.valueOf(input.readObject()));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
