package Netzwerk;

import java.io.IOException;
import java.net.InetAddress;

public class Ping {
    public static void sendPingRequest(String Adresse){
        try{
            InetAddress address = InetAddress.getByName(Adresse);
            System.out.print("Sende Ping Request an " + Adresse);
            if (address.isReachable(5000)){
                System.out.print("System ist erreichbar!");
            }
            else{
                System.out.print("System ist nicht erreichbar!");
            }
        }catch (IOException e){
            e.printStackTrace();
            System.out.print("System ist nicht erreichbar!");
        }
    }
}