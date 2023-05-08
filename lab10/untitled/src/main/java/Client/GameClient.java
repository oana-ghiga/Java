package Client;
import java.net.*;
import java.io.*;

public class GameClient {
    private String serverAddress;
    private int serverPort;

    public GameClient(String serverAddress, int serverPort) {
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
    }

    public void start() {
        try (
                Socket socket = new Socket(serverAddress, serverPort);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))
        ) {
            String userInput;

            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                String serverResponse = in.readLine();
                System.out.println(serverResponse);

                if (userInput.equals("EXIT")) {
                    break;
                }
            }
        } catch (UnknownHostException e) {
            System.err.println("Error connecting to server: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error communicating with server: " + e.getMessage());
        }
    }
}
