package lesson_3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

// Home work of Lesson 3, task 3
public class PagerToConsoleForLargeFile {
    static File inputFile = new File("src\\main\\resources\\hw_files_lesson_3\\3_hw_large_file.txt");
    private static Scanner scanner = new Scanner(System.in);
    private static final long PAGE_SIZE = 1800;

    public static void main(String[] args) {
        System.out.println("The book's title is War and Peace, 4 times. Its author is Leo Tolstoy. It has 720 pages. Have a pleasant reading!");
        int pageNumber = -1;
        while (true) {
            char[] arr = new char[1800];
            while (true) {
                System.out.println("\nPlease enter page number in the range from 1 to 7320 to read it or 0 to quit.");
                try {
                    pageNumber = scanner.nextInt();
                    if (0 <= pageNumber && pageNumber <= 7320) break;
                    System.out.println("THIS IS NOT A VALID NUMBER!!!");
                } catch (InputMismatchException e) {
                    System.out.println(scanner.next() + " IS NOT A NUMBER AT ALL!!!");
                }
            }
            if (pageNumber == 0) break;
            long t = System.currentTimeMillis();
            try (BufferedReader br = new BufferedReader(new FileReader(inputFile), 2048)) {
                br.skip((pageNumber - 1) * PAGE_SIZE);
                br.read(arr);
                System.out.println(arr);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("\nTime spend to go to, read and display the page is " + (System.currentTimeMillis() - t) + " milliseconds");
        }
//            Let's count number of pages. One page contains PAGE_SIZE number of characters.
            /*long y;
            int counter = 0;
            while ((y = br.skip(PAGE_SIZE)) > 0) {
                counter++;
            }
            System.out.println("Total no of pages: " + counter);*/
    }

}
