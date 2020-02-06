package lesson_3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

// Home work of Lesson 3, task 1
public class FileReaderAndWriterToConsole {
    static File fileToRead = new File("src\\main\\resources\\hw_files_lesson_3\\1_hw.txt");

    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream(fileToRead)) {
            byte[] arr = new byte[64];

            int x;
            while ((x = in.read(arr)) > 0) {
                System.out.println(Arrays.toString(arr));
                System.out.print(new String(arr, 0, x, "UTF-8"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
