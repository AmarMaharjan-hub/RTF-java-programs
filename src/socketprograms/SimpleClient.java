package socketprograms;
import java.net.*;
import java.io.*;

public class SimpleClient {
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream output = null;

    public SimpleClient(String address, int port){
        // establish a connection
        try
        {
            socket = new Socket(address, port);
            System.out.println("Connected");
// takes input from terminal
            input = new DataInputStream(System.in);
// sends output to the socket
            output = new DataOutputStream(socket.getOutputStream());
        }
        catch(UnknownHostException u)
        {
            System.out.println(u);
        }
        catch(IOException i)
        {
            System.out.println(i);
        }// string to read message from input
        String line = "";
// keep reading until "Over" is input
        while (!line.equals("Over"))
        {
            try
            {
                line = input.readLine();
                output.writeUTF(line);
            }
            catch(IOException i)
            {
                System.out.println(i);
            }
        }
// close the connection
        try
        {
            input.close();
            output.close();
            socket.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }
    public static void main(String args[]) {
        SimpleClient client = new SimpleClient("127.0.0.1", 5000);
    }

}
