package frontend.formvalidation;
import java.net.*;
import java.io.*;
import java.util.Scanner;
public class FormValidation {
    private Socket socket = null;

    private ServerSocket serverSocket = null;

    private PrintWriter writer = null;

    private File file = null;

    FormValidation(int port){
        try{
            serverSocket = new ServerSocket(port);
            System.out.println("Server Started");

            while(true){
                try{
                    socket = serverSocket.accept();
                    writer = new PrintWriter(socket.getOutputStream());
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String request = bufferedReader.readLine();
                    String[] requestParameter = request.split(" ");
                    String data = requestParameter[1];

                    if(data.equals("/INITIALIZE_TABLE")){
                        initializeTable();
                        continue;
                    }
                    data = data.replace("/id=", "");
                    data = data.replace("/name=", "");
                    data = data.replace("/age=", "");


                    String[] details = data.split("&");

                    String response = "";

                    if(validate(details).equals("VALID_DATA") && Integer.parseInt(details[0]) <= getFileLineCount()){
                        updateTable(details);
                        response = "UPDATE_DATA," + details[0] + "," + details[1] + "," + details[2];
                    }else if(validate(details).equals("VALID_DATA")){
                        store(details);
                        response = "ADD_DATA," + details[0] + "," + details[1] + "," + details[2];
                    }else{
                        response = validate(details);
                    }

                    clientResponse(response);

                }catch(Exception e){
                    e.printStackTrace();
                }finally{
                    writer.flush();
                    writer.close();
                    socket.close();
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void initializeTable(){
        file = new File("E:\\new java\\NewJavaPrograms\\src\\frontend\\formvalidation\\user_data.txt");
        String response = "";
        Scanner scanner;
        try{
            if(file.exists()){
                scanner = new Scanner(file);
                while(scanner.hasNextLine()){
                    response += scanner.nextLine() + "/";
                }
                response += "\b";
                clientResponse(response);
                scanner.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void clientResponse(String response){
        writer.write("HTTP/1.1 200 OK\r\n");
        writer.write("Access-Control-Allow-Origin : *\r\n");
        writer.write("Content-Type: plain/text\r\n");
        writer.write("Content-Length:"+response.length()+"\r\n");
        writer.write("\r\n");
        writer.write(response);

        writer.flush();
    }


    public String validate(String[] details){

        if(details.length < 3 || details[1].isEmpty()){
            return "EMPTY_FIELD";
        }
        if(!details[1].matches("^[a-zA-Z]*$")){
            return "INVALID_NAME_CHARACTER";
        }
        if(details[1].length() < 3){
            return "LOW_NAME_CHARACTER";
        }
        if(Integer.parseInt(details[2]) < 0){
            return "NEGATIVE_AGE";
        }
        return "VALID_DATA";
    }
    public void store(String[] details){

        file = new File("E:\\new java\\NewJavaPrograms\\src\\frontend\\formvalidation\\user_data.txt");
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            if(file.length() != 0){
                fileWriter.write("\n");
            }
            fileWriter.write(details[0] + "," + details[1] + "," + details[2]);
            fileWriter.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public int getFileLineCount(){
        file = new File("E:\\new java\\NewJavaPrograms\\src\\frontend\\formvalidation\\user_data.txt");
        Scanner scanner;
        int count = 0;
        try{
            if(file.exists()){
                scanner = new Scanner(file);
                while(scanner.hasNextLine()){
                    scanner.nextLine();
                    count++;
                }
                scanner.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return count;
    }

    public void updateTable(String[] details){
        file = new File("E:\\new java\\NewJavaPrograms\\src\\frontend\\formvalidation\\user_data.txt");
        Scanner scanner;
        try{
            if(file.exists()){
                scanner = new Scanner(file);
                String update = "";
                while(scanner.hasNextLine()){
                    String[] data = scanner.nextLine().split(",");
                    if(data[0].equals(details[0])){
                        update += data[0] + "," + details[1] + "," + details[2];
                    }else{
                        update += data[0] +","+ data[1] +","+ data[2];
                    }

                    if(scanner.hasNextLine()){
                        update += "\n";
                    }
                }
                scanner.close();
                try {
                    FileWriter fileWriter = new FileWriter(file);
                    fileWriter.write(update);
                    fileWriter.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FormValidation object1 = new FormValidation(5000);
    }
}
