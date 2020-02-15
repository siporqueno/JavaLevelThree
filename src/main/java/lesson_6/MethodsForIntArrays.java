package lesson_6;

public class MethodsForIntArrays {

    //    Home work of Lesson 6, task 1
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

    //    Home work of Lesson 6, task 2
    public boolean isOnlyOneAndFourInside(int[] inputArr) {
        int counterOfOnes = 0;
        int counterOfFours = 0;
        int counterOfOthers = 0;
        for (int a : inputArr)
            switch (a) {
                case 1:
                    counterOfOnes++;
                    break;
                case 4:
                    counterOfFours++;
                    break;
                default:
                    counterOfOthers++;
            }
        if (counterOfOnes > 0 && counterOfFours > 0 && counterOfOthers == 0) return true;
        return false;
    }
}
