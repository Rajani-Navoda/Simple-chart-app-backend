package v3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("this is the server running...");
        ServerSocket serverSocket = new ServerSocket(8090);
        System.out.println("waiting for client to connect...");
        Socket socket = serverSocket.accept();
        System.out.println("Client connected...");

        //read the message coming from client
        InputStream inputStream = socket.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);

        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

        Scanner scanner = new Scanner(System.in);


        String message ="";
        while(!message.equals("stop")){
            message = dataInputStream.readUTF();
            System.out.println("Client says :" + message);

            String messageToClient = scanner.nextLine();
            dataOutputStream.writeUTF(messageToClient);
            dataOutputStream.flush();

        }
        serverSocket.close();
    }
}