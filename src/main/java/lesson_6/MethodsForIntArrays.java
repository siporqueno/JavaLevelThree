package lesson_6;

public class MethodsForIntArrays {

    public int[] reduceToAfterFour(int[] inputArr) {
        int len = inputArr.length;
        int[] outputArr = null;
        int lastFourPos = -1;

        for (int i = len - 1; i >= 0; i--) {
            if (inputArr[i] == 4) {
                lastFourPos = i;
                break;
            }
        }
        if (lastFourPos == -1) throw new RuntimeException("No digit 4 in the input Array!!!");
        outputArr = new int[len - lastFourPos - 1];
        System.arraycopy(inputArr, lastFourPos + 1, outputArr, 0, len - lastFourPos - 1);
        return outputArr;
    }
}
