package com.sbt.unittest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ParametersSumTest {
    private Calculator calculator = new Calculator();

    @Parameterized.Parameter
    public int a;
    @Parameterized.Parameter(1)
    public int b;
    @Parameterized.Parameter(2)
    public int expected;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 2, 3},
                {0, 19, 19},
                {0, 0, 0},
                {-10, 10, 0},
                {-10, -10, -20}
        });
    }

    @Test
    public void testSum() {
        int result = calculator.sum(a, b);
        Assert.assertEquals(this.expected, result);
    }


}