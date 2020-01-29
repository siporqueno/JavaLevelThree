package lesson_1.task_fruits_boxes;

public class FruitsBoxesDemo {
    static Box<Apple> boxOfApplesOne = new Box<>();
    static Box<Apple> boxOfApplesTwo = new Box<>();
    static Box<Orange> boxOfOrangesOne = new Box<>();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            boxOfApplesOne.add(new Apple(1f));
        }
        System.out.println(boxOfApplesOne.getWeight());

        for (int i = 0; i < 20; i++) {
            boxOfOrangesOne.add(new Orange(0.5f));
        }
        System.out.println(boxOfOrangesOne.getWeight());
        System.out.println(boxOfApplesOne.compare(boxOfOrangesOne));
        System.out.println(boxOfApplesTwo.compare(boxOfOrangesOne));
        System.out.println("Кол-во яблок в boxOfAppleOne: " + boxOfApplesOne.getFruitsNumber());
        System.out.println("Кол-во яблок в boxOfAppleTwo: " + boxOfApplesTwo.getFruitsNumber());
        System.out.println("Пересыпаем из первой коробки во вторую");
        boxOfApplesOne.pourInto(boxOfApplesTwo);
        System.out.println("Кол-во яблок в boxOfAppleOne: " + boxOfApplesOne.getFruitsNumber());
        System.out.println("Кол-во яблок в boxOfAppleTwo: " + boxOfApplesTwo.getFruitsNumber());
        System.out.println("Пересыпаем назад");
        boxOfApplesTwo.pourInto(boxOfApplesOne);
        System.out.println("Кол-во яблок в boxOfAppleOne: " + boxOfApplesOne.getFruitsNumber());
        System.out.println("Кол-во яблок в boxOfAppleTwo: " + boxOfApplesTwo.getFruitsNumber());
    }
}
