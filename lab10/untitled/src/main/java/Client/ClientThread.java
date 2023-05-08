package Client;
import Server.Game;

import java.net.*;
import java.io.*;

public class ClientThread extends Thread {
    private Socket clientSocket;
    private Game game;
    private boolean stopped = false;

    public ClientThread(Socket socket, Game game) {
        this.clientSocket = socket;
        this.game = game;
    }

    public void run() {
        try (
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        ) {
            String inputLine;

            while (!stopped && (inputLine = in.readLine()) != null) {
                System.out.println("Received command: " + inputLine);

                String[] parts = inputLine.split("\\s+");
                String command = parts[0];

                switch (command) {
                    case "CREATE":
                        String gameId = game.createGame();
                        out.println("Game created with ID " + gameId);
                        break;
                    case "JOIN":
                        if (parts.length < 2) {
                            out.println("Error: no game ID specified");
                            break;
                        }
                        String joinId = parts[1];
                        String joinResult = game.joinGame(joinId);
                        out.println(joinResult);
                        break;
                    case "MOVE":
                        if (parts.length < 4) {
                            out.println("Error: invalid move syntax");
                            break;
                        }
                        String moveGameId = parts[1];
                        int moveX = Integer.parseInt(parts[2]);
                        int moveY = Integer.parseInt(parts[3]);
                        String moveResult = game.makeMove(moveGameId, moveX, moveY);
                        out.println(moveResult);
                        break;
                    case "EXIT":
                        stopped = true;
                        out.println("Server stopped");
                        break;
                    default:
                        out.println("Error: invalid command");
                }
            }

            clientSocket.close();
        } catch (IOException e) {
            System.err.println("Error handling client request: " + e.getMessage());
        }
    }
}
