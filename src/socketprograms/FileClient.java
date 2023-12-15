package socketprograms;
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class FileClient {
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream output = null;
    private Scanner scan = new Scanner(System.in);

    public FileClient(String address, int port){
        try{
            socket = new Socket(address,port);
            System.out.println("Connected");
            input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            output = new DataOutputStream(socket.getOutputStream());

        }catch(Exception e){
            e.printStackTrace();
        }
        String request = "";
        while(!request.equals("Over")){
            try{
                request = scan.nextLine();
                output.writeUTF(request);
                while(input.readBoolean()){
                    String response = input.readUTF();
                    if(response.length() < 65535){
                        System.out.println(response);
                    }else{
                        System.out.print(response);
                    }
                }


            }catch(Exception e){
                e.printStackTrace();
            }
        }

        try{
            input.close();
            output.close();
            socket.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        FileClient client = new FileClient("127.0.0.1", 5000);
    }
}
