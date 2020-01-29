package lesson_1.task_fruits_boxes;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Fruit>{
    private List<T> fruits = new ArrayList<>();

    public Box() {
    }

    public Box(List<T> fruits) {
        this.fruits = fruits;
    }

    public void add(T fruit){
        fruits.add(fruit);
    }
}
