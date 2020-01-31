package lesson_1.task_fruits_boxes;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> fruits = new ArrayList<>();

    public Box() {
    }

    public Box(List<T> fruits) {
        this.fruits = fruits;
    }

    public void add(T fruit) {
        fruits.add(fruit);
    }

    public float getWeight() {
        return fruits.stream().map(Fruit::getWeight).reduce(0f, Float::sum);
    }

    public boolean compare(Box<?> anotherBox) {
        return getWeight() == anotherBox.getWeight();
    }

    public void pourInto(Box<T> boxReceiver) {
        fruits.forEach(boxReceiver::add);
        fruits.clear();
    }

    public int getFruitsNumber() {
        return fruits.size();
    }
}
