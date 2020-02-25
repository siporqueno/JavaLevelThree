package lesson_8;

import java.util.ArrayList;

public class Node {
    int id;
    ArrayList<Node> childs = new ArrayList<>();

    public Node(int id) {
        this.id = id;
    }

    void info() {
        System.out.println("id: " + id);
    }
}
