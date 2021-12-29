package com.click13.Netzwerk;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.SocketException;

public abstract class Server implements Runnable {
    private ServerSocket socket;
    int timeout;
    int port;

    public Server(int timeout, int port){
        try {
            this.timeout = timeout;
            this.port = port;
            this.socket = new ServerSocket(port);
            socket.setSoTimeout(timeout);
        }
        catch (SocketException socketException){
            socketException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public int getPort(){
        return port;
    }

    public int getTimeout(){
        return timeout;
    }

    public abstract void run();
}
