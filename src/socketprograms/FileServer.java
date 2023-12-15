package socketprograms;
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class FileServer {
    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream input = null;
    private DataOutputStream output = null;
    private File file = null;
    private Scanner scan = null;

//    2286592
//65535
    public FileServer(int port){
        try{
            server = new ServerSocket(port);
            System.out.println("Server started");
            System.out.println("Waiting for client");
            socket = server.accept();
            System.out.println("Client Accepted");
            input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            output=new DataOutputStream(socket.getOutputStream());
            String clientRequest = "";
            while(!clientRequest.equals("Over")){
                try{
                    clientRequest = input.readUTF();
                    file = new File("E:\\new java\\NewJavaPrograms\\src\\socketprograms\\" + clientRequest);
                    if(file.exists()){
                        scan = new Scanner(file);
                        while(scan.hasNextLine()){
                            String content = scan.nextLine();
                            System.out.println(content);
                            if(content.length() > 65535){
                                int startIndex = 0;
                                int endIndex = 65534;
                                while(content.length()> endIndex){
                                    output.writeBoolean(true);
                                    output.writeUTF(content.substring(startIndex,endIndex));
                                    startIndex = endIndex + 1;
                                    endIndex = endIndex + 65534 + 1;
                                }
                                if(content.length() > endIndex){
                                    output.writeBoolean(true);
                                    output.writeUTF(content.substring(endIndex,content.length() - 1));
                                }
                            }else{
                                output.writeBoolean(true);
                                output.writeUTF(content);
                            }
                        }
                        output.writeBoolean(true);
                        output.writeUTF("--DOWNLOADED--");
                        output.writeBoolean(false);
                        scan.close();

                    }else{
                        if(clientRequest.equals("Over")){
                            output.writeBoolean(true);
                            output.writeUTF("Terminating connection");
                            output.writeBoolean(false);
                        }else{
                            output.writeBoolean(true);
                            output.writeUTF("File not Found");
                            output.writeBoolean(false);
                        }
                    }

                }catch(Exception e){
                    e.printStackTrace();
                }
            }

            System.out.println("Closing Connection");
            input.close();
            output.close();
            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        FileServer fileServer = new FileServer(5000);
    }

}
