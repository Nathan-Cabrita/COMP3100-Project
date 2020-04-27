import java.net.*;
import java.io.*;

public class Client{
        public static void main(String args[]){
        //Attempt socket connection, loop until one is made
        Scheduler scheduler = null;

        String arg;
        String method = "allToLargest";

        //check args kinda messy but it works refactor if you want
        String err = "Correct format: java Client OR java Client -a <method>. Type java Client -h for help.";
        if(args.length == 2){
            arg = args[0];
            if(arg.equals("-a") && (args[1].equals("ff") || args[1].equals("bf") || args[1].equals("wf"))){
                method = args[1];
            } else {
                System.out.println("Incorrect Usage. " + err);
                System.exit(0);
            }
        } else if(args.length > 2){
            System.out.println("Too many arguments. " + err);
            System.exit(0);
        } else if(args.length == 1) {
            if(args[0].equals("-h")){
                System.out.println(err);
                System.out.println("Methods: ff - first fit : bf - best fit : wf - worst fit");
                System.exit(0);
            } else {
                System.out.println("Incorrect argument. " + err);
                System.exit(0);
            }
        } else {
            method = "atl";
        }

        System.out.println(method);

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

            Parser parser = new Parser("../ds-sim/system.xml");

            //run algorithm based on command line argument given
            if(method.equals("ff"))
                scheduler.allToLargest(parser.servers);
            else if(method.equals("bf"))
                scheduler.allToLargest(parser.servers);
            else if(method.equals("wf"))
                scheduler.allToLargest(parser.servers);
            else
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