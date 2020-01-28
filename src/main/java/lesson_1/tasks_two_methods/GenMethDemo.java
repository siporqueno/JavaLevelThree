package lesson_1.tasks_two_methods;

import java.util.Arrays;

public class GenMethDemo {
    static String[] arrInt = {"Uno", "Dos", "Tres", "Cuatro", "Cinco"};
    static GenMeth genMeth = new GenMeth();

    public static void main(String[] args) {
//        Test of Home work, task 1
        System.out.println(Arrays.toString(arrInt));
        System.out.println(genMeth.swap(arrInt, 2, 4));
        System.out.println(Arrays.toString(arrInt));
        System.out.println(genMeth.swap(arrInt, 3, -2));
        System.out.println(Arrays.toString(arrInt));
    }
}
