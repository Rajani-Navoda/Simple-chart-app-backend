package v2;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

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
        String message ="";
        while(!message.equals("stop")){
            message = dataInputStream.readUTF();
            System.out.println("Client says :" + message);
        }
        serverSocket.close();
    }
}