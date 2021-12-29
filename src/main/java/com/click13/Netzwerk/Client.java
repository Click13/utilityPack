package com.click13.Netzwerk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {

    Socket client;

    public Client(String serverName, int port){
        try {
            client = new Socket(serverName, port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(String text) throws IOException {
        DataOutputStream out = new DataOutputStream(client.getOutputStream());
        out.writeUTF(text);
    }

    public String read() throws IOException {
        DataInputStream in = new DataInputStream(client.getInputStream());
        return in.readUTF();
    }

    public void close() throws IOException {
        client.close();
    }
}
