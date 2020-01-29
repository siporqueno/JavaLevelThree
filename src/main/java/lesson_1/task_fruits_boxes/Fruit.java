package lesson_1.task_fruits_boxes;

public abstract class Fruit {
    private float weight;

    public Fruit() {
    }

    public Fruit(float weight) {
        this.weight = weight;
    }

    public float getWeight() {
        return weight;
    }
}
