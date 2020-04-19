import java.net.*;
import java.io.*;

public class Client{
        public static void main(String args[]){
        //Attempt socket connection, loop until one is made
        Scheduler scheduler = null;
        try{
            boolean scanning = true;
            while(scanning){
                try {
                    scheduler = new Scheduler(new Socket("127.0.0.1", 50000));
                    scanning = false;
                } catch (ConnectException e) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException i) {
                        System.out.println(i);
                    }
                }
            }
            
            System.out.println("Connected");

            scheduler.wakeUp();
            //comp3100 folder must be in the same folder as ds-sim
            Parser parser = new Parser("system.xml");
            scheduler.allToLargest(parser.servers);
            scheduler.writeToStream("QUIT");

            scheduler.socket.close();
        }
        catch(UnknownHostException e){
            System.out.println(e);
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
}