package lesson_7_interview_task;

public class SpiralInMatrixWithoutAngleAndWithSinCosFormulas {
    public static final int SIZE_X = 7;
    public static final int SIZE_Y = 5;
    public static int[][] matrix = new int[SIZE_Y][SIZE_X];

    public static void main(String[] args) {
        SpiralInMatrixWithoutAngleAndWithSinCosFormulas sp = new SpiralInMatrixWithoutAngleAndWithSinCosFormulas();
        sp.fillInMatrix(SIZE_X, SIZE_Y, matrix);
        sp.printMatrix();
    }

    public void printMatrix() {
        System.out.println("---------");
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("---------");
    }

    public void fillInMatrix(int sizeX, int sizeY, int[][] matr) {
        final int elemTotalNo = sizeX * sizeY;
        // current direction
        int dirX = 1;
        int dirY = 0;
        // service variable used to store dirX when changing direction
        int temp = 0;
        // current position
        int x = 0;
        int y = 0;
        // plan for the next step
        int xPlan = 0;
        int yPlan = 0;
        // number of filled-in boxes
        int elemNo = 0;
        while (elemNo < elemTotalNo) {
            // Check plan first and change it if necessary (turn right)
            if (xPlan < 0 || sizeX <= xPlan || yPlan < 0 || sizeY <= yPlan || matr[yPlan][xPlan] != 0) {
                // turn direction (dirX, dirY) right by 90 degrees
                temp = dirX;
                // cos(X+Pi/2)=cosX*cosPi/2-sinX*sinPi/2
                dirX = -dirY;
                // sin(X+Pi/2)=sinX*cosPi/2+cosX*sinPi/2
                dirY = temp;

                xPlan = x + dirX;
                yPlan = y + dirY;
            }
            // Implement the plan: fill-in the box at (x,y)
            x = xPlan;
            y = yPlan;
            elemNo++;
            matr[yPlan][xPlan] = elemNo;
            // make a new plan
            xPlan = x + dirX;
            yPlan = y + dirY;
        }
    }
}
