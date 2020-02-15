package lesson_6;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestClassForMethodReduceToAfterFour {
    private MethodsForIntArrays methods;
    private int[] a, b;

    public TestClassForMethodReduceToAfterFour(int[] a, int[] b) {
        this.a = a;
        this.b = b;
    }

    @Parameterized.Parameters
    public static Collection<int[][]> data() {
        return Arrays.asList(new int[][][]{
                {{1, 7}, {1, 2, 4, 4, 2, 3, 4, 1, 7}},
                {{3, 2, 1}, {1, 4, 3, 4, 5, 8, 8, 4, 3, 2, 1}},
                {{3}, {1, 2, 4, 3}},
                {{3, 2, 1}, {4, 3, 2, 1}}
        });
    }

    @Before
    public void init() {
        methods = new MethodsForIntArrays();
    }

    @Test(expected = RuntimeException.class)
    public void testExceptRunOne() {
        Assert.assertArrayEquals(new int[]{1, 2, 3}, methods.reduceToAfterFour(new int[]{1, 2, 3}));
    }

    @Test
    public void testExceptRunParams() {
        Assert.assertArrayEquals(a, methods.reduceToAfterFour(b));
    }
}
