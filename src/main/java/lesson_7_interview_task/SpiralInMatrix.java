package lesson_7_interview_task;

public class SpiralInMatrix {
    public static int[][] matrix;
    public static final int SIZE_X = 5;
    public static final int SIZE_Y = 5;

    public static void main(String[] args) {
        SpiralInMatrix sp = new SpiralInMatrix();
        sp.initMatrix();
        sp.printMatrix();
        sp.fillInMatrix(SIZE_X, SIZE_Y, matrix);
        sp.printMatrix();
    }

    public void initMatrix() {
        matrix = new int[SIZE_X][SIZE_X];
        for (int[] row : matrix) {
            for (int e : row) e = 0;
        }
    }

    public void printMatrix() {
        System.out.println("---------");
        for (int i = 0; i <= SIZE_X; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE_Y; i++) {
            System.out.print((i + 1) + "|");
            for (int j = 0; j < SIZE_X; j++) {
                System.out.print(matrix[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println("---------");
    }

    public void fillInMatrix(int sizeX, int sizeY, int[][] matr) {
        final int elemTotalNo = sizeX * sizeY;
        int dirX = 1;
        int dirY = 0;
        // current position
        int x = 0;
        int y = 0;
        // plan for next step
        int xPlan = 0;
        int yPlan = 0;
        double angle = 0;
        int elemNo = 0;
        while (elemNo < elemTotalNo) {
            elemNo++;
            matr[yPlan][xPlan] = elemNo;
            xPlan = x + dirX;
            yPlan = y + dirY;
            if (xPlan < 0 || sizeX <= xPlan || yPlan < 0 || sizeY <= yPlan || matr[yPlan][xPlan] != 0) {
                // turn direction (dirX, dirY) right by 90 degrees
                angle += Math.PI / 2;
                dirX = (int) Math.cos(angle);
                dirY = (int) Math.sin(angle);
                xPlan = x + dirX;
                yPlan = y + dirY;
            }
//            elemNo++;
//            matr[yPlan][xPlan] = elemNo;
        }
    }
}
