package lesson_1.task_calculator_lambda;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        useCalculator();
        scanner.close();
    }

    private static void useCalculator() {
        String operationSign = "a";
        float a = 0;
        float b = 0;
        float result = 0;
        while (true) {
            System.out.println("Введите знак операции: + для сложения или - для вычитания. Затем нажмите Enter");
            operationSign = scanner.next();
            if (operationSign.equals("+") || operationSign.equals("-")) break;
            System.out.println("Знак операции введен неверно.");
        }

        while (true) {
            System.out.println("Введите первое число и нажмите Enter");
            try {
                a = scanner.nextFloat();
                break;
            } catch (InputMismatchException e) {
                // scanner.next() "flushes" wrong input and the scanner becomes ready to scan again. Otherwise it will not stop (block) waiting for the next input!!!
                // Citation from java.util.Scanner docs: When a scanner throws an InputMismatchException, the scanner will not pass the token that caused the exception, so that it may be retrieved or skipped via some other method.
                System.out.println(scanner.next() + " - это не число!");
            }
        }

        while (true) {
            System.out.println("Введите второе число и нажмите Enter");
            try {
                b = scanner.nextFloat();
                break;
            } catch (InputMismatchException e) {
//                scanner.next() "flushes" wrong input and the scanner becomes ready to scan again. Otherwise it will not stop (block) waiting for the next input!!!
//                Citation from java.util.Scanner docs: When a scanner throws an InputMismatchException, the scanner will not pass the token that caused the exception, so that it may be retrieved or skipped via some other method.
                System.out.println(scanner.next() + " - это не число!");
            }
        }

        System.out.println(a + " " + operationSign + " " + b);

        if (operationSign.equals("+")) {
//            Addition
            Operationable operationAdd = ((x, y) -> x + y);
            result = operationAdd.calculate(a, b);

        } else {
//            Subtraction
            Operationable operationSub = ((x, y) -> x - y);
            result = operationSub.calculate(a, b);
        }

        System.out.println("Результат: " + result);
    }
}
