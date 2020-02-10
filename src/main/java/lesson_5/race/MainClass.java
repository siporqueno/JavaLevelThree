package lesson_5.race;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class MainClass {
    public static final int CARS_COUNT = 4;
    public static CountDownLatch cdlRaceBeginning = new CountDownLatch(CARS_COUNT);
    public static CountDownLatch cdlRaceEnd = new CountDownLatch(CARS_COUNT);
    public static CyclicBarrier cb = new CyclicBarrier(CARS_COUNT);
    private static boolean winFlag;

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
        try {
            cdlRaceBeginning.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        try {
            cdlRaceEnd.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }

    public static synchronized void announceTheWinner(String name) {
        if (!winFlag) {
            System.out.println(name + " WIN");
            winFlag = true;
        }
    }
}
