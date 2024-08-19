package v3;

import javax.xml.crypto.Data;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("this is the client running...");

        Socket socket =new Socket("localhost", 8090);
        System.out.println("server connected");

        //send a message to the server
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

        InputStream inputStream = socket.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);

        String message ="";

            Scanner scanner = new Scanner(System.in);

            while (!message.equals("stop")){
                message = scanner.nextLine();
                dataOutputStream.writeUTF(message);
                dataOutputStream.flush();

                String severMessage = dataInputStream.readUTF();
                System.out.println("Server says: " + severMessage);
            }


        dataOutputStream.close();
        socket.close();
    }
}
