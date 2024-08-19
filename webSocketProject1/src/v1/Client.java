package v1;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("this is the client running...");

        Socket socket =new Socket("localhost", 8090);
        System.out.println("server connected");

        //send a message to the server
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeUTF("Hello server, I am the client");
        dataOutputStream.flush();
        dataOutputStream.close();

    socket.close();
    }
}
