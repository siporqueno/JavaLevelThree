package lesson_4;

// Synchronization via object
public class CyclicLettersTyperObjectSync {
    private final Object mon = new Object();
    private char currentLetter = 'A';

    public static void main(String[] args) {
        CyclicLettersTyperObjectSync typer = new CyclicLettersTyperObjectSync();
        new Thread(()->typer.printLetter('A', 'B')).start();
        new Thread(()->typer.printLetter('B', 'C')).start();
        new Thread(()->typer.printLetter('C', 'A')).start();
    }

    public void printLetter(char curLet, char nextLet) {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != curLet)
                        mon.wait();
                    System.out.print(curLet);
                    currentLetter = nextLet;
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
