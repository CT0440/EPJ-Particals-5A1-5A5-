import java.io.*;
import java.net.*;

public class ChatClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (
            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            System.out.println("Connected to chat server");

            // Thread to listen for messages from server
            new Thread(() -> {
                try {
                    String serverMessage;
                    while ((serverMessage = in.readLine()) != null) {
                        System.out.println("Friend: " + serverMessage);
                    }
                } catch (IOException e) {
                    System.out.println("Disconnected from server.");
                }
            }).start();

            // Read messages from user and send to server
            String input;
            while ((input = userInput.readLine()) != null) {
                out.println(input); // send only, don't print locally
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
