import java.net.*;
import java.io.*;

public class Client{

    private Socket socket = null;
    String message;
    


    private void writeToStream(Socket socket, String msg){
        try {
            OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream());
            out.write(msg);// string, byte[]
            out.flush();
            
        } catch (IOException e) {
            System.out.println(e);
        }

        
    }

    private void wakeUp(){
        //Sends HElO and AUTH commands to server
        writeToStream(socket, "HELO");
        readFromStream(socket);
        writeToStream(socket, "AUTH COMP");
        readFromStream(socket);
    }

    private void collectJobs(){
        int jobCounter = 0;
        //Tells server to begin 
        writeToStream(socket, "REDY");
        while(readFromStream(socket).subSequence(0, 4).equals("JOBN")){
            writeToStream(socket, "SCHD " + jobCounter+ " large 0");
            jobCounter++;
            readFromStream(socket);
            writeToStream(socket, "REDY");
        }
    }

    
    
    private String readFromStream(Socket socket){
        byte[] readMsg = new byte[1024];
        
        try{
            DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            in.read(readMsg); 
            
            
        } catch(IOException e){
            System.out.println(e);
        }

        String message = new String(readMsg);
        System.out.println(message);
        
        return message;
}

    public Client(String address, int port){
        
        //Open connection
        try{
            socket = new Socket(address, port);
            message = "";
            System.out.println("Connected");
        }
        catch(UnknownHostException e){
            System.out.println(e);
        }
        catch(IOException e){
            System.out.println(e);
        }

        wakeUp();
        collectJobs();
        writeToStream(socket, "QUIT");
        
        
        //Close connection
        try{       
            socket.close(); 
        } 
        catch(IOException i) { 
            System.out.println(i); 
        } 
    }
    public static void main(String args[]) {
        Client client = new Client("127.0.0.1", 50000);
    }
}