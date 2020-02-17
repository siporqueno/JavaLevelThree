package lesson_6;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

//    Home work of Lesson 6, task 2
@RunWith(Parameterized.class)
public class TestClassForMethodIsOnlyOneAndFourInside {
    private MethodsForIntArrays methods;
    private int[] a;
    private int[] b;

    public TestClassForMethodIsOnlyOneAndFourInside(int[] a, int[] b) {
        this.a = a;
        this.b = b;
    }

    @Parameterized.Parameters
    public static Collection<int[][]> data() {
        return Arrays.asList(new int[][][]{
                {{1, 1, 1, 4, 4, 1, 4, 4}, {3, 3, 3}},
                {{1, 4}, {1, 1, 1, 1, 1, 1}},
                {{4, 1}, {4, 4, 4, 4}},
                {{1, 4}, {1, 4, 4, 1, 1, 4, 3}},
                {{4, 1}, {0, 1, -1, 2}}
        });
    }

    @Before
    public void init() {
        methods = new MethodsForIntArrays();
    }

    @Test
    public void testMethOneAndFourParams() {
        Assert.assertTrue(methods.isOnlyOneAndFourInside(a));
        Assert.assertFalse(methods.isOnlyOneAndFourInside(b));
    }
}
