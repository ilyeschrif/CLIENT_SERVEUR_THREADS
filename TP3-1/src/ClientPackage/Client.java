package ClientPackage;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {
    private static final String SERVER_IP = "192.168.56.1";

    private static final int PORT =1234;
public static void main(String [] args)
{

    try{

        // Obtient l'adresse IP du serveur
        InetAddress serverAddress = InetAddress.getByName(SERVER_IP);

        //Crée une adresse IP et un port pour le serveur
        InetSocketAddress serverSocketAddress = new InetSocketAddress(serverAddress, PORT);

        //se connecte au serveur en utilisant l'adresse IP et le port spécifiés
        Socket sk = new Socket(serverSocketAddress.getAddress(), serverSocketAddress.getPort());

        InputStream is = sk.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader bfr = new BufferedReader(isr);
        System.out.println(bfr.readLine());




        sk.close();
    }
    catch(Exception e)
    {
        System.out.println(e.getMessage());
    }



}





}
