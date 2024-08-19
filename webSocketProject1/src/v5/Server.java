package v5;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("this is the server running...");
        ServerSocket serverSocket = new ServerSocket(8090);

        while(true){
            System.out.println("waiting for client to connect...");
            Socket socket = serverSocket.accept();
            ServerClientThread serverClientThread = new ServerClientThread(socket);
            serverClientThread.start();

            }
        }


    }
