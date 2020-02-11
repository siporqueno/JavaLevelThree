package lesson_5;

public class MFU {

    Object printLock = new Object();
    Object scanLock = new Object();

    public void print(String doc, int n) {
        synchronized (printLock) {
            System.out.println("Начало печати " + doc);
            for (int i = 0; i < n; i++) {
                System.out.println("Печать " + doc + ", стр " + i);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Конец печати " + doc);
        }

    }

    public void scan(String doc, int n) {
        synchronized (scanLock) {
            System.out.println("Начало сканирования " + doc);
            for (int i = 0; i < n; i++) {
                System.out.println("Сканирование " + doc + ", стр " + i);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Конец сканирования " + doc);
        }
    }

    public void copy(String doc, int n) {
        System.out.println("Начало копирования " + doc+" посредством сканирования и, затем, печати");
        scan(doc, n);
        print(doc, n);
        System.out.println("Конец копирования " + doc+" посредством сканирования и, затем, печати");
    }

    public static void main(String[] args) {
        final MFU mfu = new MFU();

        new Thread(new Runnable() {
            @Override
            public void run() {
                mfu.print("Doc 1", 10);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                mfu.print("Doc 2", 5);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                mfu.scan("Doc 3", 5);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                mfu.copy("Doc 4", 10);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                mfu.print("Doc 5", 5);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                mfu.scan("Doc 6", 5);
            }
        }).start();

    }

}

