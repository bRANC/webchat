package voice.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import webcum.kiiras;

public class ChatServer extends Thread {

    public int port = 6969;
    kiiras ki;

    public ChatServer(int port) {
        this.ki = ki;
        System.out.println("MultiUser Voice Chat server starting...");
        this.port = port;
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Listening on port " + port);
            while (true) {
                socket = serverSocket.accept();
                System.out.println("Connection receive from " + socket.getRemoteSocketAddress());
                ChatHandler handler = new ChatHandler(socket);
                handler.start();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                serverSocket.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
}
