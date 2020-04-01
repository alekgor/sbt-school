package com.sbt.unittest;

import org.junit.Assert;
import org.junit.Test;

public class DivTest {
    Calculator calculator = new Calculator();

    @Test
    public void testDiv() {
        Assert.assertEquals(5,calculator.div(10,2));
        Assert.assertEquals(1,calculator.div(10,10));
        Assert.assertEquals(0,calculator.div(0,2));
        Assert.assertEquals(-5,calculator.div(-10,2));
        Assert.assertEquals(5,calculator.div(-10,-2));
    }
}
