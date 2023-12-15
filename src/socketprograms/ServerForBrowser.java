package socketprograms;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ServerForBrowser {

    private Socket socket = null;

    private ServerSocket serverSocket = null;

    private DataInputStream dataInputStream = null;

    private DataOutputStream dataOutputStream = null;

    private PrintWriter printWriter = null;

    private Scanner scanner = null;

    public ServerForBrowser(int port){
        try{
            serverSocket = new ServerSocket(port);
            System.out.println("Server Started\nWaiting for client...");
            socket = serverSocket.accept();
            System.out.println("Client Accepted");
//            dataInputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
//            dataOutputStream = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            printWriter = new PrintWriter(socket.getOutputStream());
            scanner = new Scanner(socket.getInputStream());

            while(scanner.hasNextLine()){
                String text = scanner.nextLine();
                System.out.println("Text: " + text);
                sendPage(printWriter);
            }
//            sendPage(dataOutputStream);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void sendPage(PrintWriter printWriter){
        try{
//            dataOutputStream.writeUTF("HTTP/1.1 200 OK\r\n\r\n");
//            dataOutputStream.writeUTF("<html><title>Demo</title><body><h1>Server through browser Demo</h1></body></html>");
//            dataOutputStream.close();
            printWriter.println("HTTP/1.1 200 OK\r\n\r\n");
            printWriter.println("<html><title>Demo</title><body><h1>Server through browser Demo</h1></body></html>");
            printWriter.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        ServerForBrowser obj1 = new ServerForBrowser(5000);
    }
}
