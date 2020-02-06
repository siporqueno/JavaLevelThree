package lesson_3.task_4;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    static final int PORT = 8189;
    static final String IP_ADDRESS = "localhost";

    public static void main(String[] args) {
        try (Socket socket = new Socket(IP_ADDRESS, PORT)) {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            Message msgOut = new Message("Test message", "Hello, Server!");
            System.out.println("Объект класса Message до сериализации и отправки на сервер: " + msgOut);
            out.writeObject(msgOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
