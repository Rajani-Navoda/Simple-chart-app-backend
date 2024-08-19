package v5;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ServerClientThread extends Thread{
    private Socket socket;

    public ServerClientThread(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run(){
        try {
            //read the message coming from client
            System.out.println("Client connected...");
            InputStream inputStream = socket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);

            OutputStream outputStream = socket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            Scanner scanner = new Scanner(System.in);


            String message ="";
            while(!message.equals("stop")) {
                message = dataInputStream.readUTF();
                System.out.println("Client says :" + message);

                String messageToClient = scanner.nextLine();
                dataOutputStream.writeUTF(messageToClient);
                dataOutputStream.flush();
            }

        }catch (IOException exception){
            exception.printStackTrace();
        }


    }
}
