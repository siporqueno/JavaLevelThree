package lesson_7_interview_task;

public class SpiralInMatrix {
    public static final int SIZE_X = 7;
    public static final int SIZE_Y = 5;
    public static int[][] matrix = new int[SIZE_Y][SIZE_X];

    public static void main(String[] args) {
        SpiralInMatrix sp = new SpiralInMatrix();
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
        // current position
        int x = 0;
        int y = 0;
        // plan for the next step
        int xPlan = 0;
        int yPlan = 0;
        // angle between current direction and X axis
        double angle = 0;
        // number of filled-in boxes
        int elemNo = 0;
        while (elemNo < elemTotalNo) {
            // Check plan first and change it if necessary (turn right)
            if (xPlan < 0 || sizeX <= xPlan || yPlan < 0 || sizeY <= yPlan || matr[yPlan][xPlan] != 0) {
                // turn direction (dirX, dirY) right by 90 degrees
                angle += Math.PI / 2;
                dirX = (int) Math.cos(angle);
                dirY = (int) Math.sin(angle);
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
