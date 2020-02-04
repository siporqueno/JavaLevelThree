package lesson_3;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;

// Home work of Lesson 3, task 2
public class JoinerOfFiles {
    static File firstFileToJoin = new File("src\\main\\resources\\hw_files_lesson_3\\2_hw_first.txt");
    static File secondFileToJoin = new File("src\\main\\resources\\hw_files_lesson_3\\2_hw_second.txt");
    static File thirdFileToJoin = new File("src\\main\\resources\\hw_files_lesson_3\\2_hw_third.txt");
    static File fourthtFileToJoin = new File("src\\main\\resources\\hw_files_lesson_3\\2_hw_fourth.txt");
    static File fifthFileToJoin = new File("src\\main\\resources\\hw_files_lesson_3\\2_hw_fifth.txt");
    static File outputFile = new File("src\\main\\resources\\hw_files_lesson_3\\2_hw_result.txt");

    public static void main(String[] args) {
        ArrayList<InputStream> aLiInStr = new ArrayList<>();
        try {
            aLiInStr.add(new FileInputStream(firstFileToJoin));
            aLiInStr.add(new FileInputStream(secondFileToJoin));
            aLiInStr.add(new FileInputStream(thirdFileToJoin));
            aLiInStr.add(new FileInputStream(fourthtFileToJoin));
            aLiInStr.add(new FileInputStream(fifthFileToJoin));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try (SequenceInputStream in = new SequenceInputStream(Collections.enumeration(aLiInStr));
             FileWriter out = new FileWriter(outputFile)) {
            byte[] arr = new byte[128];
            int x;
            while ((x = in.read(arr)) != -1) {
                out.write(new String(arr, 0, x, StandardCharsets.UTF_8));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
