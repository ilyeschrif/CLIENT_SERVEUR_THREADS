package ClientPackage;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class GestionClient extends Thread{

    private Socket sk;
    private int numClient;


    public GestionClient(int numClient,Socket socket)
    {
        this.numClient=numClient;
        this.sk=socket;
    }

    public void run()
    {

        try {
            OutputStream os = this.sk.getOutputStream();
            PrintWriter pw = new PrintWriter(os,true);

            pw.println("Bienvenue, vous etes le Client numero : " + numClient);

            // Récupérer l'adresse IP du client
            InetSocketAddress address = (InetSocketAddress) sk.getRemoteSocketAddress();
            String ipClient = address.getAddress().getHostAddress();

            // Afficher les détails du client sur le serveur
            System.out.println("Client n°" + numClient + " - Adresse IP : " + ipClient);


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }



    }
}
