package lesson_1.tasks_two_methods;

import java.util.ArrayList;
import java.util.Arrays;

public class GenMeth {
    //    Home work, task 1
    <T> boolean swap(T[] arr, int i, int j) {
        int len = arr.length;
        T temp;
        if (i == j || len <= i || i < 0 || len <= j || j < 0) {
            System.out.println("Swap failed. Please check indexes of the elements to be swapped and array length.");
            return false;
        }
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        System.out.println("Swap successful.");
        return true;
    }

    //    Home work, task 2
    <T> ArrayList<T> asArrayList(T[] arr) {
        ArrayList<T> arrayList = new ArrayList<>();
        Arrays.stream(arr).forEach(a -> arrayList.add(a));
        return arrayList;
    }
}
