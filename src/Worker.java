//import libraries
import java.io.*;
import java.net.*;

public class Worker extends Thread {
    int a;
    int b;
    Worker(int a, int b) {
        this.a = a;
        this.b = b;
    }
        public void run() {
            ObjectOutputStream out= null ;
            ObjectInputStream in = null ;
            Socket requestSocket= null ;


            try {

                /* Create socket for contacting the server on port 4321*/

                requestSocket = new Socket("localhost", 4321);

                /* Create the streams to send and receive data from server */
                out = new ObjectOutputStream(requestSocket.getOutputStream());
                in = new ObjectInputStream((requestSocket.getInputStream()));
                /* Write the two integers */

                Test t =new Test(a,b);
                out.writeObject(t);
                out.flush();

                /* Print the received result from server */
                Test t2= (Test) in.readObject();
                System.out.println("Server>" + t2.getA() +" "+ t2.getB()); /*in.readInt());*/
            } catch (UnknownHostException unknownHost) {
                System.err.println("You are trying to connect to an unknown host!");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (ClassNotFoundException e){
                throw new RuntimeException(e);

            }  finally{
                try {
                    in.close(); out.close();
                    requestSocket.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
    public static void main(String[] args) {
        Worker w1 = new Worker(1,2);
        Worker w2 = new Worker(3,4);
        w1.start();
        w2.start();
    }

}
