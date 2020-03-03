package lesson_7.annot;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Starter {
    public static void main(String[] args) {
        start(FirstTestClass.class);
    }

    public static void start(Class testClass) {
        Object testClassInstance = null;

        try {
            testClassInstance = testClass.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        boolean isMethBeforeSuiteFound = false;
        boolean isMethAfterSuiteFound = false;
        Method beforeSuite = null;
        Method afterSuite = null;
        Queue<Method> testMethods = new PriorityQueue<>(Comparator.comparingInt(m -> 10 - m.getAnnotation(Test.class).value().level));
        Method[] methods = testClass.getDeclaredMethods();
        for (Method m : methods) {
            if (m.getAnnotation(BeforeSuite.class) != null) {
                if (isMethBeforeSuiteFound)
                    throw new RuntimeException("The method annotated @BeforeSuite is not UNIQUE!!!");
                beforeSuite = m;
                isMethBeforeSuiteFound = true;
            }

            if (m.getAnnotation(AfterSuite.class) != null) {
                if (isMethAfterSuiteFound)
                    throw new RuntimeException("The method annotated @AfterSuite is not UNIQUE!!!");
                afterSuite = m;
                isMethAfterSuiteFound = true;
            }

            if (m.getAnnotation(Test.class) != null) testMethods.offer(m);
        }

        try {
            if (beforeSuite != null) beforeSuite.invoke(testClassInstance, null);
            while (!testMethods.isEmpty()) testMethods.poll().invoke(testClassInstance, null);
            if (afterSuite != null) afterSuite.invoke(testClassInstance, null);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
