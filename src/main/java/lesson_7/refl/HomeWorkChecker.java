package lesson_7.refl;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import static java.util.concurrent.TimeUnit.HOURS;
import static java.util.concurrent.TimeUnit.MINUTES;

public class HomeWorkChecker {
    private static File dirOfHomeWorks = new File("src\\main\\resources\\hw_to_check_lesson_7");
    private final ScheduledExecutorService scheduler =
            Executors.newScheduledThreadPool(1);


    public static void main(String[] args) {
        HomeWorkChecker homeWorkChecker = new HomeWorkChecker();
        homeWorkChecker.checkHworksPeriodically(dirOfHomeWorks);
    }

    public void checkHworksPeriodically(File pathToDir) {
        Runnable checker = () -> this.checkSomeHomeWorks(pathToDir);
        ScheduledFuture<?> checkerHandle =
                scheduler.scheduleAtFixedRate(checker, 0, 3, MINUTES);
        Runnable canceller = () -> checkerHandle.cancel(true);
        scheduler.schedule(canceller, 1, HOURS);
    }

    public void checkSomeHomeWorks(File pathToDir) {
        String[] classFiles = pathToDir.list((dir, name) -> name.endsWith(".class"));
        if (classFiles.length == 0) throw new RuntimeException("No .class files have been found!!!");
        Arrays.stream(classFiles).forEach(fileName -> checkOneHomeWorkFile(fileName.split("\\.")[0]));
    }

    public void checkOneHomeWorkFile(String fileNameWithoutDotClass) {
        Class cHw = null;
        try {
            cHw = URLClassLoader.newInstance(new URL[]{
                    dirOfHomeWorks.toURI().toURL()}).loadClass(fileNameWithoutDotClass);
            Constructor constructor = cHw.getConstructor();
            Object hw = constructor.newInstance();

            // call of method "calculate" for int arguments
            Method calculateInt = cHw.getDeclaredMethod("calculate", int.class, int.class, int.class, int.class);
            calculateInt.setAccessible(true);
            System.out.println("Call of method calculate for int, using formula a*(b+(c/d)) and params 2, 2, 6, 3 returns " + calculateInt.invoke(hw, 2, 2, 6, 3) + "\n");

            // call of method "calculate" for float arguments
            Method calculateFloat = cHw.getDeclaredMethod("calculate", float.class, float.class, float.class, float.class);
            calculateFloat.setAccessible(true);
            System.out.println("Call of method calculate for float, using formula a*(b+(c/d)) and params 1.5f, 0.5f, 3f, 2f returns " + calculateFloat.invoke(hw, 1.5f, 0.5f, 3f, 2f) + "\n");

            // call of method "checkTwoNumbers"
            Method checkTwoNumbers = cHw.getDeclaredMethod("checkTwoNumbers", int.class, int.class);
            checkTwoNumbers.setAccessible(true);
            System.out.println("Call of method checkTwoNumbers to check if their sum is within [10, 20] for 5 and 10 returns " + checkTwoNumbers.invoke(hw, 5, 10) + "\n");

            // call of method "printIsPositive"
            Method printIsPositive = cHw.getDeclaredMethod("printIsPositive", int.class);
            printIsPositive.setAccessible(true);
            System.out.print("Call of method printIsPositive to print positive/negative if the given number is positive/negative prints the following for -5: ");
            printIsPositive.invoke(hw, -5);

            // call of method "isNegative"
            Method isNegative = cHw.getDeclaredMethod("isNegative", int.class);
            isNegative.setAccessible(true);
            System.out.println("\nCall of method isNegative to return true if the given number is negative returns the following for -5: " + isNegative.invoke(hw, -5) + "\n");

            // call of method "printWelocome"
            Method printWelocome = cHw.getDeclaredMethod("printWelocome", String.class);
            printWelocome.setAccessible(true);
            System.out.print("Call of method printWelocome to print Welcome name, where name - parameter prints the following for the parameter Astra: ");
            printWelocome.invoke(hw, "Astra");

            // call of method "isLeapYear"
            Method isLeapYear = cHw.getDeclaredMethod("isLeapYear", int.class);
            isLeapYear.setAccessible(true);
            System.out.println("\nCall of method isLeapYear returns " + isLeapYear.invoke(hw, 2020) + " for the year 2020\n");

            // call of method "main"
            Method main = cHw.getDeclaredMethod("main", String[].class);
            System.out.println("Call of method main:");
            Thread.sleep(1000);
            main.invoke(hw, new Object[]{new String[]{}});

        } catch (ClassNotFoundException | MalformedURLException | InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException | InterruptedException e) {
            System.out.println("Something went wrong inside the method checkOneHomeWorkFile:");
            e.printStackTrace();
        }
    }
}
