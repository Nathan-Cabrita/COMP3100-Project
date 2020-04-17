import java.net.*;
import java.util.ArrayList;
import java.io.*;
import Config.*;

public class Scheduler{
    public Socket socket;

    public Scheduler(Socket socket){
        this.socket = socket;
    }

    //Write socket output to server
    public void writeToStream(String msg){
        try {
            OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream());
            out.write(msg);// string, byte[]
            out.flush();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    //Read socket input from server
    public String readFromStream(){
        byte[] readMsg = new byte[1024];
        
        try{
            DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            in.read(readMsg);   
        } catch(IOException e){
            System.out.println(e);
        }
        
        String message = new String(readMsg);
        return message;
    }

    //Sends HELO and AUTH commands to the server
    public void wakeUp(){
        writeToStream("HELO");
        readFromStream();
        //comp335 makes the test file work
        writeToStream("AUTH comp335");
    }

    //First scheduling algorithm, sends all jobs to largest server type
    //Accepts servers parsed from system.xml as a parameter
    public void allToLargest(ArrayList<Server> servers){
        //Gets first message after auth to initialize msg
        String msg = readFromStream();

        //Find the largest server by coreCount and set largest to that server
        Server largest = servers.get(0);
        for(Server item: servers){
            int temp = Integer.parseInt(item.coreCount);
            if(temp > Integer.parseInt(largest.coreCount)){
                largest = item;
            }
        }

        //Loop until no jobs left: NONE recieved
        while(!msg.subSequence(0, 4).equals("NONE")){
            //Send REDY when server sends OK: is ready for next job
            if(msg.subSequence(0, 2).equals("OK"))
                writeToStream("REDY");

            //Send SCHD when server sends JOBN: Schedule a job when one is recieved
            if(msg.subSequence(0, 4).equals("JOBN")){
                //Takes JOBN command and splits data into fields of a job object
                String[] splitter = msg.split(" ");
                Job job = new Job(splitter[1], splitter[2], splitter[3], splitter[4], splitter[5], splitter[6]);

                //Schedule job: SCHD jobID serverType serverID
                writeToStream("SCHD " + job.id + " " + largest.type + " 0");
            }
            //Get next message for loop
            msg = readFromStream();
        }
    }
}
