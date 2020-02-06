package lesson_3.task_4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static final int PORT = 8189;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT);
             Socket socket = server.accept()) {
            ObjectInputStream inStr = new ObjectInputStream(socket.getInputStream());
            Message msgIn = (Message) inStr.readObject();
            System.out.println("Объект класса Message после получения его на сервере от клиента и десериализации: " + msgIn);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
