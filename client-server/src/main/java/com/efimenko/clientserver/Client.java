package com.efimenko.clientserver;

import java.net.*;
import java.io.*;

public class Client {
    public static void main(String args[]) {
        try (Socket s1 = new Socket("localhost", 5432);
             ObjectOutputStream output = new ObjectOutputStream(s1.getOutputStream());) {
            output.writeObject(new Message("Hi there"));
        } catch (ConnectException connExc) {
            System.err.println("Could not connect.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
