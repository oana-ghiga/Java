package Server;
import Client.ClientThread;

import java.net.*;
import java.io.*;

public class GameServer {
    private int portNumber;
    private ServerSocket serverSocket;
    private boolean stopped = false;
    private Game game;

    public GameServer(int portNumber) {
        this.portNumber = portNumber;
        this.game = new Game();
    }

    public void start() {
        try {
            serverSocket = new ServerSocket(portNumber);
            System.out.println("Game server started on port " + portNumber);

            while (!stopped) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected");

                ClientThread client = new ClientThread(clientSocket, game);
                client.start();
            }

            System.out.println("Game server stopped");
            serverSocket.close();
        } catch (IOException e) {
            System.err.println("Error starting game server: " + e.getMessage());
        }
    }

    public void stop() {
        stopped = true;
    }
}
