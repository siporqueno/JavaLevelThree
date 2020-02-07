package lesson_4;

// Synchronization via "syncronized" in method signature
public class CyclicLettersTyperMethodSync {
    private char currentLetter = 'A';

    public static void main(String[] args) {
        CyclicLettersTyperMethodSync typer = new CyclicLettersTyperMethodSync();
        new Thread(() -> typer.printLetter('A', 'B')).start();
        new Thread(() -> typer.printLetter('B', 'C')).start();
        new Thread(() -> typer.printLetter('C', 'A')).start();
    }

    public synchronized void printLetter(char curLet, char nextLet) {
        try {
            for (int i = 0; i < 5; i++) {
                while (currentLetter != curLet)
                    wait();
                System.out.print(curLet);
                currentLetter = nextLet;
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
