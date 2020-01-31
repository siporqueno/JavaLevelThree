package lesson_1.tasks_two_methods;

import java.util.Arrays;

public class GenMethDemo {
    static String[] arrStr = {"Uno", "Dos", "Tres", "Cuatro", "Cinco"};
    static Integer[] arrInt = {1, 2, 3, 4, 5};
    static GenMeth genMeth = new GenMeth();

    public static void main(String[] args) {
//        Test of Home work, task 1
        System.out.println(Arrays.toString(arrStr));
        System.out.println(genMeth.swap(arrStr, 2, 4));
        System.out.println(Arrays.toString(arrStr));
        System.out.println(genMeth.swap(arrStr, 3, -2));
        System.out.println(Arrays.toString(arrStr));

//        Test of Home work, task 2
        System.out.println(genMeth.<String>asArrayList(arrStr));
        System.out.println(genMeth.<String>asArrayList(arrStr).size());

        System.out.println(genMeth.<Integer>asArrayList(arrInt).getClass().getName());
        System.out.println(genMeth.<Integer>asArrayList(arrInt));

    }
}
