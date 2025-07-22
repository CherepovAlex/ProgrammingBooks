package exercise;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try {


            Socket chatSocketIn = new Socket("127.0.0.1", 5000);
            InputStreamReader sream = new InputStreamReader(chatSocketIn.getInputStream());
            BufferedReader reader = new BufferedReader(sream);
            String message = reader.readLine();

            Socket chatSocketOut = new Socket("127.0.0.1", 5000);
            PrintWriter writer = new PrintWriter(chatSocketIn.getOutputStream());
            writer.println("Message from server: ");
            writer.println("Another message");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}