package Zadanie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private Socket client;
    private BufferedReader in;
    private PrintWriter out;

    public void startConnection() {
        try {
            client = new Socket("127.0.0.1", 3306);
            out = new PrintWriter(client.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));

            Thread t = new Thread();
            t.start();

        } catch (IOException e) {
            System.err.println("Error in startConnection Client");
        }
    }

    public String sendMessage(String message) throws IOException {
        out.println(message);
        String id = in.readLine();
        return id;
    }

    public void stopConnection() throws IOException {
        in.close();
        out.close();
        client.close();
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        Client client = new Client();
        client.startConnection();
        for (int i = 0; i < 50; i++) {
            System.out.println(client.sendMessage("test"));
            Thread.sleep(4_000);
        }
        client.stopConnection();
    }
}