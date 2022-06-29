package Zadanie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
public class Server
{
    private ServerSocket server;
    private Socket client;
    private BufferedReader in;
    private PrintWriter out;
    public void start()
    {
        try {
            server = new ServerSocket(3306);
            client = server.accept();
            out = new PrintWriter(client.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            while (true) {
                String ID = in.readLine();
                if ("ID".equals(ID)) {
                    out.println("Your data: ");
                }
                else {
                    out.println("Enter ID");
                }
            }
        }
        catch (IOException e) {
            e.getStackTrace();
        }
    }
    public void stop()
    {
        try {
            in.close();
            out.close();
            client.close();
            server.close();
        }
        catch (IOException e) {
            System.err.println("Error in stop");
        }
    }

    public void sendMessage(String message)
    {
        out.println(message);
    }



    public static void main(String[] args)
    {
        Server server = new Server();
        server.start();
    }
}