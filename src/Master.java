import java.io.*;
import java.util.*;
import java.time.*;
import java.lang.*;
import java.net.*;
public class Master {
    ServerSocket s;
    Socket providerSocket;



    void openServer() {
        try {

            /* Create Server Socket */
            s= new ServerSocket(4321, 10);

            while (true) {
                /* Accept the connection */
                providerSocket= s.accept();
                /* Handle the request */
                Thread d= new ActionsForClients(providerSocket);
                d.start();
            }

        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            try {
                providerSocket.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}





