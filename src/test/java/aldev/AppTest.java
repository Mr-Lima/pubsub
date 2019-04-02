package aldev;

import java.net.ServerSocket;
import java.net.Socket;

public class AppTest {
    public static void main(String[] args) {
        int port = 2020;
        boolean close = false;

        try {

            ServerSocket serverSocket = new ServerSocket(port);

            System.out.println("SERVER INICIADO EM: " + port);

            do {
                Socket clientSocket = serverSocket.accept();
                ClientTest doninha = new ClientTest(clientSocket);
            } while (true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
