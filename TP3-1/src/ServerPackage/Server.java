package ServerPackage;

import ClientPackage.GestionClient;

import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread{

    // port sur lequel le serveur écoutera les connexions entrantes
    private static final int PORT =1234;
    public static void main(String [] args)
    {

        try{
            // serveur socket qui écoutera sur le port
            ServerSocket ssk = new ServerSocket(PORT);

            // Compteur pour suivre le nombre de clients connectés
            int numClient=0;

            // Boucle infinie pour accepter les connexions des clients
            while(true)
            {
                numClient++;

                // Accepter la connexion du client
                Socket sk =ssk.accept();

                // Créez un nouveau thread GestionClient pour gérer la communication avec le client.
                Thread ThreadClient1 = new GestionClient(numClient,sk);

                // Démarrez le thread pour gérer le client
                ThreadClient1.start();

            }


            //ssk.close(); je ne peux pas utiliser ssk.close()
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        






    }

}
